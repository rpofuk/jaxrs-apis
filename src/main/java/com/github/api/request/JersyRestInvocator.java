package com.github.api.request;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class JersyRestInvocator implements RestInvocator {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String sendGet(RestRequest request) throws RestException {
		WebTarget target = buildTarget(request);
		return target.request(MediaType.APPLICATION_JSON_TYPE).get().readEntity(String.class);
	}

	@Override
	public String sendPost(RestRequest request, String payload) throws RestException {
		WebTarget target = buildTarget(request);
		Entity<String> payloadEntity = Entity.entity(payload, MediaType.APPLICATION_JSON);
		return target.request(MediaType.APPLICATION_JSON_TYPE).post(payloadEntity).readEntity(String.class);
	}

	@Override
	public String sendDelete(RestRequest request) throws RestException {
		return null;
	}

	@Override
	public String sendPut(RestRequest request, String payload) throws RestException {
		return null;
	}

	private WebTarget buildTarget(RestRequest request) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(request.getBaseUrl());
		request.getPaths().stream().forEach(p -> target.path(p));
		return target;
	}
}
