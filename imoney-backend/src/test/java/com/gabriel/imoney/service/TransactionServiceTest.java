package com.gabriel.imoney.service;

import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.repository.TransactionRepository;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TransactionServiceTest {
	
	@Autowired
	private TransactionService transactionService;
	
	@MockBean
	private TransactionRepository transactionRepository;
	
	@Test
	public void TransactionService_CreateTransaction_ReturnsTransaction() {
		TransactionEntity testTransaction = new TransactionEntity();
		testTransaction.setSenderName("Kelly");
		testTransaction.setAccountNumber(93847355);
		testTransaction.setAmount(500);
		testTransaction.setMerchant("Mpesa");
		Date createdAt = new Date();
		testTransaction.setCreatedAt(createdAt);
		
		when(transactionRepository.save(Mockito.any(TransactionEntity.class))).thenReturn(testTransaction);
		
		TransactionEntity savedTransaction = transactionService.saveTransaction(testTransaction);
		
		Assertions.assertThat(savedTransaction).isNotNull();
	}
	
	@Test 
	public void TransactionService_FindAll_ReturnTransactions( ) {
		TransactionEntity testTransaction = new TransactionEntity();
		testTransaction.setSenderName("Kelly");
		testTransaction.setAccountNumber(93847355);
		testTransaction.setAmount(500);
		testTransaction.setMerchant("Mpesa");
		Date createdAt = new Date();
		testTransaction.setCreatedAt(createdAt);
		
		TransactionEntity testTransaction2 = new TransactionEntity();
		testTransaction2.setSenderName("Joe");
		testTransaction2.setAccountNumber(93847355);
		testTransaction2.setAmount(500);
		testTransaction2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		testTransaction2.setCreatedAt(createdAt2);
		
		given(transactionRepository.findAll()).willReturn(List.of(testTransaction, testTransaction2));
		
		List<TransactionEntity> transactionList = transactionService.fetchTransactionList();
		
		Assertions.assertThat(transactionList).isNotNull();
		Assertions.assertThat(transactionList.size()).isEqualTo(2);
	}
	
	@Test 
	public void TransactionService_FindAllByAccountNumber_ReturnTransactions() {
		String merchantName = "Mpesa";
		int accountNumber = 93847355;
		
		TransactionEntity testTransaction = new TransactionEntity();
		testTransaction.setSenderName("Kelly");
		testTransaction.setAccountNumber(93847355);
		testTransaction.setAmount(500);
		testTransaction.setMerchant("Mpesa");
		Date createdAt = new Date();
		testTransaction.setCreatedAt(createdAt);
		
		TransactionEntity testTransaction2 = new TransactionEntity();
		testTransaction2.setSenderName("Joe");
		testTransaction2.setAccountNumber(93847355);
		testTransaction2.setAmount(500);
		testTransaction2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		testTransaction2.setCreatedAt(createdAt2);
		
		given(transactionRepository.findAllByMerchantAndAccountNumber(merchantName, accountNumber)).willReturn(List.of(testTransaction, testTransaction2));
		
		List<TransactionEntity> transactionList = transactionService.fetchTransactionsByAccountNumber(merchantName, accountNumber);
		
		Assertions.assertThat(transactionList).isNotNull();
		Assertions.assertThat(transactionList.size()).isEqualTo(2);
		
	}
	
	
	
	
}
