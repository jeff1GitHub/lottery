package com.sf.lottery.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.sf.lottery.entity.Period;
import com.sf.lottery.entity.Project;
import com.sf.lottery.entity.User;

@Component
public class Context {
	/** 服务器开关 */
	private boolean isOpen = false;
	
	/** 投注项集合 */
	private final Map<Integer, Project> projectMap = new HashMap<>();
	/** 上期期数集合(key:游戏编号  value:期数) */
	private final ConcurrentHashMap<Integer, Period> beforPeriodMap = new ConcurrentHashMap<>();
	/** 当前期数集合(key:游戏编号  value:期数) */
	private final ConcurrentHashMap<Integer, Period> currentPeriodMap = new ConcurrentHashMap<>();
	
	/** 登录帐号集合(key:帐号  value:帐号对象) */
	private final Map<String, User> userMap = new ConcurrentHashMap<>();
	
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
	
	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * 获取投注项
	 * @param projectId 投注项编号
	 * @return 投注项
	 */
	public Project getProjectById(int projectId) {
		return projectMap.get(projectId);
	}
	
	public User getUser(String acc) {
		User user = userMap.get(acc);
		return user;
	}
	
	public void addUser(User user) {
		userMap.put(user.getName(), user);
	}
	
	public void removeUser(String acc) {
		userMap.remove(acc);
	}
	
	public Period getCurrentPeriod(int gameId) {
		return currentPeriodMap.get(gameId);
	}
	
	public void addCurrentPeriod(Period period) {
		currentPeriodMap.put(period.getGameId(), period);
	}
	
	public void removeCurrentPeriod(int gameId) {
		this.currentPeriodMap.remove(gameId);
	}
	
	public void addBeforPeriod(Period period) {
		this.beforPeriodMap.put(period.getGameId(), period);
	}
	
	public Period getBeforPeriod(int gameId) {
		return beforPeriodMap.get(gameId);
	}
	
}
