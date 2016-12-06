package com.github.api.processor;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.api.request.JersyRestInvocator;
import com.github.api.request.RestRequest;

public class RequestExecutor {

	JersyRestInvocator invocator;

	public RequestExecutor(JersyRestInvocator invocator) {
		this.invocator = invocator;
	}

	public Object executeRequest(RestRequest request, Class<?> returnType) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat(request.getDateFormat()));
		String respose = "";
		switch (request.getHttpMethod()) {
		case GET:
			respose = invocator.sendGet(request);
			break;
		case POST:
			respose = invocator.sendPost(request, serialize(request, mapper));
			break;
		case PUT:
			respose = invocator.sendPut(request, serialize(request, mapper));
			break;
		case DELETE:
			respose = invocator.sendDelete(request);
			break;
		default:
			break;
		}
		return deserialize(returnType, mapper, respose);
	}

	private Object deserialize(Class<?> returnType, ObjectMapper mapper, String respose) {
		try {
			return mapper.readValue(respose, returnType);
		} catch (IOException e) {
			throw new MappingExeption(e);
		}
	}

	private String serialize(RestRequest request, ObjectMapper mapper) {
		try {
			return mapper.writeValueAsString(request.getBody());
		} catch (IOException e) {
			throw new MappingExeption(e);
		}
	}

}
