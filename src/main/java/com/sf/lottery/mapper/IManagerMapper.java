package com.sf.lottery.mapper;

import java.util.List;

import com.sf.lottery.entity.Manager;

public interface IManagerMapper {

	/**
	 * 添加管理帐号
	 * @param manager 管理帐号对象
	 * @return 添加结果
	 */
	int insertManager(Manager manager);
	
	/**
	 * 根据名称查询管理帐号 
	 * @param name 名称
	 * @return 管理帐号
	 */
	Manager selectManagerByName(String name);
	
	/**
	 * 查询管理员列表
	 * @return 管理员列表
	 */
	List<Manager> selectManager();
}
