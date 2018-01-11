package com.sf.lottery.common;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sf.lottery.entity.Project;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.service.IProjectService;

/**
 * 初始化彩票期数(服务启动执行)
 */
@Component
public class InitPeriodRunner implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(InitPeriodRunner.class);
	@Resource
	private IPeriodService periodService;
	@Resource
	private IProjectService projectService;
	@Resource
	private Context context;

	@Override
	public void run(String... args) throws Exception {
		boolean result = periodService.initPeriod();
		if(result){
			logger.info("--------初始化期数完成--------");
		}else{
			logger.error("--------初始化期数失败--------");
		}
		
		List<Project> list = projectService.getAllProject();
		this.context.initProjectMap(list);
		logger.info("==========所有初始化完成===========");
	}

}
