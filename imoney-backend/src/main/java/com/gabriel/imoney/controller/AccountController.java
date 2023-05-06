package com.gabriel.imoney.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.imoney.entity.AccountEntity;
import com.gabriel.imoney.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/accounts")
	public AccountEntity createAccount(@Valid @RequestBody AccountEntity accountEntity) {
		Date createdAt = new Date();
		accountEntity.setCreatedAt(createdAt);
		return accountService.saveAccount(accountEntity);
	}
}
