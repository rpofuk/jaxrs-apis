package com.github.api.processor.api;

import javax.ws.rs.Path;

public interface MethodVisitor {

	void visit(Path path);
}
