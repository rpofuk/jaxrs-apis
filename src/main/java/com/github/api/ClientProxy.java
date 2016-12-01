package com.github.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.api.processor.elements.SimpleClassElement;
import com.github.api.processor.elements.SimpleMethodElement;
import com.github.api.request.JersyRestInvocator;
import com.github.api.request.RestRequest;

public class ClientProxy implements InvocationHandler {

	private String baseUrl;

	public ClientProxy(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RestRequest request = new RestRequest();
		request.setBaseUrl(baseUrl);

		new SimpleClassElement(request).handle(method.getDeclaringClass());
		new SimpleMethodElement(request).handle(method);

		ObjectMapper mapper = new ObjectMapper();
		String respose = "";
		switch (request.getHttpMethod()) {
		case GET:
			respose = new JersyRestInvocator().sendGet(request);
			break;
		case POST:
			respose = new JersyRestInvocator().sendPost(request, mapper.writeValueAsString(args[0]));
			break;
		case PUT:
			respose = new JersyRestInvocator().sendPut(request, mapper.writeValueAsString(args[0]));
			break;
		case DELETE:
			respose = new JersyRestInvocator().sendDelete(request);
			break;
		default:
			break;
		}
		return mapper.readValue(respose, method.getReturnType());

	}

}
