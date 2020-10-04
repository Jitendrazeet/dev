package com.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.src.dao.TradeRepository;

/*
 * @RestController public class FilterController {
 * 
 * @Autowired TradeRepository tradeRepository;
 * 
 * @GetMapping(
 * "//trades/stocks/{stockSymbol}?type={tradeType}&start={startDate}&end={endDate}")
 * public ResponseEntity<HttpStatus> filterByTradeAndSymbol(@RequestParam String
 * stock) {
 * 
 * if (true) {
 * 
 * return new ResponseEntity<>(HttpStatus.OK); }
 * 
 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
 * 
 * }
 */