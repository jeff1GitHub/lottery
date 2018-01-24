package com.sf.lottery.mapper;

import java.util.List;

import com.sf.lottery.entity.User;

public interface IUserMapper {

	/**
	 * 添加用户信息
	 * @param user 用户信息对象
	 * @return 添加状态
	 */
	int insertUser(User user);
	
	/**
	 * 根据名称查询用户
	 * @param name 名称
	 * @return 用户对象
	 */
	User selectUserByName(String name);
	
	/**
	 * 查询用户列表
	 * @return 用户列表
	 */
	List<User> selectUser();
	
	/**
	 * 查询所有用户名
	 * @return 用户名列表
	 */
	List<String> selectUserName();
	
}
