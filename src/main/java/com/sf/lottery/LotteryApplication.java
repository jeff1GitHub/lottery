package com.sf.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.sf.lottery.mapper")
@EnableScheduling // 开启扫描定时器
@EnableCaching // 标注启用缓存
public class LotteryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}
	
}
