package com.alphacoders.backend.shared.domain;

public abstract class DomainError extends RuntimeException {


	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String errorMessage;

    public DomainError(String errorCode, String errorMessage) {
    	
        super(errorMessage, null,true,false);

        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
        
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}