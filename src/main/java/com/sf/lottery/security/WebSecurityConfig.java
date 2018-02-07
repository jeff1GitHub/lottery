package com.sf.lottery.security;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.sf.lottery.common.Context;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)// 开启方法级安全
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private Context serverContext;
	@Resource
	private AuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		
		// 由于使用的是JWT，我们这里不需要csrf
		http.csrf().disable();
		// 基于token，所以不需要session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		// 禁用缓存
		//http.headers().cacheControl();
		
		// 对请求进行认证
		http.authorizeRequests()
			// 允许对于网站静态资源的无授权访问
			.antMatchers(
					HttpMethod.GET,
					"/",
					"/*.html",
					"/favicon.ico",
					"/**/*.html",
					"/**/*.css",
					"/**/*.js",
					"/**/*.ttf",
					"/**/*.woff",
					"/**/*.png",
					"/**/*.jpg",
					"/**/*.gif"
			).permitAll()
			// 允许对期数信息的无授权访问
			.antMatchers("/lottery/period/**", "/indexData").permitAll()
			
			// 对以POST请求的登录放行
			.antMatchers(HttpMethod.POST, "/lottery/user/login").permitAll()
			.antMatchers(HttpMethod.POST, "/admin/login").permitAll()
			// 权限检查
			//.antMatchers("/lottery/**").hasAuthority("AUTH_WRITE");
			// 角色检查
			//.antMatchers("/world").hasRole("ADMIN")
			.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
			// 除上面外的所有请求全部需要身份认证
			.anyRequest().authenticated().and();
		
		// 系统维护过滤器
		http.addFilterBefore(new ServerFilter(this.serverContext, "/lottery/**", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		// 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
		http.addFilterBefore(new JWTLoginFilter("/lottery/user/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(new JWTLoginFilter("/admin/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		// 添加一个过滤器验证其他请求的Token是否合法
		http.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
        auth.authenticationProvider(this.authenticationProvider);
	}

}
