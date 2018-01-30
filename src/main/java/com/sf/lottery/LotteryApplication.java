package com.sf.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sf.lottery.security.ServerFilter;

@SpringBootApplication
@MapperScan("com.sf.lottery.mapper")
@EnableScheduling // 开启扫描定时器
@EnableCaching // 标注启用缓存
public class LotteryApplication {
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/lottery/*");
		registrationBean.setFilter(new ServerFilter());
		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}
}
