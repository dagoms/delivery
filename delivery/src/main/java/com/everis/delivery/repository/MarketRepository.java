package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.delivery.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

	
	
}
