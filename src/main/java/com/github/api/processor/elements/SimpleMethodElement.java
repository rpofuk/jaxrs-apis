package com.github.api.processor.elements;

import java.lang.reflect.Method;

import javax.ws.rs.Path;

import com.github.api.processor.api.MethodElement;
import com.github.api.processor.api.MethodVisitor;

public class SimpleMethodElement implements MethodElement {

	private Method method;

	public SimpleMethodElement(Method method) {
		this.method = method;
	}

	@Override
	public void accept(MethodVisitor visitor) {
		Path path = method.getAnnotation(Path.class);		
		if (path !=null) {
			visitor.visit(path);
		}
	}

}
