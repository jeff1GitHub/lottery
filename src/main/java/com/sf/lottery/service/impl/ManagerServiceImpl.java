package com.sf.lottery.service.impl;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sf.lottery.common.Constant;
import com.sf.lottery.common.IdGenerator;
import com.sf.lottery.entity.Manager;
import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.mapper.IManagerMapper;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.utils.Tools;

/**
 * 管理员服务实现类
 */
@Service
public class ManagerServiceImpl implements IManagerService {
	@Resource
	private IdGenerator idGenerator;
	@Resource
	private IManagerMapper managerMapper;

	@Override
	public boolean addManager(String account, String pwd) throws Exception {
		long id = idGenerator.createId();
		pwd = Tools.MD5(id + pwd);
		Manager manager = new Manager(id, account, pwd, LocalDateTime.now());
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

	@Override
	public PageInfo getManagerPage(int pageNum) {
		PageHelper.startPage(pageNum, Constant.MANAGER_PAGE_SIZE);
		Page<Manager> page = (Page<Manager>)managerMapper.selectManager();
		return page == null ? null : new PageInfo(page);
	}

}
