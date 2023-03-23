package com.gabriel.imoney.service;

import javax.validation.Valid;

import com.gabriel.imoney.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity);

}
