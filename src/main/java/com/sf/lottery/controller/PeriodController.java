package com.sf.lottery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.Period;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.vo.PeriodVo;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@RestController
@RequestMapping("/lottery/period")
public class PeriodController {
	@Resource
	private Context context;
	@Resource
    private IPeriodService periodService;
	
	@RequestMapping(value = "nowPeriod")
	public JsonResult<PeriodVo> getNowPeriod() {
		Period period = context.getCurrentPeriod(1);
		PeriodVo vo = period == null ? null : new PeriodVo(period);
		return new JsonResult<>(ResultCode.SUCCESS, vo);
	}
	
	@RequestMapping(value = "beforPeriod")
	public JsonResult<PeriodVo> getBeforPeriod() {
		Period period = periodService.getBeforPeriod(1);
		PeriodVo vo = period == null ? null : new PeriodVo(period);
		return new JsonResult<>(ResultCode.SUCCESS, vo);
	}
	
}
