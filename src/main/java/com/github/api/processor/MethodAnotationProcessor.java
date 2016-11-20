package com.github.api.processor;

import javax.ws.rs.Path;

import com.github.api.processor.api.MethodVisitor;
import com.github.api.request.RestRequest;

public class MethodAnotationProcessor implements MethodVisitor {

	RestRequest request;

	public MethodAnotationProcessor(RestRequest request) {
		this.request = request;
	}

	@Override
	public void visit(Path path) {
		request.addPath(path.value());
	}

}
