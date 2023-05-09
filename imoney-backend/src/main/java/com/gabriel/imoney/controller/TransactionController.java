package com.gabriel.imoney.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.imoney.dtos.AccessTokenResponse;
import com.gabriel.imoney.dtos.AcknowledgeResponse;
import com.gabriel.imoney.dtos.B2CData;
import com.gabriel.imoney.dtos.B2CTransactionAsyncResponse;
import com.gabriel.imoney.dtos.C2BData;
import com.gabriel.imoney.dtos.CommonSyncResponse;
import com.gabriel.imoney.dtos.InternalB2CTransactionRequest;
import com.gabriel.imoney.dtos.MpesaValidationResponse;
import com.gabriel.imoney.dtos.RegisterUrlResponse;
import com.gabriel.imoney.dtos.SimulateTransactionRequest;
import com.gabriel.imoney.dtos.SimulateTransactionResponse;
import com.gabriel.imoney.entity.B2cEntity;
import com.gabriel.imoney.entity.C2bEntity;
import com.gabriel.imoney.entity.ITransactionEntity;
import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.service.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	private final AcknowledgeResponse acknowledgeResponse;
	private final ObjectMapper objectMapper;
	
	Logger log = LoggerFactory.getLogger(TransactionController.class);
	
	public TransactionController(AcknowledgeResponse acknowledgeResponse, ObjectMapper objectMapper) {
		this.acknowledgeResponse = acknowledgeResponse;
		this.objectMapper = objectMapper;
	}

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
	
	@PostMapping("/itransactions")
	public ITransactionEntity createITransaction(@Valid @RequestBody ITransactionEntity iTransactionEntity) {
		Date createdAt = new Date();
		iTransactionEntity.setCreatedAt(createdAt);
		return transactionService.saveITransaction(iTransactionEntity);
	}
	
	@GetMapping("/itransaction/{senderAccount}")
	public List<ITransactionEntity> fetchTransactionsBySender(@PathVariable("senderAccount") Long senderAccount) {
		return transactionService.fetchTransactionsBySender(senderAccount);
	}
	
	@GetMapping("/c2b-transaction/{receiverAccountNumber}")
	public List<C2bEntity> fetchC2BTransactionsByReceiver(@PathVariable("receiverAccountNumber") Long receiverAccountNumber) {
		return transactionService.fetchC2bTransactionsByReceiver(receiverAccountNumber);
	}
	
	@GetMapping("/b2c-transaction/{senderAccount}")
	public List<B2cEntity> fetchB2CTransactionsBySender(@PathVariable("senderAccount") Long senderAccountNumber) {
		return transactionService.fetchB2cTransactionsBySender(senderAccountNumber);
	}
	
	/////////////////////////////////////////////
	// MPESA Transaction Region
	
	@GetMapping(path = "/token", produces = "application/json")
	public ResponseEntity<AccessTokenResponse> getAccessToken() {
		return ResponseEntity.ok(transactionService.getAccessToken());
	}
	
	@PostMapping(path = "/register-url", produces = "application/json")
	public ResponseEntity<RegisterUrlResponse> registerUrl() {
		return ResponseEntity.ok(transactionService.registerUrl());
	}
	
	//////////////////////////////////
	// C2B
	
	@PostMapping(path = "/validation", produces = "application/json")
	public ResponseEntity<AcknowledgeResponse> mpesaValidation(@RequestBody MpesaValidationResponse mpesaValidationResponse) {
		return ResponseEntity.ok(acknowledgeResponse);
	}
	
	@PostMapping(path = "/simulate-c2b", produces = "application/json")
	public ResponseEntity<SimulateTransactionResponse> simulateB2CTransaction(@RequestBody SimulateTransactionRequest simulateTransactionRequest) {
		return ResponseEntity.ok(transactionService.simulateC2BTransaction(simulateTransactionRequest));
	}
	
	@PostMapping(path = "/create-c2b-transaction", produces = "application/json")
	public ResponseEntity<SimulateTransactionResponse> createC2BTransaction(@RequestBody C2BData c2BData) {
		return ResponseEntity.ok(transactionService.createC2BTransaction(c2BData));
	}
	
	//////////////////////////////////
	// B2C
		
	@PostMapping(path = "/transaction-result", produces = "application/json")
	public ResponseEntity<AcknowledgeResponse> b2cTransactionAsyncResults(@RequestBody B2CTransactionAsyncResponse b2CTransactionAsyncResponse) throws JsonProcessingException {
		log.info("============ B2C Transaction Response =============");
	    log.info(objectMapper.writeValueAsString(b2CTransactionAsyncResponse));
	    return ResponseEntity.ok(acknowledgeResponse);
	}
	
	@PostMapping(path = "/b2c-queue-timeout", produces = "application/json")
	public ResponseEntity<AcknowledgeResponse> queueTimeout(@RequestBody Object object) {
		return ResponseEntity.ok(acknowledgeResponse);
	}
	
	@PostMapping(path = "/b2c-transaction", produces = "application/json")
	public ResponseEntity<CommonSyncResponse> performB2CTransaction(@RequestBody InternalB2CTransactionRequest internalB2CTransactionRequest) {
		return ResponseEntity.ok(transactionService.performB2CTransaction(internalB2CTransactionRequest));
	}
	
	@PostMapping(path = "/create-b2c-transaction", produces = "application/json")
	public ResponseEntity<CommonSyncResponse> createB2CTransaction(@RequestBody B2CData b2CData) {
		return ResponseEntity.ok(transactionService.createB2CTransaction(b2CData));
	}
}




