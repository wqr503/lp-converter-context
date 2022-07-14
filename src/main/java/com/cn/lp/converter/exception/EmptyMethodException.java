package com.cn.lp.converter.exception;

/**
 * 没有对应方法异常
 * @author qirong
 */
public class EmptyMethodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyMethodException() {
		super();
	}

	public EmptyMethodException(String message) {
		super(message);
	}

	public EmptyMethodException(String message, Throwable cause) {
		super(message, cause);
	}
}
