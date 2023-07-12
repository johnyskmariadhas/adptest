package com.adp.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adp.test.vo.CoinCount;
import com.adp.test.vo.ConvertBillResponse;


/**
 * 
 * @author johny
 *
 */
@RestController
public class ConvertBillController {
	//coins possible 0.01,0.05,0.10,0.25
	static int oneCentCnt = 0;
	static int fiveCentCnt = 0;
	static int tenCentCnt = 0;
	static int twentyfiveCentCnt = 0;
	
	private Map<String, CoinCount> coinsMap =  new HashMap<>();
	
	@PostMapping(path = "/adp-test/convert-bills/{billAmount}")
	public ResponseEntity<ConvertBillResponse> convertBills(@PathVariable String billAmount, @RequestBody CoinCount coinCount) {
		
		if (!coinsMap.isEmpty()) {
			coinCount =  coinsMap.get("coins");
		} else {
			coinsMap.put("coins", coinCount);
		}
		oneCentCnt = coinCount.getOneCentCnt();
		fiveCentCnt = coinCount.getFiveCentCnt();
		tenCentCnt = coinCount.getTenCentCnt();
		twentyfiveCentCnt = coinCount.getTwentyFiveCentCnt();

		
		double amt = Double.valueOf(billAmount).doubleValue();
		
		Map<String, Integer> valueMap = new HashMap<>();
		ConvertBillResponse response = new ConvertBillResponse();
		
		if(amt <= 0) {
			response.setError("Please input valid Bill Amount!");
			return ResponseEntity.ok(response);
		} else {
			if(Double.compare(amt, 0) > 0 && twentyfiveCentCnt > 0) {
				int num = Math.min((int)amt * 4, twentyfiveCentCnt); 
				amt -= num / 4;
				valueMap.put("TwentyFiv", num); // cnt
				twentyfiveCentCnt -= num; 
				coinCount.setTwentyFiveCentCnt(twentyfiveCentCnt);
			}
			if(Double.compare(amt, 0) > 0 && tenCentCnt > 0) {
				int num = Math.min((int)amt * 10, tenCentCnt);
				amt -= num / 10;
				valueMap.put("Ten", num);
				tenCentCnt -= num;
				coinCount.setTenCentCnt(tenCentCnt);
			}
			if(Double.compare(amt, 0) > 0 && fiveCentCnt > 0) {
				int num = Math.min((int)amt * 20, fiveCentCnt);
				amt -= num / 20;
				valueMap.put("Five", num);
				fiveCentCnt -= num;
				coinCount.setFiveCentCnt(fiveCentCnt);
			}
			if(Double.compare(amt, 0) > 0 && oneCentCnt > 0) {
				int num = Math.min((int)amt * 100, oneCentCnt);
				amt -= num / 100;
				valueMap.put("One", num);
				oneCentCnt -= num;
				coinCount.setOneCentCnt(oneCentCnt);
			}
			response.setValueMap(valueMap);
			coinsMap.put("coins", coinCount);
		}
		
		if(Double.compare(amt, 0) > 0) {
			response.setError("Couldn't find all coins to convert given bill amount!");
			return ResponseEntity.ok(response);
		}
		
		
		return ResponseEntity.ok(response);
	}
	

}
