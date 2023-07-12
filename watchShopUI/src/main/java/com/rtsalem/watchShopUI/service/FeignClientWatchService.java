package com.rtsalem.watchShopUI.service;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rtsalem.watchShopUI.model.Watch;

@FeignClient(name = "WATCH-SHOP-API", path = "/api/v1/watches")
@LoadBalancerClient(name = "WATCH-SHOP-API")
public interface FeignClientWatchService {

	@GetMapping
	public List<Watch> findAllWatches();

	@GetMapping("/{id}")
	public Watch findWatchById(@PathVariable(value = "id") int id);

	@PostMapping
	public Watch addWatch(@RequestBody Watch watch);

	@PutMapping("/{id}")
	public Watch updateWatch(@PathVariable(value = "id") int id, @RequestBody Watch watch);

	@DeleteMapping("/{id}")
	public void deleteWatchById(@PathVariable(value = "id") int id);

}
