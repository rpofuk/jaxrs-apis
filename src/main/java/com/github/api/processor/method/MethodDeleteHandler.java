package com.github.api.processor.method;

import java.lang.annotation.Annotation;

import javax.ws.rs.DELETE;

import com.github.api.processor.AnnotationHandler;
import com.github.api.request.HttpMethod;
import com.github.api.request.RestRequest;

public class MethodDeleteHandler implements AnnotationHandler<DELETE> {

	@Override
	public boolean canHandle(Annotation annotation) {
		return annotation instanceof DELETE;
	}

	@Override
	public void handle(DELETE annotation, RestRequest request) {
		request.setHttpMethod(HttpMethod.DELETE);
	}
}
