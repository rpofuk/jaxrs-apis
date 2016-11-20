package com.github.api.processor.api;

import javax.ws.rs.Path;

public interface ClassVisitor {

	void visit(Path path);
}
