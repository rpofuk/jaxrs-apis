package com.github.api.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlainRestInvocator implements RestInvocator {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(PlainRestInvocator.class);

	private static final String ACCEPT = "Accept";
	private static final String APPLICATION_JSON = "application/json;charset=utf-8";
	private static final String CONTENT_TYPE = "Content-Type";

	@Override
	public String sendGet(RestRequest request) throws RestException {
		try {
			final HttpMethod method = HttpMethod.GET;
			
			String path = formPath(request);
			return sendReadRequest(path, method);
		} catch (final Exception e) {
			throw new RestException(e);
		}
	}
	
	

	private String formPath(RestRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getBaseUrl());
		
		request.getPaths().forEach(p -> builder.append("/").append(p));
		return request.toString();
	}



	@Override
	public String sendPost(RestRequest request, String payload) throws RestException {
		return null;
	}

	@Override
	public String sendDelete(RestRequest request) throws RestException {
		return null;
	}

	@Override
	public String sendPut(RestRequest request, String payload) throws RestException {
		return null;
	}

	private String sendReadRequest(final String request, final HttpMethod method) throws IOException {
		final URL url = new URL(request);
		final HttpURLConnection con = (HttpURLConnection) url.openConnection();

		LOG.debug("\nSending '" + method.value + "' request to URL : " + url);
		con.setRequestMethod(method.value);
		con.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
		con.setRequestProperty(ACCEPT, APPLICATION_JSON);

		final int responseCode = con.getResponseCode();
		LOG.debug("Response code : " + responseCode);

		return readResponse(con);
	}

	private static String readResponse(final HttpURLConnection con) throws IOException {
		final InputStream responseStream;

		if (con.getResponseCode() >= 400) {
			responseStream = con.getErrorStream();
		} else {
			responseStream = con.getInputStream();
		}

		final BufferedReader in = new BufferedReader(new InputStreamReader(responseStream));
		String inputLine;
		final StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		LOG.debug(response.toString());
		return response.toString();
	}

}
