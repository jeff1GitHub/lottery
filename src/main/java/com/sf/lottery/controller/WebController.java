package com.sf.lottery.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.common.Context;
import com.sf.lottery.enums.AuthorityName;
import com.sf.lottery.service.IManagerService;
import com.sf.lottery.service.IUserService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.utils.Tools;

@RestController
@RequestMapping("/admin")
public class WebController {
	private final Logger logger = LoggerFactory.getLogger(WebController.class);
	@Resource
	private Context context;
	@Resource
	private IUserService userService;
	@Resource
	private IManagerService managerService;

	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "login_status", method = RequestMethod.POST)
	public JsonResult<String> userStatus() {
		String acc = SecurityContextHolder.getContext().getAuthentication().getName();
		return new JsonResult<>(ResultCode.SUCCESS, acc);
	}
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "create/user", method = RequestMethod.POST)
	public JsonResult<String> createUser(String acc, String pwd) {
		try {
			pwd = Tools.MD5(acc + pwd);
			boolean result = userService.addUser(acc, pwd);
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
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "create/manager", method = RequestMethod.POST)
	public JsonResult<String> createManger(String acc, String pwd) {
		try {
			pwd = Tools.MD5(acc + pwd);
			boolean result = managerService.addManager(acc, pwd);
			if(result){
				return new JsonResult<>(ResultCode.SUCCESS, "注册成功!");
			}else{
				return new JsonResult<>(ResultCode.SYS_ERROR, "注册失败!");
			}
		} catch (Exception e) {
			logger.error("create manger failed.", e);
			return new JsonResult<>(ResultCode.SYS_ERROR);
		}
	}
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "server/status", method = RequestMethod.POST)
	public JsonResult<Boolean> serverStatus() {
		JsonResult<Boolean> result = new JsonResult<>(ResultCode.SUCCESS, context.isOpen());
		return result;
	}
	
	@Secured(AuthorityName.ROLE_ADMIN)
	@RequestMapping(value = "server/change_status", method = RequestMethod.POST)
	public JsonResult<Boolean> changeServerStatus(boolean status) {
		context.setOpen(status);
		JsonResult<Boolean> result = new JsonResult<>(ResultCode.SUCCESS, context.isOpen());
		return result;
	}
	
}
