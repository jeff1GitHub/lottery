package com.sf.lottery.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.BettingNum;
import com.sf.lottery.entity.BettingSquareSummary;
import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.enums.AuthorityName;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.utils.DateTools;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

@RestController()
@RequestMapping("/admin/betting")
public class WebBettingController {
	@Resource
    private IBettingService bettingService;
	
	@RequestMapping(value = "betting_page", method = RequestMethod.POST)
	@Secured(AuthorityName.ROLE_ADMIN)
    public JsonResult<PageInfo> bettingPage(int pageNum, int draw, String name, String startTime, String endTime) {
		LocalDateTime start = DateTools.formatDateTime(startTime, "yyyy-MM-dd HH:mm:ss");
		LocalDateTime end = DateTools.formatDateTime(endTime, "yyyy-MM-dd HH:mm:ss");
        		
		PageInfo info = bettingService.getBettingPage(1, pageNum, name, start, end);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, String.valueOf(draw), info);
		return result;
    }
	
	@RequestMapping(value = "betting_square", method = RequestMethod.POST)
	@Secured(AuthorityName.ROLE_ADMIN)
	public JsonResult<BettingSquareSummary> bettingSquareSummary(String name, String startTime, String endTime) {
		LocalDateTime start = DateTools.formatDateTime(startTime, "yyyy-MM-dd HH:mm:ss");
		LocalDateTime end = DateTools.formatDateTime(endTime, "yyyy-MM-dd HH:mm:ss");
		
		BettingSquareSummary summary = bettingService.getBettingSquare(1, name, start, end);
		JsonResult<BettingSquareSummary> result = new JsonResult<>(ResultCode.SUCCESS, summary);
		return result;
	}
	
	@RequestMapping(value = "betting_num", method = RequestMethod.POST)
	@Secured(AuthorityName.ROLE_ADMIN)
	public JsonResult<BettingNum> bettingNum(String name, String startTime, String endTime) {
		LocalDateTime start = DateTools.formatDateTime(startTime, "yyyy-MM-dd HH:mm:ss");
		LocalDateTime end = DateTools.formatDateTime(endTime, "yyyy-MM-dd HH:mm:ss");
		
		BettingNum bettingNum = bettingService.getBettingNum(1, name, start, end);
		JsonResult<BettingNum> result = new JsonResult<>(ResultCode.SUCCESS, bettingNum);
		return result;
	}
	
}
