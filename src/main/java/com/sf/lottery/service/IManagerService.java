package com.sf.lottery.service;

import com.sf.lottery.entity.Manager;
import com.sf.lottery.entity.PageInfo;

/**
 * 管理员服务接口
 */
public interface IManagerService {

	/**
	 * 添加管理帐号
	 * @param account 账号
	 * @param pwd 密码
	 * @return 添加状态(true:添加成功 false:添加失败)
	 * @throws Exception
	 */
	boolean addManager(String account, String pwd) throws Exception;
	
	/**
	 * 根据名称查询管理帐号 
	 * @param name 名称
	 * @return 管理帐号
	 */
	Manager getManagerByName(String name);
	
	/**
	 * 管理员登录
	 * @param name 帐号
	 * @param pwd 密码
	 * @return 管理员对象
	 * @throws Exception
	 */
	Manager login(String name, String pwd) throws Exception;
	
	/**
	 * 获取管理员分页
	 * @param pageNum 页码
	 * @return 管理员分页
	 */
	PageInfo getManagerPage(int pageNum);
}
