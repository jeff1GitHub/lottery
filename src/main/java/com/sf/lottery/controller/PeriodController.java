package com.sf.lottery.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.entity.Period;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.vo.PeriodVo;

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
		Period period = context.getBeforPeriod(1);
		PeriodVo vo = period == null ? null : new PeriodVo(period);
		return new JsonResult<>(ResultCode.SUCCESS, vo);
	}
	
	@RequestMapping(value = "periodPage")
	public JsonResult<PageInfo> getPeriodPage(int type, int pageNum) {
		LocalDate date = LocalDate.now();
		if(type != 1){//昨日
			date = date.minusDays(1);
		}
		String dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		PageInfo info = periodService.getHistoryPeriodByDate(1, dateStr, pageNum);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, info);
		return result;
	}
	
}
