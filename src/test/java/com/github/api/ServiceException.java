package com.github.api;

import java.text.MessageFormat;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ServiceException(String message, Throwable ex, Object... params) {
		super(MessageFormat.format(message, params), ex);
	}
	
	public ServiceException(String message, Object... params) {
		super(MessageFormat.format(message, params));
	}

}
