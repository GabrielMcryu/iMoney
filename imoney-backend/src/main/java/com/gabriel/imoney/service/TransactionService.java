package com.gabriel.imoney.service;

import java.util.List;

import javax.validation.Valid;

import com.gabriel.imoney.dtos.AccessTokenResponse;
import com.gabriel.imoney.dtos.B2CData;
import com.gabriel.imoney.dtos.C2BData;
import com.gabriel.imoney.dtos.CommonSyncResponse;
import com.gabriel.imoney.dtos.InternalB2CTransactionRequest;
import com.gabriel.imoney.dtos.RegisterUrlResponse;
import com.gabriel.imoney.dtos.SimulateTransactionRequest;
import com.gabriel.imoney.dtos.SimulateTransactionResponse;
import com.gabriel.imoney.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity);
	
	List<TransactionEntity> fetchTransactionList();

	List<TransactionEntity> fetchTransactionsByAccountNumber(String merchant, int accountNumber);
	
	TransactionEntity fetchTransactionByAccountNumber(int accountNumber);

	AccessTokenResponse getAccessToken();
	
	RegisterUrlResponse registerUrl();
	
	SimulateTransactionResponse simulateC2BTransaction(SimulateTransactionRequest simulateTransactionRequest);
	
	SimulateTransactionResponse createC2BTransaction(C2BData c2Bdata);

	CommonSyncResponse performB2CTransaction(InternalB2CTransactionRequest internalB2CTransactionRequest);
	
	CommonSyncResponse createB2CTransaction(B2CData b2CData);
}
