package com.sf.lottery.security.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordErrorException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public PasswordErrorException() {
		super("user name or password error.");
	}
	
}
