package com.gabriel.imoney.repository;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.gabriel.imoney.entity.TransactionEntity;

@DataJpaTest
public class TransactionRepositoryTest {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void TransactionRepository_SaveAll_ReturnSavedTransaction() {
		TransactionEntity testTransaction = new TransactionEntity();
		testTransaction.setSenderName("Kelly");
		testTransaction.setAccountNumber(93847355);
		testTransaction.setAmount(500);
		testTransaction.setMerchant("Mpesa");
		Date createdAt = new Date();
		testTransaction.setCreatedAt(createdAt);
		
		TransactionEntity savedTransaction = transactionRepository.save(testTransaction);
		
		Assertions.assertThat(savedTransaction).isNotNull();
		Assertions.assertThat(savedTransaction.getTransactionId()).isGreaterThan(0);
	}
	
	@Test 
	public void TransactionRepository_FindAll_ReturnTransactionNotNull() {
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionEntity.setSenderName("Joe");
		transactionEntity.setAccountNumber(93847328);
		transactionEntity.setAmount(500);
		transactionEntity.setMerchant("Mpesa");
		Date createdAt = new Date();
		transactionEntity.setCreatedAt(createdAt);
		entityManager.persist(transactionEntity);
		
		TransactionEntity transactionEntity2 = new TransactionEntity();
		transactionEntity2.setSenderName("Jane");
		transactionEntity2.setAccountNumber(93847323);
		transactionEntity2.setAmount(500);
		transactionEntity2.setMerchant("Paypal");
		Date createdAt2 = new Date();
		transactionEntity2.setCreatedAt(createdAt2);
		entityManager.persist(transactionEntity2);
		
		List<TransactionEntity> testTransaction = transactionRepository.findAll();
		
		Assertions.assertThat(testTransaction).isNotNull();
		Assertions.assertThat(testTransaction.size()).isEqualTo(2);
	}
	
	@Test
	public void TransactionRepository_FindAllByAccountNumber_ReturnTransactionNotNull() {
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionEntity.setSenderName("Joe");
		transactionEntity.setAccountNumber(93847328);
		transactionEntity.setAmount(500);
		transactionEntity.setMerchant("Mpesa");
		Date createdAt = new Date();
		transactionEntity.setCreatedAt(createdAt);
		entityManager.persist(transactionEntity);
		
		TransactionEntity transactionEntity2 = new TransactionEntity();
		transactionEntity2.setSenderName("Jane");
		transactionEntity2.setAccountNumber(93847328);
		transactionEntity2.setAmount(500);
		transactionEntity2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		transactionEntity2.setCreatedAt(createdAt2);
		entityManager.persist(transactionEntity2);
		List<TransactionEntity> testTransaction = transactionRepository.findAllByMerchantAndAccountNumber("Mpesa", 93847328);
		
		Assertions.assertThat(testTransaction).isNotNull();
		Assertions.assertThat(testTransaction.size()).isGreaterThan(1);

	}
}
