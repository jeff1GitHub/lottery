package com.sf.lottery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sf.lottery.entity.Betting;

public interface IBettingMapper {
	
	/**
	 * 添加注单
	 * @param betting 注单对象
	 * @return 添加结果(1:成功)
	 */
	int insertBetting(Betting betting);
	
	/**
	 * 根据彩票编号和期号查询注单
	 * @param lotteryId 彩票编号
	 * @param period 期号
	 * @return 注单列表(当查询失败时将返回Null)
	 */
	List<Betting> selectBetting(@Param("lotteryId") int lotteryId, @Param("period") String period);
	
}