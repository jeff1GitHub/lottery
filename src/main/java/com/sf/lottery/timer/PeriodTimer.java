package com.sf.lottery.timer;

import java.math.BigDecimal;
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
	 * 定时处理当前期数
	 */
	@Scheduled(fixedRate=500)
	public void createNowPeriod() {
		bandleOverduePeriodResult();
		
		Period period = context.getCurrentPeriod(1);
		if(period == null){
			addNowPeriod();
		}else{
			Instant endTime = period.getEndTime().atZone(ZoneId.systemDefault()).toInstant();
			if(period.getStatus() != 1 && endTime.isBefore(Instant.now())){
				setPeriodResult(period);
			}
			
			Instant finishTime = period.getFinishTime().atZone(ZoneId.systemDefault()).toInstant();
			if(!finishTime.isAfter(Instant.now())){
				context.removeCurrentPeriod(period.getGameId());
				context.addBeforPeriod(period);
				addNowPeriod();
			}
		}
	}
	
	/**
	 * 对过期期数进行开奖结算
	 */
	private void bandleOverduePeriodResult() {
		//当第一次开始服务时，查询当前时间之前切没有开奖的期数，进行开奖结算操作
		if(isFirstRunOpenPeriodResult){
			List<Period> list = periodService.getPeriodByStatus(1, LocalDateTime.now(), 0);
			list.forEach(period -> {
				setPeriodResult(period);
			});
			isFirstRunOpenPeriodResult = false;
		}
	}
	
	/**
	 * 获取当前期数(当没有期数时会进行当天期数的生成操作)
	 */
	private void addNowPeriod() {
		Period period = periodService.getNowShowPeriod(1);
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
	
	/**
	 * 设置期数开奖结果并结算
	 * @param period 期数
	 */
	private void setPeriodResult(Period period) {
		List<Betting> bettingList = bettingService.getBettingBySquare(period.getGameId(), period.getCode(), 0);
		int[] result;
		long nowTime = System.currentTimeMillis();
		if(bettingList.isEmpty()){
			result = Tools.getRandomNum(5, 10);
		}else{
			result = reckonPeriodResult(period, bettingList);
		}
		logger.info("-------use time:{}", (System.currentTimeMillis() - nowTime));
		
		StringBuilder tempResult = new StringBuilder();
		for(int num : result){
			tempResult.append(num).append(",");
		}
		tempResult.delete(tempResult.length() - 1, tempResult.length());
		String resultStr = tempResult.toString();
		
		
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
	
	private BettingSquareInfo bettingSquare(int[] result, Betting betting) {
		int totle = 0;
		for(int num : result){
			totle += num;
		}
		
		//是否总和大
		boolean isSumBig = totle >= 23;
		//是否总和单
		boolean isSumSingle = totle % 2 == 1;
		//总和尾数
		int sumLastNum = totle % 10;
		//前三
		boolean isBeforThreeSame = result[0] == result[1] && result[0] == result[2];
		//中三
		boolean isMidlleThreeSame = result[1] == result[2] && result[1] == result[3];
		//后三
		boolean isLastThreeSame = result[2] == result[3] && result[2] == result[4];
		
		BettingSquareInfo info = ProjectEnum.square(betting, result, isSumBig, isSumSingle, sumLastNum, isBeforThreeSame, isMidlleThreeSame, isLastThreeSame);
		if(info == null){
			logger.error("betting square failed. period code:{} and lottery id:{}", betting.getPeriod(), betting.getLotteryId());
			return null;
		}else{
			return info;
		}
	}
	
	/**
	 * 计算期数开奖结果
	 * @param period
	 */
	private int[] reckonPeriodResult(Period period, List<Betting> list) {
		List<BettingSquareInfo> outList = new ArrayList<>();
		BigDecimal maxProfit = null;
		int[] perfectResult = new int[5];
		BigDecimal nowProfit;
		int[] result = new int[5];
		for(int k1=9; k1>=0; --k1){
			result[0] = k1;
			for(int k2=9; k2>=0; --k2){
				result[1] = k2;
				for(int k3=9; k3>=0; --k3){
					result[2] = k3;
					for(int k4=9; k4>=0; --k4){
						result[3] = k4;
						for(int k5=9; k5>=0; --k5){
							result[4] = k5;
							nowProfit = bettingSquare(result, list, outList);
							outList.clear();
							
							if(maxProfit == null || maxProfit.compareTo(nowProfit) == -1) {
								maxProfit = nowProfit;
								System.arraycopy(result, 0, perfectResult, 0, result.length);
							}
						}
					}
				}
			}
		}
		return perfectResult;
	}
	
	private BigDecimal bettingSquare(int[] result, List<Betting> bettingList, List<BettingSquareInfo> outList) {
		int totle = 0;
		for(int num : result){
			totle += num;
		}
		
		//是否总和大
		boolean isSumBig = totle >= 23;
		//是否总和单
		boolean isSumSingle = totle % 2 == 1;
		//总和尾数
		int sumLastNum = totle % 10;
		//前三
		boolean isBeforThreeSame = result[0] == result[1] && result[0] == result[2];
		//中三
		boolean isMidlleThreeSame = result[1] == result[2] && result[1] == result[3];
		//后三
		boolean isLastThreeSame = result[2] == result[3] && result[2] == result[4];
		
		BigDecimal money = new BigDecimal(0);
		BettingSquareInfo info;
		for(Betting betting : bettingList){
			info = ProjectEnum.square(betting, result, isSumBig, isSumSingle, sumLastNum, isBeforThreeSame, isMidlleThreeSame, isLastThreeSame);
			if(info == null){
				logger.error("betting square failed. period code:{} and lottery id:{}", betting.getPeriod(), betting.getLotteryId());
				return null;
			}else{
				money = money.add(info.getSquareMoney());
				outList.add(info);
			}
		}
		return money;
	}
	
}
