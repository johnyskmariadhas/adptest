package com.adp.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertBillController {
	
	@GetMapping(path = "/adp-test/convert-bills/{bill}")
	public Map<Double, Integer> convertBills(@PathVariable String bill) {
		double amountInBills = Double.valueOf(bill).doubleValue();
		 Map<Double, Integer> coinCounts = new HashMap<>();
	        coinCounts.put(0.01, 0);
	        coinCounts.put(0.05, 0);
	        coinCounts.put(0.10, 0);
	        coinCounts.put(0.25, 0);

	        while (amountInBills >= 0.25) {
	            amountInBills -= 0.25;
	            coinCounts.put(0.25, coinCounts.get(0.25) + 1);
	        }

	        while (amountInBills >= 0.10) {
	            amountInBills -= 0.10;
	            coinCounts.put(0.10, coinCounts.get(0.10) + 1);
	        }

	        while (amountInBills >= 0.05) {
	            amountInBills -= 0.05;
	            coinCounts.put(0.05, coinCounts.get(0.05) + 1);
	        }

	        while (amountInBills >= 0.01) {
	            amountInBills -= 0.01;
	            coinCounts.put(0.01, coinCounts.get(0.01) + 1);
	        }

	        return coinCounts;
	}
	
	
	

}
