package com.sf.lottery.service;

import com.sf.lottery.entity.User;

/**
 * 用户管理服务接口
 */
public interface IUserService {

	/**
	 * 添加用户信息
	 * @param account 账号
	 * @param pwd 密码
	 * @return 添加状态(true:添加成功 false:添加失败)
	 * @throws Exception
	 */
	boolean addUser(String account, String pwd) throws Exception;
	
	/**
	 * 根据名称查询用户
	 * @param name 名称
	 * @return 用户对象
	 */
	User getUserByName(String name);
	
	/**
	 * 用户登录
	 * @param name 帐号
	 * @param pwd 密码
	 * @return 用户对象
	 * @throws Exception
	 */
	User login(String name, String pwd) throws Exception;
	
}
