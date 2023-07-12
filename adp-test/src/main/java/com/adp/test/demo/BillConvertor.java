package com.adp.test.demo;

import java.util.HashMap;
import java.util.Map;

public class BillConvertor {
	//coins possible 0.01,0.05,0.10,0.25
	static int OneCentCnt = 0;
	static int FiveCentCnt = 0;
	static int TenCentCnt = 0;
	static int TwentyFiveCentCnt = 0;
	
	BillConvertor(int one, int five, int ten, int twentyFive) {
		OneCentCnt = one;
		FiveCentCnt = five;
		TenCentCnt = ten;
		TwentyFiveCentCnt = twentyFive;
	}
	
	
	// bills in can be (1,2,5,10,20,50,100), an amount is given made of those bills
	public Map<String, Integer> convertBills(int amount) {
		if(amount <= 0) return null; // Invalid input amount
		double amt = amount;
		Map<String, Integer> valueMap = new HashMap<>();
		if(Double.compare(amt, 0) > 0 && TwentyFiveCentCnt > 0) {
			int num = Math.min((int)amt * 4, TwentyFiveCentCnt); // .25*4 = 1$
			amt -= num / 4; // cnt/4 - number of $
			valueMap.put("TwentyFiv", num); // cnt
			TwentyFiveCentCnt -= num; // already used cnt, so reducing
		}
		if(Double.compare(amt, 0) > 0 && TenCentCnt > 0) {
			int num = Math.min((int)amt * 10, TenCentCnt);
			amt -= num / 10;
			valueMap.put("Ten", num);
			TenCentCnt -= num;
		}
		if(Double.compare(amt, 0) > 0 && FiveCentCnt > 0) {
			int num = Math.min((int)amt * 20, FiveCentCnt);
			amt -= num / 20;
			valueMap.put("Five", num);
			FiveCentCnt -= num;
		}
		if(Double.compare(amt, 0) > 0 && OneCentCnt > 0) {
			int num = Math.min((int)amt * 100, OneCentCnt);
			amt -= num / 100;
			valueMap.put("One", num);
			OneCentCnt -= num;
		}
		if(Double.compare(amt, 0) > 0) return null; // couldn't find all coins to convert given bill amount
		return valueMap;
	}
	
	public static void main(String[] args) {
		
		BillConvertor obj = new BillConvertor(100, 100, 100, 100);
		
		System.out.println(obj.convertBills(20));
		System.out.println(obj.convertBills(10));
		System.out.println(obj.convertBills(5));
		
	}
	

}
