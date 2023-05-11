package com.gabriel.imoney.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.imoney.entity.AccountEntity;
import com.gabriel.imoney.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity saveAccount(@Valid AccountEntity accountEntity) {
		return accountRepository.save(accountEntity);
	}

	@Override
	public AccountEntity getAccountById(Long accountNumber) {
		return accountRepository.getByAccountId(accountNumber);
	}

}
