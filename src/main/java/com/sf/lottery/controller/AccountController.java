package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.User;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

@RestController
@RequestMapping("/lottery")
public class AccountController {
	@Resource
	private Context context;
	@Resource
	private IUserService userService;
	@Resource
	private IManagerService managerService;
	
	@RequestMapping(value = "user/status", method = RequestMethod.POST)
	public JsonResult<String> userStatus() {
		String acc = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = context.getUser(acc);
		if(user == null){
			return new JsonResult<>(ResultCode.NOT_LOGIN, "登录超时，请重新登录!");
		}else{
			return new JsonResult<>(ResultCode.SUCCESS, acc);
		}
	}
	
	@RequestMapping("user/exit")
	public void userExit() {
		String acc = SecurityContextHolder.getContext().getAuthentication().getName();
		context.removeUser(acc);
	}

}
