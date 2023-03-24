package com.gabriel.imoney.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.imoney.entity.TransactionEntity;
import com.gabriel.imoney.service.TransactionService;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TransactionService transactionService;
	
	private TransactionEntity testTransaction;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		testTransaction = new TransactionEntity();
		testTransaction.setSenderName("Kelly");
		testTransaction.setAccountNumber(93847355);
		testTransaction.setAmount(500);
		testTransaction.setMerchant("Mpesa");
		Date createdAt = new Date();
		testTransaction.setCreatedAt(createdAt);
	}
	
	@Test
	void saveTransaction() throws Exception {
		TransactionEntity testTransaction2 = new TransactionEntity();
		testTransaction2.setSenderName("Kelly");
		testTransaction2.setAccountNumber(93847355);
		testTransaction2.setAmount(500);
		testTransaction2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		testTransaction2.setCreatedAt(createdAt2);
		
		Mockito.when(transactionService.saveTransaction(testTransaction)).thenReturn(testTransaction2);
		
		ResultActions response = mockMvc.perform(post("/api/v1/transactions")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(testTransaction2)));
		      
		response.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void getAllTransactions() throws Exception {
		TransactionEntity testTransaction2 = new TransactionEntity();
		testTransaction2.setSenderName("Kelly");
		testTransaction2.setAccountNumber(93847355);
		testTransaction2.setAmount(500);
		testTransaction2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		testTransaction2.setCreatedAt(createdAt2);
		
		Mockito.when(transactionService.fetchTransactionList()).thenReturn(List.of(testTransaction, testTransaction2));
		
		mockMvc.perform(get("/api/v1/transactions")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()").value(List.of(testTransaction, testTransaction2).size()))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void getAllTransactionsByAccountNumber() throws Exception {
		TransactionEntity testTransaction2 = new TransactionEntity();
		testTransaction2.setSenderName("Kelly");
		testTransaction2.setAccountNumber(93847355);
		testTransaction2.setAmount(500);
		testTransaction2.setMerchant("Mpesa");
		Date createdAt2 = new Date();
		testTransaction2.setCreatedAt(createdAt2);
		
		Mockito.when(transactionService.fetchTransactionsByAccountNumber("Mpesa", 93847355)).thenReturn(List.of(testTransaction, testTransaction2));
		
		mockMvc.perform(get("/api/v1/transactions/Mpesa/93847355")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()").value(List.of(testTransaction, testTransaction2).size()))
		.andDo(MockMvcResultHandlers.print());
	}
	
}
