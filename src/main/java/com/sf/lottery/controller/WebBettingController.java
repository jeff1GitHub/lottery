package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

@RestController()
@RequestMapping("/manager/betting")
public class WebBettingController {
	@Resource
    private IBettingService bettingService;
	
	@RequestMapping(value = "bettingPage", method = RequestMethod.POST)
    public JsonResult<PageInfo> bettingPage(int pageNum) {
		PageInfo info = bettingService.getBettingPage(1, pageNum);
		JsonResult<PageInfo> result = new JsonResult<PageInfo>(ResultCode.SUCCESS, info);
		return result;
    }
	
}
