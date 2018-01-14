package com.sf.lottery.mapper;

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
	 * @return用户对象
	 */
	User selectUserByName(String name);
	
}
