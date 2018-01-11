package com.sf.lottery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.lottery.entity.Project;
import com.sf.lottery.mapper.IProjectMapper;
import com.sf.lottery.service.IProjectService;

/**
 *  投注项服务实现类
 */
@Service
public class ProjectServiceImpl implements IProjectService {
	@Resource
	private IProjectMapper projectMapper;
	
    @Override
    public Project getProject(int projectId) {
        return null;
    }

	@Override
	public List<Project> getAllProject() {
		List<Project> list = projectMapper.selectAllProject();
		return list;
	}
}
