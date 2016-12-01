package com.github.api.processor.method;

import java.lang.annotation.Annotation;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import com.github.api.processor.AnnotationHandler;
import com.github.api.request.HttpMethod;
import com.github.api.request.RestRequest;

public class MethodPutHandler implements AnnotationHandler<PUT> {

	@Override
	public boolean canHandle(Annotation annotation) {
		return annotation instanceof PUT;
	}

	@Override
	public void handle(PUT annotation, RestRequest request) {
		request.setHttpMethod(HttpMethod.PUT);
	}
}
