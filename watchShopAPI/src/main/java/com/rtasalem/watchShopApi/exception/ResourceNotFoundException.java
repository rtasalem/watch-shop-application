package com.rtasalem.watchShopApi.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2798649630243152785L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
