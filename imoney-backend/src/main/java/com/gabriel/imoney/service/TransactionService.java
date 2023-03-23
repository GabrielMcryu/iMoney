package com.gabriel.imoney.service;

import java.util.List;

import javax.validation.Valid;

import com.gabriel.imoney.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity);
	
	List<TransactionEntity> fetchTransactionList();

	List<TransactionEntity> fetchTransactionsByAccountNumber(String merchant, int accountNumber);
	
	TransactionEntity fetchTransactionByAccountNumber(int accountNumber);



}
