package com.sf.lottery.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.sf.lottery.entity.Period;
import com.sf.lottery.entity.Project;

@Component
public class Context {
	/** 投注项集合 */
	private final Map<Integer, Project> projectMap = new HashMap<>();
	/** 当前期数 */
	private final Map<Integer, Period> currentPeriodMap = new ConcurrentHashMap<>();
	
	/**
	 * 初始化投注项集合
	 * @param list 投注项队列
	 */
	public void initProjectMap(List<Project> list) {
		this.projectMap.clear();
		list.forEach(pro -> {
			projectMap.put(pro.getId(), pro);
		});
	}
	
	/**
	 * 获取投注项
	 * @param projectId 投注项编号
	 * @return 投注项
	 */
	public Project getProjectById(int projectId) {
		return projectMap.get(projectId);
	}
	
	public Period getCurrentPeriod(int lotteryId) {
		return currentPeriodMap.get(lotteryId);
	}
	
	public void addCurrentPeriod(Period period) {
		currentPeriodMap.put(period.getGameId(), period);
	}
	
}
