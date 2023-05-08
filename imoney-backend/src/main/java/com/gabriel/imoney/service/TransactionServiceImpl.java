package com.gabriel.imoney.service;

import static com.gabriel.imoney.utils.Constants.AUTHORIZATION_HEADER_STRING;
import static com.gabriel.imoney.utils.Constants.BASIC_AUTH_STRING;
import static com.gabriel.imoney.utils.Constants.BEARER_AUTH_STRING;
import static com.gabriel.imoney.utils.Constants.CACHE_CONTROL_HEADER;
import static com.gabriel.imoney.utils.Constants.CACHE_CONTROL_HEADER_VALUE;
import static com.gabriel.imoney.utils.Constants.JSON_MEDIA_TYPE;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.imoney.config.MpesaConfiguration;
import com.gabriel.imoney.dtos.AccessTokenResponse;
import com.gabriel.imoney.dtos.B2CData;
import com.gabriel.imoney.dtos.B2CTransactionRequest;
import com.gabriel.imoney.dtos.C2BData;
import com.gabriel.imoney.dtos.CommonSyncResponse;
import com.gabriel.imoney.dtos.InternalB2CTransactionRequest;
import com.gabriel.imoney.dtos.RegisterUrlRequest;
import com.gabriel.imoney.dtos.RegisterUrlResponse;
import com.gabriel.imoney.dtos.SimulateTransactionRequest;
import com.gabriel.imoney.dtos.SimulateTransactionResponse;
import com.gabriel.imoney.entity.AccountEntity;
import com.gabriel.imoney.entity.B2cEntity;
import com.gabriel.imoney.entity.C2bEntity;
import com.gabriel.imoney.entity.ITransactionEntity;
import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.repository.AccountRepository;
import com.gabriel.imoney.repository.B2CRepository;
import com.gabriel.imoney.repository.C2BRepository;
import com.gabriel.imoney.repository.ITransactionRepository;
import com.gabriel.imoney.repository.TransactionRepository;
import com.gabriel.imoney.utils.HelperUtility;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private C2BRepository c2BRepository;
	
	@Autowired 
	private B2CRepository b2CRepository;
	
	@Autowired
	private ITransactionRepository iTransactionRepository;
	
	private final MpesaConfiguration mpesaConfiguration;
	private final OkHttpClient okHttpClient;
	private final ObjectMapper objectMapper;
	
	public TransactionServiceImpl(MpesaConfiguration mpesaConfiguration, OkHttpClient okHttpClient,
			ObjectMapper objectMapper) {
		this.mpesaConfiguration = mpesaConfiguration;
		this.okHttpClient = okHttpClient;
		this.objectMapper = objectMapper;
	}

	@Override
	public TransactionEntity saveTransaction(@Valid TransactionEntity transactionEntity) {
		return transactionRepository.save(transactionEntity);
	}
	
	@Override
	public List<TransactionEntity> fetchTransactionList() {
		return transactionRepository.findAll();
	}
	
	@Override
	public List<TransactionEntity> fetchTransactionsByAccountNumber(String merchant, int accountNumber) {
		return transactionRepository.findAllByMerchantAndAccountNumber(merchant, accountNumber);
	}

	@Override
	public TransactionEntity fetchTransactionByAccountNumber(int accountNumber) {
		return transactionRepository.findByAccountNumber(accountNumber);
	}
	
	/////////////////////////////////////////////
    // Daraja Services

	@Override
	public AccessTokenResponse getAccessToken() {
		String encodedCredentials = HelperUtility.toBase64String(String.format("%s:%s", mpesaConfiguration.getConsumerKey(), mpesaConfiguration.getConsumerSecret()));
		
		Request request = new Request.Builder()
				.url(String.format("%s?grant_type=%s", mpesaConfiguration.getOauthEndpoint(), mpesaConfiguration.getGrantType()))
				.get()
				.addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
				.addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
				.build();
		try {
			Response response = okHttpClient.newCall(request).execute();
			
			assert response.body() != null;
			
			return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
		} catch(IOException e) {
			LoggerFactory.getLogger(TransactionServiceImpl.class).error("Could not get access token. -> {}", e.getLocalizedMessage());
			return null;
		}
		
	}

	@Override
	public RegisterUrlResponse registerUrl() {
		AccessTokenResponse accessTokenResponse = getAccessToken();
		
		RegisterUrlRequest registerUrlRequest = new RegisterUrlRequest();
		registerUrlRequest.setConfirmationURL(mpesaConfiguration.getConfirmationURL());
		registerUrlRequest.setResponseType(mpesaConfiguration.getResponseType());
		registerUrlRequest.setShortCode(mpesaConfiguration.getShortCode());
		registerUrlRequest.setValidationURL(mpesaConfiguration.getValidationURL());
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(registerUrlRequest)));
		
		Request request = new Request.Builder()
				.url(mpesaConfiguration.getRegisterUrlEndpoint())
				.post(body)
				.addHeader("Authorization", String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
				.build();
		
		try {
			Response response = okHttpClient.newCall(request).execute();
			
			assert response.body() != null;
			
			return objectMapper.readValue(response.body().string(), RegisterUrlResponse.class);
		} catch(IOException e) {
			String errorMessage = String.format("Could not register url -> %s", e.getMessage());
			LoggerFactory.getLogger(TransactionServiceImpl.class).error(errorMessage, e);
			return null;
		}
	}
	
	@Override
	public SimulateTransactionResponse createC2BTransaction(C2BData c2BData) {
		AccessTokenResponse accessTokenResponse = getAccessToken();
		
		SimulateTransactionRequest simulateTransactionRequest = new SimulateTransactionRequest();
		
		simulateTransactionRequest.setShortCode(c2BData.getShortCode());
		simulateTransactionRequest.setCommandID(c2BData.getCommandID());
		simulateTransactionRequest.setMsisdn(c2BData.getMsisdn());
		simulateTransactionRequest.setAmount(c2BData.getAmount());
		simulateTransactionRequest.setBillRefNumber(c2BData.getBillRefNumber());
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(simulateTransactionRequest)));
		
		Request request = new Request.Builder()
				.url(mpesaConfiguration.getSimulateTransactionEndpoint())
				.post(body)
				.addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
				.build();
		
		try {
			Response response = okHttpClient.newCall(request).execute();
			assert response.body() != null;
			
			String responseBody = response.body().string();
			
			AccountEntity accountEntity = accountRepository.findById(c2BData.getReceiverAccountNumber()).get();
			
			int oldAmount = accountEntity.getBalance();
			
			int amount = Integer.parseInt(c2BData.getAmount());
			
			int total = amount + oldAmount;
			
			accountEntity.setBalance(total);
			accountRepository.save(accountEntity);

			// Use ObjectMapper to deserialize the response into your DTO
			SimulateTransactionResponse simulateTransactionResponse = objectMapper.readValue(responseBody, SimulateTransactionResponse.class);
			
			C2bEntity c2bEntity = new C2bEntity();
			
			c2bEntity.setSenderName(c2BData.getSenderName());
			c2bEntity.setMerchant(c2BData.getMerchant());
			c2bEntity.setReceiverAccountNumber(c2BData.getReceiverAccountNumber());			
			c2bEntity.setShortCode(c2BData.getShortCode());
			c2bEntity.setCommandID(c2BData.getCommandID());
			c2bEntity.setMsisdn(c2BData.getMsisdn());
			c2bEntity.setAmount(c2BData.getAmount());
			c2bEntity.setBillRefNumber(c2BData.getBillRefNumber());
			c2bEntity.setResponseDescription(simulateTransactionResponse.getResponseDescription());
			c2bEntity.setResponseCode(simulateTransactionResponse.getResponseCode());
			c2bEntity.setOriginatorCoversationID(simulateTransactionResponse.getOriginatorCoversationID());
			
			c2BRepository.save(c2bEntity);
			
			return simulateTransactionResponse;
		
//			return objectMapper.readValue(response.body().string(), SimulateTransactionResponse.class);
		} catch(IOException e) {
			LoggerFactory.getLogger(TransactionServiceImpl.class).error("Could not simulate C2B transaction -> {}", e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public SimulateTransactionResponse simulateC2BTransaction(SimulateTransactionRequest simulateTransactionRequest) {
		AccessTokenResponse accessTokenResponse = getAccessToken();
		
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(simulateTransactionRequest)));
		
		System.out.println(simulateTransactionRequest);
		
		Request request = new Request.Builder()
				.url(mpesaConfiguration.getSimulateTransactionEndpoint())
				.post(body)
				.addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
				.build();
		
		try {
			Response response = okHttpClient.newCall(request).execute();
			assert response.body() != null;
			
			
			
			return objectMapper.readValue(response.body().string(), SimulateTransactionResponse.class);
			
		} catch(IOException e) {
			LoggerFactory.getLogger(TransactionServiceImpl.class).error("Could not simulate C2B transaction -> {}", e.getLocalizedMessage());
			return null;
		}
						
	}
	
	

	@Override
	public CommonSyncResponse performB2CTransaction(InternalB2CTransactionRequest internalB2CTransactionRequest) {
		AccessTokenResponse accessTokenResponse = getAccessToken();
		Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
		logger.info("Access Token: {}", accessTokenResponse.getAccessToken());
		
		B2CTransactionRequest b2CTransactionRequest = new B2CTransactionRequest();
		
		b2CTransactionRequest.setCommandID(internalB2CTransactionRequest.getCommandID());
        b2CTransactionRequest.setAmount(internalB2CTransactionRequest.getAmount());
        b2CTransactionRequest.setPartyB(internalB2CTransactionRequest.getPartyB());
        b2CTransactionRequest.setRemarks(internalB2CTransactionRequest.getRemarks());
        b2CTransactionRequest.setOccassion(internalB2CTransactionRequest.getOccassion());
		
        try {
        	b2CTransactionRequest.setSecurityCredential(HelperUtility.getSecurityCredentials(mpesaConfiguration.getB2cInitiatorPassword()));	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        logger.info("Security Creds: {}", b2CTransactionRequest.getSecurityCredential());

        // set the result url ...
        b2CTransactionRequest.setResultURL(mpesaConfiguration.getB2cResultUrl());
        b2CTransactionRequest.setQueueTimeOutURL(mpesaConfiguration.getB2cQueueTimeoutUrl());
        b2CTransactionRequest.setInitiatorName(mpesaConfiguration.getB2cInitiatorName());
        b2CTransactionRequest.setPartyA(mpesaConfiguration.getShortCode());
        
        @SuppressWarnings("deprecation")
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(b2CTransactionRequest)));
        
        Request request = new Request.Builder()
                .url(mpesaConfiguration.getB2cTransactionEndpoint())
                .post(body)
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
                .build();
        
        try {
        	Response response = okHttpClient.newCall(request).execute();
        	
        	assert response.body() != null;
        	
        	return objectMapper.readValue(response.body().string(), CommonSyncResponse.class);
        } catch (IOException e) {
        	logger.error("Could not perform B2C transaction ->{}", e.getLocalizedMessage());
        	return null;
        }
	}

	@Override
	public CommonSyncResponse createB2CTransaction(B2CData b2CData) {
		AccessTokenResponse accessTokenResponse = getAccessToken();
		Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
		logger.info("Access Token: {}", accessTokenResponse.getAccessToken());
		
		B2CTransactionRequest b2CTransactionRequest = new B2CTransactionRequest();
		
		b2CTransactionRequest.setCommandID(b2CData.getCommandID());
		b2CTransactionRequest.setAmount(b2CData.getAmount());
		b2CTransactionRequest.setPartyB(b2CData.getPartyB());
		b2CTransactionRequest.setRemarks(b2CData.getRemarks());
		b2CTransactionRequest.setOccassion(b2CData.getOccassion());
		
		try {
        	b2CTransactionRequest.setSecurityCredential(HelperUtility.getSecurityCredentials(mpesaConfiguration.getB2cInitiatorPassword()));	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        logger.info("Security Creds: {}", b2CTransactionRequest.getSecurityCredential());
        
        // set the result url ...
        b2CTransactionRequest.setResultURL(mpesaConfiguration.getB2cResultUrl());
        b2CTransactionRequest.setQueueTimeOutURL(mpesaConfiguration.getB2cQueueTimeoutUrl());
        b2CTransactionRequest.setInitiatorName(mpesaConfiguration.getB2cInitiatorName());
        b2CTransactionRequest.setPartyA(mpesaConfiguration.getShortCode());
		
		@SuppressWarnings("deprecation")
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(b2CTransactionRequest)));
        
        Request request = new Request.Builder()
                .url(mpesaConfiguration.getB2cTransactionEndpoint())
                .post(body)
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
                .build();
        
        try {
        	Response response = okHttpClient.newCall(request).execute();
        	
        	assert response.body() != null;
        	
        	String responseBody = response.body().string();
        	
        	AccountEntity accountEntity = accountRepository.findById(b2CData.getSenderAccount()).get();
        	
        	int oldAmount = accountEntity.getBalance();
        	
        	int amount = Integer.parseInt(b2CData.getAmount());
        	
        	int newAmount = oldAmount - amount;
        	
        	accountEntity.setBalance(newAmount);
        	accountRepository.save(accountEntity);

			// Use ObjectMapper to deserialize the response into your DTO
        	CommonSyncResponse commonSyncResponse = objectMapper.readValue(responseBody, CommonSyncResponse.class);
        	
        	B2cEntity b2cEntity = new B2cEntity();
        	
        	b2cEntity.setSenderAccount(b2CData.getSenderAccount());
        	b2cEntity.setMerchant(b2CData.getMerchant());
        	b2cEntity.setCommandID(b2CData.getCommandID());
        	b2cEntity.setAmount(b2CData.getAmount());
        	b2cEntity.setPartyB(b2CData.getPartyB());
        	b2cEntity.setRemarks(b2CData.getRemarks());
        	b2cEntity.setOccassion(b2CData.getOccassion());
        	b2cEntity.setConversationID(commonSyncResponse.getConversationID());
        	b2cEntity.setResponseCode(commonSyncResponse.getResponseCode());
        	b2cEntity.setOriginatorConversationID(commonSyncResponse.getOriginatorConversationID());
        	b2cEntity.setResponseDescription(commonSyncResponse.getResponseDescription());
        	
        	b2CRepository.save(b2cEntity);
        	
//        	return objectMapper.readValue(response.body().string(), CommonSyncResponse.class);
        	return commonSyncResponse;
        } catch (IOException e) {
        	logger.error("Could not perform B2C transaction ->{}", e.getLocalizedMessage());
        	return null;
        }
	}

	@Override
	public ITransactionEntity saveITransaction(@Valid ITransactionEntity iTransactionEntity) {
		AccountEntity senderAccount = accountRepository.findById(iTransactionEntity.getSenderAccount()).get();
		AccountEntity receiverAccount = accountRepository.findById(iTransactionEntity.getReceiverAccount()).get();
		
		int oldSenderBalance = senderAccount.getBalance();
		int oldReceiverBalance = receiverAccount.getBalance();
		
		int amount = iTransactionEntity.getAmount();
		
		int newSenderBalance = oldSenderBalance - amount;
		int newReceiverBalance = oldReceiverBalance + amount;
		
		senderAccount.setBalance(newSenderBalance);
		receiverAccount.setBalance(newReceiverBalance);
		
		accountRepository.save(senderAccount);
		accountRepository.save(receiverAccount);
		
		return iTransactionRepository.save(iTransactionEntity);
	}

	

}
