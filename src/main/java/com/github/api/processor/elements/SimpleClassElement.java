package com.github.api.processor.elements;

import javax.ws.rs.Path;

import com.github.api.processor.api.ClassElement;
import com.github.api.processor.api.ClassVisitor;

public class SimpleClassElement implements ClassElement {

	private Class<?> endpoint;

	public SimpleClassElement(Class<?> endpoint) {
		this.endpoint = endpoint;
	}

	@Override
	public void accept(ClassVisitor visitor) {
		Path path = endpoint.getAnnotation(Path.class);		
		if (path !=null) {
			visitor.visit(path);
		}
	}

}
