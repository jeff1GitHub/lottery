package com.sf.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.InitBinder;

@SpringBootApplication
@MapperScan("com.sf.lottery.entity")
@EnableScheduling//开启扫描定时器
@EnableCaching//标注启用缓存
public class LotteryApplication {

	@InitBinder
	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}
	
}
