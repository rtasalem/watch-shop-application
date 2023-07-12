package com.rtsalem.watchShopUI.exception;

import java.util.Arrays;
import java.util.List;

public class InvalidWatchException extends RuntimeException {

	private static final long serialVersionUID = -5468912058700001054L;
	private final List<String> validationErrorMessages;

	public InvalidWatchException(String csvErrors) {
		super("Invalid watch sent to API");
		this.validationErrorMessages = Arrays.asList(csvErrors.split(", "));
	}

	public List<String> getValidationErrorMessages() {
		return validationErrorMessages;
	}

}
