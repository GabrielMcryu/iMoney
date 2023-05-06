package com.gabriel.imoney.service;

import javax.validation.Valid;

import com.gabriel.imoney.entity.AccountEntity;

public interface AccountService {

	AccountEntity saveAccount(@Valid AccountEntity accountEntity);
}
