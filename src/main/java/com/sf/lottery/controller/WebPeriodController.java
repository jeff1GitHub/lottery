package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.enums.AuthorityName;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@RestController
@RequestMapping("/manager/period")
public class WebPeriodController {
	@Resource
    private IPeriodService periodService;
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "periodPage")
	public JsonResult<PageInfo> getPeriodPage(String date, int pageNum, int draw) {
		PageInfo info = periodService.getPeriodByDate(1, date, pageNum);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, String.valueOf(draw), info);
		return result;
	}
	
}
