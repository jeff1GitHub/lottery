package com.sf.lottery.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.lottery.entity.Manager;
import com.sf.lottery.mapper.IManagerMapper;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.utils.Tools;

/**
 * 管理员服务实现类
 */
@Service
public class ManagerServiceImpl implements IManagerService {
	@Resource
	private IManagerMapper managerMapper;

	@Override
	public boolean addManager(Manager manager) {
		int result = managerMapper.insertManager(manager);
		return result == 1;
	}

	@Override
	public Manager getManagerByName(String name) {
		Manager manager = managerMapper.selectManagerByName(name);
		return manager;
	}
	
	@Override
	public Manager login(String name, String pwd) throws Exception {
		Manager manager = managerMapper.selectManagerByName(name);
		if(manager == null){
			return null;
		}else{
			pwd = Tools.MD5(manager.getId() + pwd);
			return manager.getPwd().equals(pwd) ? manager : null;
		}
	}

}
