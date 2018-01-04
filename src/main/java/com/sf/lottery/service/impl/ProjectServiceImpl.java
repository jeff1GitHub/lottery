package com.sf.lottery.service.impl;

import com.sf.lottery.entity.Project;
import com.sf.lottery.mapper.ProjectMapper;
import com.sf.lottery.service.IProjectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Override
    public Project getProject(Integer projectId) {
        return super.selectById(projectId);
    }
}
