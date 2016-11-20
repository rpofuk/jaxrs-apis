package com.github.api.processor;

import javax.ws.rs.Path;

import com.github.api.processor.api.ClassVisitor;
import com.github.api.request.RestRequest;

public class ClassAnnotationProcessor implements ClassVisitor {

	RestRequest request;

	public ClassAnnotationProcessor(RestRequest request) {
		this.request = request;
	}

	@Override
	public void visit(Path path) {
		request.setPrefixUrl(path.value());
	}

}
