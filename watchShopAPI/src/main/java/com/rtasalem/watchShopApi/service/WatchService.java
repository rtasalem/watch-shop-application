package com.rtasalem.watchShopApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.watchShopApi.exception.ModelReferenceNumberExistsException;
import com.rtasalem.watchShopApi.exception.ResourceNotFoundException;
import com.rtasalem.watchShopApi.model.Watch;
import com.rtasalem.watchShopApi.repository.WatchRepository;

@Service
public class WatchService {

	private final WatchRepository watchRepo;

	public WatchService(WatchRepository watchRepo) {
		super();
		this.watchRepo = watchRepo;
	}

	public List<Watch> findAllWatches() {
		return watchRepo.findAll();
	}

	public Watch findWatchById(int id) {
		Optional<Watch> watchOpt = watchRepo.findById(id);
		if (watchOpt.isEmpty()) {
			throw new ResourceNotFoundException("Watch with id of " + " not found.");
		}
		return watchOpt.get();
	}

	public Watch addWatch(Watch watch) {
		if (watchRepo.existsByModelReferenceNumber(watch.getModelReferenceNumber())) {
			throw new ModelReferenceNumberExistsException(
					"Watch with model reference number of " + watch.getModelReferenceNumber() + " already exists.");
		}

		if (watch.getModel().isBlank() || watch.getModel().isEmpty()) {
			throw new RuntimeException("Watch model must not be left blank");
		}

		if (watch.getManufacturer().isBlank() || watch.getManufacturer().isEmpty()) {
			throw new RuntimeException("Watch manufacturer must not be left blank.");
		}

		if (watch.getModelReferenceNumber().isBlank() || watch.getModelReferenceNumber().isEmpty()) {
			throw new RuntimeException("Watch model reference number must not be left blank");
		}

		return watchRepo.save(watch);
	}

	public Watch updateWatch(Watch watch, int id) {
		if (!watchRepo.existsById(id)) {
			throw new ResourceNotFoundException("Watch with id of " + id + " not found.");
		}
		watch.setId(id);
		return watchRepo.save(watch);
	}

	public void deleteWatchById(int id) {
		if (!watchRepo.existsById(id)) {
			throw new ResourceNotFoundException("Watch with id of " + id + " not found.");
		}
		watchRepo.deleteById(id);
	}

}
