package com.github.api.processor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import com.github.api.processor.global.ClassPathHandler;
import com.github.api.request.RestRequest;

public class ClassAnnotationProcessor {

	@SuppressWarnings("rawtypes")
	private static List<AnnotationHandler> annotations = new ArrayList<>();
	static {
		annotations.add(new ClassPathHandler());
	}

	RestRequest request;

	public ClassAnnotationProcessor(RestRequest request) {
		this.request = request;
	}

	@SuppressWarnings("unchecked")
	public void process(Annotation handle) {
		annotations.stream().filter(a -> a.canHandle(handle)).forEach(a -> a.handle(handle, request));

	}

}
