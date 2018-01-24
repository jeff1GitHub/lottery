package com.sf.lottery.timer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.BettingSquareInfo;
import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.entity.Period;
import com.sf.lottery.enums.ProjectEnum;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.Tools;

@Component
public class PeriodTimer {
	private final Logger logger = LoggerFactory.getLogger(PeriodTimer.class);
	@Resource
	private Context context;
	@Resource
	private IPeriodService periodService;
	@Resource
	private IBettingService bettingService;
	/** 是否是第一次执行开奖定时任务 */
	private boolean isFirstRunOpenPeriodResult = true;

	/**
	 * 期数开奖定时任务
	 */
	@Scheduled(fixedRate=1000)
	public void OpenPeriodResult() {
		if(isFirstRunOpenPeriodResult){
			List<Period> list = periodService.getPeriodByStatus(1, LocalDateTime.now(), 0);
			list.forEach(period -> {
				setPeriodResult(period);
			});
			isFirstRunOpenPeriodResult = false;
		}
		
		Period period = context.getWaitOpenPeriod(1);
		if(period != null && period.getStatus() != 1){
			Instant finishTime = period.getFinishTime().atZone(ZoneId.systemDefault()).toInstant();
			if(!finishTime.isAfter(Instant.now())){
				setPeriodResult(period);
			}
		}
//		logger.info("==========定时器=========={}", LocalDateTime.now());
	}
	
	/**
	 * 获取当前期数
	 */
	@Scheduled(fixedRate=500)
	public void createNowPeriod() {
		int nowHour = LocalDateTime.now().getHour();
		//在每天2点到10点间不进行处理(因为这段时间没有期数)
		if(nowHour < 2 || nowHour >= 10){
			Period currentPeriod = context.getCurrentPeriod(1);
			if(currentPeriod == null){
				addNowPeriod();
			}else{
				Instant finishTime = currentPeriod.getFinishTime().atZone(ZoneId.systemDefault()).toInstant();
				if(!finishTime.isAfter(Instant.now())){
					context.removeCurrentPeriod(currentPeriod.getGameId());
					context.addWaitOpenPeriod(currentPeriod);
					addNowPeriod();
				}
			}
		}
	}
	
	/**
	 * 设置期数开奖结果
	 * @param period 期数
	 */
	private void setPeriodResult(Period period) {
		int[] result = Tools.getRandomNum(5, 10);
		StringBuilder tempResult = new StringBuilder();
		for(int num : result){
			tempResult.append(num).append(",");
		}
		tempResult.delete(tempResult.length(), tempResult.length());
		String resultStr = tempResult.toString();
		
		//TODO 这里后面加杀率
		boolean status = periodService.setPeriodResult(period.getId(), resultStr);
		if(status){
			period.setResult(resultStr);
			period.setStatus(1);
			logger.info("=======成功开奖========");
			
			PageInfo page = bettingService.getBettingBySquare(period.getGameId(), period.getCode(), 0, 1);
			while(page != null && page.getTotal() > 0){
				List<BettingSquareInfo> list = new ArrayList<>();
				BettingSquareInfo info = null;
				for(Object obj : page.getResult()){
					info = bettingSquare(result, (Betting)obj);
					list.add(info);
				}
				
				int updateNum = bettingService.batchSquareBetting(list);
				logger.info("barch update num:{} total:{}", updateNum, list.size());
				
				page = bettingService.getBettingBySquare(period.getGameId(), period.getCode(), 0, 1);
			}
		}else{
			logger.error("set period result failed. period code:{} and lottery id:{}", period.getCode(), period.getGameId());
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
			logger.info("add new period success. code:{}", period.getCode());
		}
	}
	
	private BettingSquareInfo bettingSquare(int[] result, Betting betting) {
		int totle = 0;
		for(int num : result){
			totle += num;
		}
		
		boolean isSumBig = totle >= 23;
		boolean isSumSingle = totle % 2 == 1;
		int sumLastNum = totle % 10;
		boolean isBeforThreeSame = result[0] == result[1] && result[0] == result[2];
		boolean isMidlleThreeSame = result[1] == result[2] && result[1] == result[3];
		boolean isLastThreeSame = result[2] == result[3] && result[2] == result[4];
		
		BettingSquareInfo info = ProjectEnum.square(betting, result, isSumBig, isSumSingle, sumLastNum, isBeforThreeSame, isMidlleThreeSame, isLastThreeSame);
		if(info == null){
			logger.error("betting square failed. period code:{} and lottery id:{}", betting.getPeriod(), betting.getLotteryId());
			return null;
		}else{
			return info;
		}
	}
	
}
