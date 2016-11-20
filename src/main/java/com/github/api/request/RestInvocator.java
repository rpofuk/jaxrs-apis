package com.github.api.request;

import java.io.Serializable;

public interface RestInvocator extends Serializable{

	/**
	 * HTTP get request
	 *
	 * @param request
	 * @return response content
	 * @throws RestException
	 */
	String sendGet(RestRequest request) throws RestException;

	/**
	 * HTTP post request with content
	 *
	 * @param request
	 * @param content
	 * @return Response content
	 * @throws RestException
	 */
	String sendPost(RestRequest request) throws RestException;

	/**
	 * HTTP delete request
	 *
	 * @param request
	 * @return response content
	 * @throws RestException
	 */
	String sendDelete(RestRequest request) throws RestException;

	/**
	 * PUT request with content
	 *
	 * @param request
	 * @param content
	 * @return Response content
	 * @throws RestException
	 */
	String sendPut(RestRequest request) throws RestException;

}