package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameterItem {

	@JsonProperty("Value")
	private String value;
	
	@JsonProperty("Key")
	private String key;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ResultParameterItem() {

	}

	public ResultParameterItem(String value, String key) {
		this.value = value;
		this.key = key;
	}

	@Override
	public String toString() {
		return "ResultParameterItem [value=" + value + ", key=" + key + "]";
	}
	
	
}
