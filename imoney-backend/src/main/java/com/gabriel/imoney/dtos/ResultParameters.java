package com.gabriel.imoney.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameters {

	@JsonProperty("ResultParameter")
	private List<ResultParameterItem> resultParameter;

	public List<ResultParameterItem> getResultParameter() {
		return resultParameter;
	}

	public void setResultParameter(List<ResultParameterItem> resultParameter) {
		this.resultParameter = resultParameter;
	}

	public ResultParameters() {

	}

	public ResultParameters(List<ResultParameterItem> resultParameter) {
		this.resultParameter = resultParameter;
	}

	@Override
	public String toString() {
		return "ResultParameters [resultParameter=" + resultParameter + "]";
	}
	
	
}
