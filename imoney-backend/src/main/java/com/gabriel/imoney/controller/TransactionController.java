package com.gabriel.imoney.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.service.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	@PostMapping("/transactions")
	public TransactionEntity createTransaction(@Valid @RequestBody TransactionEntity transactionEntity) {
		Date createdAt = new Date();
		transactionEntity.setCreatedAt(createdAt);
		return transactionService.saveTransaction(transactionEntity);
	}
}
