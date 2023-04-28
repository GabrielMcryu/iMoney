package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenResponse {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("expires_in")
	private String expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public AccessTokenResponse() {

	}

	public AccessTokenResponse(String accessToken, String expiresIn) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
	}
	
	
}
