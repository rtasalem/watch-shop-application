package com.rtasalem.watchShopApi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rtasalem.watchShopApi.model.Watch;
import com.rtasalem.watchShopApi.service.WatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/watches")
public class WatchController {

	private final WatchService watchService;

	public WatchController(WatchService watchService) {
		super();
		this.watchService = watchService;
	}
	
	@GetMapping
	public ResponseEntity<List<Watch>> getAllWatches() {
		return ResponseEntity.status(HttpStatus.OK).body(watchService.findAllWatches());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Watch> getWatchById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(watchService.findWatchById(id));
	}
	
	@PostMapping
	public ResponseEntity<Watch> addWatch(@Valid @RequestBody Watch watch) {
		watchService.addWatch(watch);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(watch.getId()).toUri();
		return ResponseEntity.created(location).body(watch);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Watch> updateWatch(@PathVariable int id, @Valid @RequestBody Watch watch) {
		return ResponseEntity.ok(watchService.updateWatch(watch, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWatch(@PathVariable int id) {
		watchService.deleteWatchById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
