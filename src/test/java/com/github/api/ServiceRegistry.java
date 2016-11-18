package com.github.api;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.github.api.cases.SimpleGetService;

/**
 * Hello world!
 *
 */
public class ServiceRegistry extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new LinkedHashSet<Class<?>>();

		resources.add(SimpleGetService.class);

		return resources;
	}
}