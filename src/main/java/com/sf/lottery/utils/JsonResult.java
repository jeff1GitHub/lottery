package com.sf.lottery.utils;

/**
 * 返回页面对象
 */
public class JsonResult<T> {
    private String code;
    private String message;
    private T data;

    public JsonResult(ResultCode code) {
        this.code = code.val();
        this.message = code.msg();
    }

    public JsonResult(ResultCode code, String message) {
    	this.code = code.val();
        this.message = message;
    }
    
    public JsonResult(ResultCode code, T data) {
        this(code);
        this.data = data;
    }

    public JsonResult(ResultCode code, String message, T data) {
        this(code, message);
        this.data = data;
    }

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

}

