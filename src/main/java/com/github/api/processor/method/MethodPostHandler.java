package com.github.api.processor.method;

import java.lang.annotation.Annotation;

import javax.ws.rs.POST;

import com.github.api.processor.AnnotationHandler;
import com.github.api.request.HttpMethod;
import com.github.api.request.RestRequest;

public class MethodPostHandler implements AnnotationHandler<POST> {

	@Override
	public boolean canHandle(Annotation annotation) {
		return annotation instanceof POST;
	}

	@Override
	public void handle(POST annotation, RestRequest request) {
		request.setHttpMethod(HttpMethod.POST);
	}
}
