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
import com.gabriel.imoney.entity.B2cEntity;
import com.gabriel.imoney.entity.C2bEntity;
import com.gabriel.imoney.entity.ITransactionEntity;
import com.gabriel.imoney.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity);
	
	List<TransactionEntity> fetchTransactionList();

	List<TransactionEntity> fetchTransactionsByAccountNumber(String merchant, int accountNumber);
	
	ITransactionEntity saveITransaction(@Valid ITransactionEntity iTransactionEntity);
	
	List<ITransactionEntity> fetchTransactionsBySender(Long senderAccount);
	
	TransactionEntity fetchTransactionByAccountNumber(int accountNumber);

	AccessTokenResponse getAccessToken();
	
	RegisterUrlResponse registerUrl();
	
	SimulateTransactionResponse simulateC2BTransaction(SimulateTransactionRequest simulateTransactionRequest);
	
	SimulateTransactionResponse createC2BTransaction(C2BData c2Bdata);
	
	List<C2bEntity> fetchC2bTransactionsByReceiver(Long receiverAccountNumber);

	CommonSyncResponse performB2CTransaction(InternalB2CTransactionRequest internalB2CTransactionRequest);
	
	CommonSyncResponse createB2CTransaction(B2CData b2CData);
	
	List<B2cEntity> fetchB2cTransactionsBySender(Long senderAccount);
	
	TransactionEntity getITransactionById(Long iTransactionId);
	
	C2bEntity getByC2bId(Long c2bId);
	
	B2cEntity getB2cById(Long b2cId);
	
	
}
