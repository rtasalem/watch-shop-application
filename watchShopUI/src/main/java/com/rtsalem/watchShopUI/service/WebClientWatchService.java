package com.rtsalem.watchShopUI.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.rtsalem.watchShopUI.exception.WebClientExceptionFilter;
import com.rtsalem.watchShopUI.model.Watch;

import reactor.core.publisher.Mono;

@Service
public class WebClientWatchService {

	private static final String BASE_URL = "http://localhost:8088/api/v1/watches";
	private final WebClient webClient;

	public WebClientWatchService(WebClient.Builder builder) {
		super();
		this.webClient = builder.baseUrl(BASE_URL)
				.filter(ExchangeFilterFunction.ofResponseProcessor(WebClientExceptionFilter::filterFunction))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public List<Watch> findAllWatches() {
		return webClient.get().retrieve().bodyToFlux(Watch.class).collectList().block();
	}

	public Watch findWatchById(int id) {
		return webClient.get().uri(builder -> builder.path("/{id}").build(id)).retrieve().bodyToMono(Watch.class)
				.block();
	}

	public Watch addWatch(Watch watch) {
		return webClient.post().bodyValue(watch).retrieve().bodyToMono(Watch.class).block();
	}

	public Watch updateWatch(int id, Watch watch) {
		return webClient.put().uri(builder -> builder.path("/{id}").build(id)).bodyValue(watch).retrieve()
				.bodyToMono(Watch.class).block();
	}

	public void deleteWatchById(int id) {
		webClient.delete().uri(builder -> builder.path("/{id}").build(id)).retrieve()
				.onStatus(status -> status.value() == 404, clientResponse -> {
					clientResponse.bodyToMono(String.class);
					return Mono.just(new RuntimeException("404 from delete"));
				}).toBodilessEntity().block();
	}

}
