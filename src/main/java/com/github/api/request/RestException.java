package com.github.api.request;

public class RestException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public RestException(Exception e) {
        super(e);
    }

}
