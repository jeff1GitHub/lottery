package com.sf.lottery.mapper;

import java.util.List;

import com.sf.lottery.entity.Project;

public interface IProjectMapper {
	
	/**
	 * 查询所有投注项
	 * @return 投注项列表(查询失败时将返回Null)
	 */
	public List<Project> selectAllProject();
	
}