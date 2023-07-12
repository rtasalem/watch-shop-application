package com.rtsalem.watchShopUI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;

import reactor.core.publisher.Mono;

public class WebClientExceptionFilter {
	
	private WebClientExceptionFilter() {}
	
	public static Mono<ClientResponse> filterFunction(ClientResponse response) {
		
		HttpStatusCode statusCode = response.statusCode();
		
		if (statusCode.equals(HttpStatus.NOT_FOUND) || statusCode.equals(HttpStatus.CONFLICT)) {
			return response.bodyToMono(String.class).flatMap(body -> Mono.error(new GenericWatchException(body, statusCode.toString())));
		}
		
		if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
			return response.bodyToMono(String.class).flatMap(body -> Mono.error(new InvalidWatchException(body)));
		}
		
		return Mono.just(response);
		
	}

}
