package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.enums.AuthorityName;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

@RestController
@RequestMapping("/manager/account")
public class WebAccountController {
	@Resource
	private IUserService userService;
	@Resource
	private IManagerService managerService;

	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping("user/page")
	public JsonResult<PageInfo> getUserPage(int pageNum) {
		PageInfo info = userService.getUserPage(pageNum);
		JsonResult<PageInfo> result = new JsonResult<PageInfo>(ResultCode.SUCCESS, info);
		return result;
	}
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping("admin/page")
	public JsonResult<PageInfo> getManagerPage(int pageNum) {
		PageInfo info = managerService.getManagerPage(pageNum);
		JsonResult<PageInfo> result = new JsonResult<PageInfo>(ResultCode.SUCCESS, info);
		return result;
	}
	
}
