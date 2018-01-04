package com.sf.lottery.service;

import com.sf.lottery.entity.Project;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
public interface IProjectService extends IService<Project> {
	Project getProject(Integer projectId);
}
