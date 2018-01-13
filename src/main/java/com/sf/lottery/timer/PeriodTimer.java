package com.sf.lottery.timer;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.Period;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.Tools;

@Component
public class PeriodTimer {
	private final Logger logger = LoggerFactory.getLogger(PeriodTimer.class);
	@Resource
	private Context context;
	@Resource
	private IPeriodService periodService;

	/**
	 * 创建期数定时任务
	 */
	@Scheduled(fixedRate=1000)
	public void createPeriod(){
		Period period = context.getWaitOpenPeriod(1);
		if(period != null && period.getStatus() != 1){
			long finishTime = period.getFinishTime().getTime();
			long nowTime = Instant.now().toEpochMilli();
			if(finishTime <= nowTime){
				String result = Tools.getRandomNum(5, 10);
				//TODO 这里后面加杀率
				boolean status = periodService.setPeriodResult(period.getId(), result);
				if(status){
					period.setResult(result);
					period.setStatus(1);
				}
				logger.info("=======成功开奖========");
			}
		}
		logger.info("==========定时器=========={}", LocalDateTime.now());
	}
	
	/**
	 * 获取当前期数
	 */
	@Scheduled(fixedRate=500)
	public void createNowPeriod(){
		int nowHour = LocalDateTime.now().getHour();
		//在每天2点到10点间不进行处理(因为这段时间没有期数)
		if(nowHour <= 2 || nowHour >= 10){
			Period currentPeriod = context.getCurrentPeriod(1);
			if(currentPeriod == null){
				addNowPeriod();
			}else{
				long finishTime = currentPeriod.getFinishTime().getTime();
				long nowTime = Instant.now().toEpochMilli();
				if(finishTime <= nowTime){
					context.removeCurrentPeriod(currentPeriod.getGameId());
					context.addWaitOpenPeriod(currentPeriod);
					addNowPeriod();
				}
			}
		}
	}
	
	/**
	 * 获取当前期数(当没有期数时会进行当天期数的生成操作)
	 */
	private void addNowPeriod() {
		Period period = periodService.getNowPeriod(1);
		if(period == null){
			boolean result = periodService.initPeriod();
			if(result){
				logger.info("create tody period suscess.");
			}else{
				logger.error("create tody period failed.");
			}
		}else{
			context.addCurrentPeriod(period);
			logger.info("add new period success.");
		}
	}
	
}
