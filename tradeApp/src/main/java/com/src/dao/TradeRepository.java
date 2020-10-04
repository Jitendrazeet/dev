package com.src.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
