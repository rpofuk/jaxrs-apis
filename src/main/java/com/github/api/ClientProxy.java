package com.github.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.github.api.processor.HeaderProcessor;
import com.github.api.processor.RequestExecutor;
import com.github.api.processor.elements.SimpleClassElement;
import com.github.api.processor.elements.SimpleMethodElement;
import com.github.api.request.JersyRestInvocator;
import com.github.api.request.RestRequest;

public class ClientProxy implements InvocationHandler {

	private Context context;

	public ClientProxy(Context params) {
		this.context = params;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		RestRequest request = new RestRequest();
		if (args.length > 0) {
			request.setBody(args[0]);	
		}
		
		request.setBaseUrl(context.getBaseUrl());
		request.setDateFormat(context.getDateFormat());
		
		new SimpleClassElement(request).handle(method.getDeclaringClass());
		new SimpleMethodElement(request).handle(method);

		new HeaderProcessor().process(context.getHeaders(), request);		
		return new RequestExecutor(new JersyRestInvocator()).executeRequest(request,method.getReturnType());
	}

}
