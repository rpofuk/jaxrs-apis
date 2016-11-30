package com.github.api.processor;

import java.lang.annotation.Annotation;

import com.github.api.request.RestRequest;

public interface AnnotationHandler<T> {

	boolean canHandle(Annotation annotation);
	
	void handle(T handle, RestRequest request);
}
