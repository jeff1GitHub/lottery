package com.sf.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.InitBinder;

@SpringBootApplication
@MapperScan("com.sf.lottery.mapper")
@EnableScheduling // 开启扫描定时器
@EnableCaching // 标注启用缓存
public class LotteryApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LotteryApplication.class);
	}
	
	@InitBinder
	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}

}
