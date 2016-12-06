package com.github.api;

import java.lang.reflect.Proxy;

public class ClientFactory {

	@SuppressWarnings("unchecked")
	public static <T> T createClient(Class<T> endpoint, Context params) {
		return (T) Proxy.newProxyInstance(ClientFactory.class.getClassLoader(), new	Class<?>[] {endpoint}, new ClientProxy(params));
	}

}
