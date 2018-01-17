package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.Manager;
import com.sf.lottery.entity.User;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.utils.Tools;
import com.sf.lottery.vo.UserLoginResult;

@RestController
@RequestMapping("/lottery")
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Resource
	private IUserService userService;
	@Resource
	private IManagerService managerService;

	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public JsonResult<UserLoginResult> userLogin(String account, String pwd) {
		try {
			User user = userService.login(account, Tools.MD5(account + pwd));
			if(user == null){
				return new JsonResult<>(ResultCode.PARAMS_ERROR, "登录失败，帐号或密码错误!");
			}else{
				UserLoginResult info = new UserLoginResult(user.getName(), "aaaa");
				return new JsonResult<>(ResultCode.SUCCESS, info);
			}
		} catch (Exception e) {
			logger.error("user login failed.", e);
			return new JsonResult<>(ResultCode.SYS_ERROR);
		}
	}
	
	@RequestMapping(value = "user/create")
	public JsonResult<String> createUser(String account, String pwd) {
		try {
			pwd = Tools.MD5(account + pwd);
			boolean result = userService.addUser(account, pwd);
			if(result){
				return new JsonResult<>(ResultCode.SUCCESS, "注册成功!");
			}else{
				return new JsonResult<>(ResultCode.SYS_ERROR, "注册失败!");
			}
		} catch (Exception e) {
			logger.error("create user failed.", e);
			return new JsonResult<>(ResultCode.SYS_ERROR);
		}
	}
	
	@RequestMapping(value = "manager/login")
	public JsonResult<Manager> managerLogin() {
		return null;
	}
	
}
