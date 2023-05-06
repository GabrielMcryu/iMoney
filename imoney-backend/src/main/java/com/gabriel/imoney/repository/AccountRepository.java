package com.gabriel.imoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.imoney.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	boolean existsById(Long id);
}
