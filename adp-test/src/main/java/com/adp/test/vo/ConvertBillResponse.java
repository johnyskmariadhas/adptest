package com.adp.test.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvertBillResponse {
	
	private Map<String, Integer> valueMap;
	private String error;
	
	public Map<String, Integer> getValueMap() {
		return valueMap;
	}
	public void setValueMap(Map<String, Integer> valueMap) {
		this.valueMap = valueMap;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
