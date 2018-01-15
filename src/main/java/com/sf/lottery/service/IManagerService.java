package com.sf.lottery.service;

import com.sf.lottery.entity.Manager;

/**
 * 管理员服务接口
 */
public interface IManagerService {

	/**
	 * 添加管理帐号
	 * @param manager 管理帐号对象
	 * @return 添加结果(true:添加成功 false:添加失败)
	 */
	boolean addManager(Manager manager);
	
	/**
	 * 根据名称查询管理帐号 
	 * @param name 名称
	 * @return 管理帐号
	 */
	Manager getManagerByName(String name);
	
}
