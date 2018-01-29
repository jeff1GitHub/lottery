package com.sf.lottery.controller;

import java.util.List;

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
	
	@RequestMapping("user/page")
	@Secured(AuthorityName.ROLE_ADMIN)
	public JsonResult<PageInfo> getUserPage(int pageNum, int draw) {
		PageInfo info = userService.getUserPage(pageNum);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, String.valueOf(draw), info);
		return result;
	}
	
	@RequestMapping("admin/page")
	@Secured(AuthorityName.ROLE_ADMIN)
	public JsonResult<PageInfo> getManagerPage(int pageNum, int draw) {
		PageInfo info = managerService.getManagerPage(pageNum);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, String.valueOf(draw), info);
		return result;
	}
	
	
	@RequestMapping("user/all")
	@Secured(AuthorityName.ROLE_ADMIN)
	public JsonResult<List<String>> getUserName() {
		List<String> list = userService.getAllUserName();
		JsonResult<List<String>> result = new JsonResult<>(ResultCode.SUCCESS, list);
		return result;
	}
	
}
