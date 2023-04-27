package com.gabriel.imoney.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")
public class MpesaConfiguration {
	private String consumerKey;
	private String consumerSecret;
	private String grantType;
	private String oauthEndpoint;
	private String registerUrlEndpoint;
	private String simulateTransactionEndpoint;
	private String shortCode;
	private String confirmationURL;
	private String validationURL;
	private String responseType;
	private String b2cTransactionEndpoint;
	private String b2cResultUrl;
	private String b2cQueueTimeoutUrl;
	private String b2cInitiatorName;
	private String b2cInitiatorPassword;
	
	public String getConsumerKey() {
		return consumerKey;
	}
	
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	
	public String getConsumerSecret() {
		return consumerSecret;
	}
	
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	
	public String getGrantType() {
		return grantType;
	}
	
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	
	public String getOauthEndpoint() {
		return oauthEndpoint;
	}
	
	public void setOauthEndpoint(String oauthEndpoint) {
		this.oauthEndpoint = oauthEndpoint;
	}
	
	public String getRegisterUrlEndpoint() {
		return registerUrlEndpoint;
	}
	
	public void setRegisterUrlEndpoint(String registerUrlEndpoint) {
		this.registerUrlEndpoint = registerUrlEndpoint;
	}
	
	public String getSimulateTransactionEndpoint() {
		return simulateTransactionEndpoint;
	}
	
	public void setSimulateTransactionEndpoint(String simulateTransactionEndpoint) {
		this.simulateTransactionEndpoint = simulateTransactionEndpoint;
	}
	
	public String getShortCode() {
		return shortCode;
	}
	
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	
	public String getConfirmationURL() {
		return confirmationURL;
	}
	
	public void setConfirmationURL(String confirmationURL) {
		this.confirmationURL = confirmationURL;
	}
	
	public String getValidationURL() {
		return validationURL;
	}
	
	public void setValidationURL(String validationURL) {
		this.validationURL = validationURL;
	}
	
	public String getResponseType() {
		return responseType;
	}
	
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	public String getB2cTransactionEndpoint() {
		return b2cTransactionEndpoint;
	}
	
	public void setB2cTransactionEndpoint(String b2cTransactionEndpoint) {
		this.b2cTransactionEndpoint = b2cTransactionEndpoint;
	}
	
	public String getB2cResultUrl() {
		return b2cResultUrl;
	}
	
	public void setB2cResultUrl(String b2cResultUrl) {
		this.b2cResultUrl = b2cResultUrl;
	}
	
	public String getB2cQueueTimeoutUrl() {
		return b2cQueueTimeoutUrl;
	}
	
	public void setB2cQueueTimeoutUrl(String b2cQueueTimeoutUrl) {
		this.b2cQueueTimeoutUrl = b2cQueueTimeoutUrl;
	}
	
	public String getB2cInitiatorName() {
		return b2cInitiatorName;
	}
	
	public void setB2cInitiatorName(String b2cInitiatorName) {
		this.b2cInitiatorName = b2cInitiatorName;
	}
	
	public String getB2cInitiatorPassword() {
		return b2cInitiatorPassword;
	}
	
	public void setB2cInitiatorPassword(String b2cInitiatorPassword) {
		this.b2cInitiatorPassword = b2cInitiatorPassword;
	}

	@Override
	public String toString() {
		return "MpesaConfiguration [consumerKey=" + consumerKey + ", consumerSecret=" + consumerSecret + ", grantType="
				+ grantType + ", oauthEndpoint=" + oauthEndpoint + ", registerUrlEndpoint=" + registerUrlEndpoint
				+ ", simulateTransactionEndpoint=" + simulateTransactionEndpoint + ", shortCode=" + shortCode
				+ ", confirmationURL=" + confirmationURL + ", validationURL=" + validationURL + ", responseType="
				+ responseType + ", b2cTransactionEndpoint=" + b2cTransactionEndpoint + ", b2cResultUrl=" + b2cResultUrl
				+ ", b2cQueueTimeoutUrl=" + b2cQueueTimeoutUrl + ", b2cInitiatorName=" + b2cInitiatorName
				+ ", b2cInitiatorPassword=" + b2cInitiatorPassword + "]";
	}
	
	
}
