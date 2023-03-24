package com.gabriel.imoney.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/transactions")
	public TransactionEntity createTransaction(@Valid @RequestBody TransactionEntity transactionEntity) {
		Date createdAt = new Date();
		transactionEntity.setCreatedAt(createdAt);
		return transactionService.saveTransaction(transactionEntity);
	}
	
	@GetMapping("/transactions")
	public List<TransactionEntity> fetchTransactionList() {
		return transactionService.fetchTransactionList();
	}
	
	@GetMapping("/transactions/{merchant}/{accountNumber}")
	public List<TransactionEntity> fetchTransactionsByAccountNumber(@PathVariable("merchant") String merchant, @PathVariable("accountNumber") int accountNumber) {
		return transactionService.fetchTransactionsByAccountNumber(merchant, accountNumber);
	}
	
}
