package com.sf.lottery.service;

import java.util.List;

import com.sf.lottery.entity.Project;

/**
 * 投注项服务接口
 */
public interface IProjectService {
	
	/**
	 * 根据编号获取投注项
	 * @param projectId 投注项编号
	 * @return 投注项对象(当没有对应编号时将返回Null)
	 */
	Project getProject(int projectId);
	
	/**
	 * 获取所有的投注项
	 * @return 投注项列表(当查询失败时将返回Null)
	 */
	List<Project> getAllProject();
}
