package com.rtsalem.watchShopUI.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rtsalem.watchShopUI.exception.GenericWatchException;
import com.rtsalem.watchShopUI.exception.InvalidWatchException;

@ControllerAdvice
public class WatchControllerAdvice {

	@ExceptionHandler(GenericWatchException.class)
	public String handleGenericWatchException(GenericWatchException genWatchEx, Model model) {
		model.addAttribute("errorCode", genWatchEx.status);
		model.addAttribute("errorMessage", genWatchEx.getMessage());
		return "error-page";
	}

	@ExceptionHandler(InvalidWatchException.class)
	public String handleInvalidWatchException(InvalidWatchException invWatchEx, Model model) {
		model.addAttribute("errorMessages", invWatchEx.getValidationErrorMessages());
		return "forward:/addWatch";
	}

}
