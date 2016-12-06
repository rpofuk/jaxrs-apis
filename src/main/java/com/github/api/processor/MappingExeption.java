package com.github.api.processor;

public class MappingExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MappingExeption(Exception cause) {
		super(cause);
	}
}
