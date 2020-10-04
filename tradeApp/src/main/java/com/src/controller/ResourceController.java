package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.src.dao.TradeRepository;
import com.src.model.Trade;

@RestController
public class ResourceController {

	@Autowired
	TradeRepository tradeRepository;

	@DeleteMapping("/erase")
	public ResponseEntity<String> earseAll() {
		tradeRepository.deleteAll();
		return new ResponseEntity<String>("Deleted sucessfully..", HttpStatus.OK);
	}

	@PostMapping("/trades")
	public ResponseEntity<HttpStatus> saveTrade(@RequestBody Trade trade) {
		if (isBetween(trade.getShare(), trade.getPrice()) && !tradeRepository.findById(trade.getId()).isPresent()) {
			tradeRepository.save(trade);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/trades") // Get ALL trades
	public ResponseEntity<List<Trade>> getAllTrades() {
		return new ResponseEntity<List<Trade>>(tradeRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/trades/{id}")
	public ResponseEntity<HttpStatus> findTradeByID(@PathVariable int id) {
		if (tradeRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/trades/user/{id}")
	public ResponseEntity<HttpStatus> findUserByID(@PathVariable int id) {
		if (tradeRepository.findAll().stream().filter(trade -> trade.getUser().getId() == id).findAny()
				.orElse(null) != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public boolean isBetween(int num, float price) {

		return (num >= 10 && num <= 30) && (price >= 130.42 && price <= 195.65);
	}
}
