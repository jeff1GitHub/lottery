package com.sf.lottery.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PeriodTimer {

	/**
	 * 创建期数定期任务
	 */
	@Scheduled(fixedRate=20000)
	public void createPeriod(){
		
	}
	
}
