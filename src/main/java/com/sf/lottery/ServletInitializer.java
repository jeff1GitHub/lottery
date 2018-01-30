package com.sf.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sf.lottery.security.ServerFilter;

@SpringBootApplication
@MapperScan("com.sf.lottery.mapper")
@EnableScheduling // 开启扫描定时器
@EnableCaching // 标注启用缓存
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/lottery/*");
		registrationBean.setFilter(new ServerFilter());
		return registrationBean;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletInitializer.class);
	}

}
