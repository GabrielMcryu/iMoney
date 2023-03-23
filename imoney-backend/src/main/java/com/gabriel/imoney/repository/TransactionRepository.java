package com.gabriel.imoney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabriel.imoney.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

	public TransactionEntity findByAccountNumber(@Param("accountNumber") int accountNumber);
	
	public List<TransactionEntity> findAllByMerchantAndAccountNumber(String merchant, int accountNumber);
}
