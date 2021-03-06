package com.sf.lottery.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

/**
 * RestController异常处理类
 */
@RestControllerAdvice
public class ResultExceptionHandle {
	private final Logger logger = LoggerFactory.getLogger(ResultExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonResult<Object> MethodArgumentNotValidHandler(HttpServletRequest request, Exception e) throws Exception {
		if(e instanceof BindException){
			BindException exc = (BindException)e;
			String errMsg = exc.getBindingResult().getFieldError().getDefaultMessage();
			return new JsonResult<>(ResultCode.EXCEPTION, errMsg);
		}else if(e instanceof IllegalStateException){
			return new JsonResult<>(ResultCode.PARAMS_ERROR);
		}else if(e instanceof AccessDeniedException){
			return new JsonResult<>(ResultCode.NO_PERMISSION);
		}else{
			logger.error("", e);
			return new JsonResult<>(ResultCode.SYS_ERROR);
		}
	}
	
}
