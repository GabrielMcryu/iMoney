package com.gabriel.imoney.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity) {
		return transactionRepository.save(transactionEntity);
	}
	
	@Override
	public List<TransactionEntity> fetchTransactionList() {
		return transactionRepository.findAll();
	}
	
	@Override
	public List<TransactionEntity> fetchTransactionsByAccountNumber(String merchant, int accountNumber) {
		return transactionRepository.findAllByMerchantAndAccountNumber(merchant, accountNumber);
	}

	@Override
	public TransactionEntity fetchTransactionByAccountNumber(int accountNumber) {
		return transactionRepository.findByAccountNumber(accountNumber);
	}

}
