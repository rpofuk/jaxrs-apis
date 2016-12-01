package com.github.api.processor.method;

import java.lang.annotation.Annotation;

import javax.ws.rs.GET;

import com.github.api.processor.AnnotationHandler;
import com.github.api.request.HttpMethod;
import com.github.api.request.RestRequest;

public class MethodGetHandler implements AnnotationHandler<GET> {

	@Override
	public boolean canHandle(Annotation annotation) {
		return annotation instanceof GET;
	}

	@Override
	public void handle(GET annotation, RestRequest request) {
		request.setHttpMethod(HttpMethod.GET);
	}
}
