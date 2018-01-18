package com.sf.lottery.security;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private AuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 关闭csrf验证
		http.csrf().disable();
		// 对请求进行认证
		http.authorizeRequests()
			// 对主页和资源以及期数信息放行
			.antMatchers("/index.html").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/lottery/period/**").permitAll()
			// 对以POST请求的登录放行
			.antMatchers(HttpMethod.POST, "/lottery/user/login").permitAll()
			.antMatchers(HttpMethod.POST, "/lottery/manager/login").permitAll()
			// 权限检查
			//.antMatchers("/lottery/**").hasAuthority("AUTH_WRITE");
			// 角色检查
			//.antMatchers("/world").hasRole("ADMIN")
			// 对请求需要身份认证
			.anyRequest().authenticated().and();
		// 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
		http.addFilterBefore(new JWTLoginFilter("/lottery/user/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		// 添加一个过滤器验证其他请求的Token是否合法
		http.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
        auth.authenticationProvider(authenticationProvider);
	}

}
