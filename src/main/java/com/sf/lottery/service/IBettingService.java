package com.sf.lottery.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.BettingNum;
import com.sf.lottery.entity.BettingProject;
import com.sf.lottery.entity.BettingSquareInfo;
import com.sf.lottery.entity.BettingSquareSummary;
import com.sf.lottery.entity.PageInfo;

/**
 * 彩票服务接口
 */
public interface IBettingService {
	
	/**
     * 保存注单
     * @param bettings 注单列表
     * @return 结果(true:保存成功  false:保存失败)
     */
    boolean saveBetting(List<Betting> bettings);
    
    /**
	 * 根据结算状态获取注单
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 * @param square 注单结算状态
	 * @param pageNum 页码
	 * @return 注单页(当查询失败时将返回Null)
	 */
    PageInfo getBettingBySquare(int lotteryId, String period, int square, int pageNum);
	
	/**
	 * 根据条件查询注单投注项数量
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 */
	List<BettingProject> getBettingProject(int lotteryId, String period);
	
	
    /**
     * 通过彩票编号和彩票期号获取所有注单
     * @param lotteryId 彩票编号
     * @param period 彩票期数
     * @param pageNum 页数
     * @return 注单页(获取失败时将返回Null)
     */
    PageInfo getBettingList(int lotteryId, String period, int pageNum);
    
    /**
	 * 根据彩票编号查询注单分页
     * @param lotteryId 彩票编号
     * @param pageNum 查询页码
     * @param name 投注账号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 注单列表
     */
    PageInfo getBettingPage(int lotteryId, int pageNum, String name, LocalDateTime startTime, LocalDateTime endTime);

    /**
	 * 批量更新注单结算
	 * @param list 结算信息列表
	 * @return 批量更新数量
	 */
	int batchSquareBetting(List<BettingSquareInfo> list);
	
	/**
	 * 根据帐号查询注单结算汇总
	 * @param lotteryId 彩票编号
	 * @param acc 投注账号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return BettingSquareSummary
	 */
	BettingSquareSummary getBettingSquare(@Param("lotteryId") int lotteryId, @Param("acc") String acc, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
	
	/**
	 * 根据帐号查询各种状态注单数量
	 * @param lotteryId 彩票编号
	 * @param acc 投注账号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return BettingNum
	 */
	BettingNum getBettingNum(@Param("lotteryId") int lotteryId, @Param("acc") String acc, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    
}
