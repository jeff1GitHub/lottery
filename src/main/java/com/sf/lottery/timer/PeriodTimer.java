package com.sf.lottery.timer;

import java.time.Instant;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.Period;
import com.sf.lottery.utils.Tools;

@Component
public class PeriodTimer {
	@Resource
	private Context context;

	/**
	 * 创建期数定时任务
	 */
	@Scheduled(fixedRate=20000)
	public void createPeriod(){
		Period period = context.getCurrentPeriod(1);
		if(period != null){
			long endTime = period.getEndTime().getTime();
			long nowTime = Instant.now().toEpochMilli();
			if(endTime <= nowTime){
				String result = Tools.getRandomNum(5, 10);
				period.setResult(result);
				period.setStatus(1);
			}
		}
		System.out.println("==========定时器==========");
	}
	
}
