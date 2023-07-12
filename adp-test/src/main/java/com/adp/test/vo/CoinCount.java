package com.adp.test.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoinCount {
	
	
	private int oneCentCnt;
	private int fiveCentCnt;
	private int tenCentCnt;
	private int twentyFiveCentCnt;
	
	
	public int getOneCentCnt() {
		return oneCentCnt;
	}
	public void setOneCentCnt(int oneCentCnt) {
		this.oneCentCnt = oneCentCnt;
	}
	public int getFiveCentCnt() {
		return fiveCentCnt;
	}
	public void setFiveCentCnt(int fiveCentCnt) {
		this.fiveCentCnt = fiveCentCnt;
	}
	public int getTenCentCnt() {
		return tenCentCnt;
	}
	public void setTenCentCnt(int tenCentCnt) {
		this.tenCentCnt = tenCentCnt;
	}
	public int getTwentyFiveCentCnt() {
		return twentyFiveCentCnt;
	}
	public void setTwentyFiveCentCnt(int twentyFiveCentCnt) {
		this.twentyFiveCentCnt = twentyFiveCentCnt;
	}


}
