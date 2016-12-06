package com.github.api.processor.elements;

public class Header {

	private String name;
	private String value;

	public Header(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
