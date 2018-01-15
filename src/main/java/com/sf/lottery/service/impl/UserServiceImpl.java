package com.sf.lottery.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.lottery.common.IdGenerator;
import com.sf.lottery.entity.User;
import com.sf.lottery.mapper.IUserMapper;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.Tools;

/**
 * 用户管理服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IdGenerator idGenerator;
	@Resource
	private IUserMapper userMapper;

	@Override
	public boolean addUser(String account, String pwd) throws Exception {
		long id = idGenerator.createId();
		pwd = Tools.MD5(id + pwd);
		User user = new User(id, account, pwd, new Timestamp(System.currentTimeMillis()));
		int result = userMapper.insertUser(user);
		return result == 1;
	}

	@Override
	public User getUserByName(String name) {
		User user = userMapper.selectUserByName(name);
		return user;
	}

	@Override
	public User login(String name, String pwd) throws Exception {
		User user = userMapper.selectUserByName(name);
		if(user == null){
			return null;
		}else{
			pwd = Tools.MD5(user.getId() + pwd);
			return user.getPwd().equals(pwd) ? user : null;
		}
	}

}
