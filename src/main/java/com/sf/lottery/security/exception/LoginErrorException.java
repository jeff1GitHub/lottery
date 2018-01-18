package com.sf.lottery.security.exception;

import org.springframework.security.core.AuthenticationException;

public class LoginErrorException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public LoginErrorException(String msg) {
		super(msg);
	}
	
	public LoginErrorException(String msg, Throwable t) {
		super(msg, t);
	}
}
