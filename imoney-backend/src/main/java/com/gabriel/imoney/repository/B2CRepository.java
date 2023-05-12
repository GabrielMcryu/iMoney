package com.gabriel.imoney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.imoney.entity.B2cEntity;

@Repository
public interface B2CRepository extends JpaRepository<B2cEntity, Long> {
	public List<B2cEntity> findAllBySenderAccount(Long senderAccount);
	
	B2cEntity findByB2cId(Long b2cId);
}
