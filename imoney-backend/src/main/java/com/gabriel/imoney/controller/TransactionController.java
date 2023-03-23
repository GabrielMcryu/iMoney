package com.gabriel.imoney.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.imoney.entity.TransactionEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	@PostMapping("/transactions")
	public TransactionEntity createTransaction(@Valid @RequestBody TransactionEntity transactionEntity) {
		Date createdAt = new Date();
		transactionEntity.setCreatedAt(createdAt);
		System.out.println(transactionEntity);
		return null;
	}
}