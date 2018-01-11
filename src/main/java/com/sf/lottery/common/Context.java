package com.sf.lottery.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sf.lottery.entity.Project;

@Component
public class Context {
	/** 投注项集合 */
	private final Map<Integer, Project> projectMap = new HashMap<>();
	
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
	
}
