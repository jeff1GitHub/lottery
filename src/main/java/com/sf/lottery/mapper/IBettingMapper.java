package com.sf.lottery.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.BettingProject;
import com.sf.lottery.entity.BettingSquareInfo;

public interface IBettingMapper {
	
	/**
	 * 添加注单
	 * @param betting 注单对象
	 * @return 添加结果(1:成功)
	 */
	int insertBetting(Betting betting);
	
	/**
	 * 根据结算状态获取注单
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 * @param square 注单结算状态
	 * @return 注单列表(当查询失败时将返回Null)
	 */
	List<Betting> selectBettingBySquare(@Param("lotteryId") int lotteryId, @Param("period") String period, @Param("square") int square);
	
	/**
	 * 根据条件查询注单投注项数量
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 */
	List<BettingProject> selectBettingProject(@Param("lotteryId") int lotteryId, @Param("period") String period);
	
	/**
	 * 根据彩票编号和期号查询注单
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 * @return 注单列表(当查询失败时将返回Null)
	 */
	List<Betting> selectBetting(@Param("lotteryId") int lotteryId, @Param("period") String period);
	
	/**
	 * 注单结算
	 * @param bettingId 注单编号
	 * @param squareMoney 结算金额
	 * @param squareTime 结算时间
	 * @return 更新数据数量
	 */
	int updateSquareBetting(@Param("bettingId") int bettingId, @Param("squareMoney") BigDecimal squareMoney, @Param("squareTime") Timestamp squareTime);
	
	/**
	 * 批量更新注单结算
	 * @param list 结算信息列表
	 * @return 批量更新数量
	 */
	int batchUpdateSquareBetting(List<BettingSquareInfo> list);
	
}