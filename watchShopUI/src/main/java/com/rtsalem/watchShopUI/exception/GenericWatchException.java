package com.rtsalem.watchShopUI.exception;

public class GenericWatchException extends RuntimeException {

	private static final long serialVersionUID = 8339932914014650594L;
	public final String status;

	public GenericWatchException(String message, String status) {
		super(message);
		this.status = status;
	}

}
