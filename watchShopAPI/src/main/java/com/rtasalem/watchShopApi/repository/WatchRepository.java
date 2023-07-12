package com.rtasalem.watchShopApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.watchShopApi.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

	boolean existsByModelReferenceNumber(String modelReferenceNumber);

}
