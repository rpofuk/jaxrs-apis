package com.github.api.processor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import com.github.api.processor.method.MethodDeleteHandler;
import com.github.api.processor.method.MethodGetHandler;
import com.github.api.processor.method.MethodPathHandler;
import com.github.api.processor.method.MethodPostHandler;
import com.github.api.processor.method.MethodPutHandler;
import com.github.api.request.RestRequest;

public class MethodAnotationProcessor {

	@SuppressWarnings("rawtypes")
	private static List<AnnotationHandler> annotations = new ArrayList<>();
	static {
		annotations.add(new MethodPathHandler());
		annotations.add(new MethodGetHandler());
		annotations.add(new MethodPostHandler());
		annotations.add(new MethodPutHandler());
		annotations.add(new MethodDeleteHandler());
	}

	RestRequest request;

	public MethodAnotationProcessor(RestRequest request) {
		this.request = request;
	}

	@SuppressWarnings("unchecked")
	public void process(Annotation handle) {
		annotations.stream().filter(a -> a.canHandle(handle)).forEach(a -> a.handle(handle, request));

	}

}
