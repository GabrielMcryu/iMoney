package com.gabriel.imoney.service;

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

}
