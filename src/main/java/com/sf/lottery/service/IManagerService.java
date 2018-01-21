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
	
	/**
	 * 用户登录
	 * @param name 帐号
	 * @param pwd 密码
	 * @return 用户对象
	 * @throws Exception
	 */
	Manager login(String name, String pwd) throws Exception;
}
