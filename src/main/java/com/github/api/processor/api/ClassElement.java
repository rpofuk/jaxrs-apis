package com.github.api.processor.api;

public interface ClassElement {

	public void accept(ClassVisitor visitor);
}
