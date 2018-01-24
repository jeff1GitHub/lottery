package com.sf.lottery.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.utils.DateTools;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

@RestController()
@RequestMapping("/manager/betting")
public class WebBettingController {
	@Resource
    private IBettingService bettingService;
	
	@RequestMapping(value = "bettingPage", method = RequestMethod.POST)
    public JsonResult<PageInfo> bettingPage(int pageNum, int draw, String name, String startTime, String endTime) {
		LocalDateTime start = DateTools.formatDateTime(startTime, "yyyy-MM-dd HH:mm:ss");
		LocalDateTime end = DateTools.formatDateTime(endTime, "yyyy-MM-dd HH:mm:ss");
        		
		PageInfo info = bettingService.getBettingPage(1, pageNum, name, start, end);
		JsonResult<PageInfo> result = new JsonResult<PageInfo>(ResultCode.SUCCESS, String.valueOf(draw), info);
		return result;
    }
	
}
