package com.github.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.boon.json.ObjectMapper;
import org.boon.json.ObjectMapperFactory;

import com.github.api.processor.elements.SimpleClassElement;
import com.github.api.processor.elements.SimpleMethodElement;
import com.github.api.request.PlainRestInvocator;
import com.github.api.request.RestRequest;

public class ClientProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RestRequest request = new RestRequest();
		request.setBaseUrl("http://127.0.0.1:8080/api");

		new SimpleClassElement(request).handle(method.getDeclaringClass());
		new SimpleMethodElement(request).handle(method);

		ObjectMapper mapper = ObjectMapperFactory.create();
		String respose = new PlainRestInvocator().sendGet(request);
		return mapper.readValue(respose, method.getReturnType());

	}

}
