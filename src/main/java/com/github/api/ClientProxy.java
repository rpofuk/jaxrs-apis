package com.github.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.api.processor.elements.SimpleClassElement;
import com.github.api.processor.elements.SimpleMethodElement;
import com.github.api.request.JersyRestInvocator;
import com.github.api.request.RestRequest;

public class ClientProxy implements InvocationHandler {

	private GlobalParamethers params;

	public ClientProxy(GlobalParamethers params) {
		this.params = params;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RestRequest request = new RestRequest();
		request.setBaseUrl(params.getBaseUrl());
		
		new SimpleClassElement(request).handle(method.getDeclaringClass());
		new SimpleMethodElement(request).handle(method);

		
		// BAD BAD BAD
		params.getHeaders().entrySet().forEach(p -> request.addHeder(p.getKey(), p.getValue()));

		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
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
