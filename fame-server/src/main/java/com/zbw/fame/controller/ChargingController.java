package com.zbw.fame.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zbw.fame.service.ChargingService;
import com.zbw.fame.util.RestResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ChargingController {
	@Autowired
	private ChargingService chargingService;

	@GetMapping("/ChrgDistance")
	// public RestResponse statChargingDistance(@PathVariable(value = "city")
	// String city) {
	public RestResponse statChargingDistance() {
		String city = "All";
		Map<String, Integer> mp = chargingService.statChrgDistance(city);

		String[] xAxis = new String[] { "distance<50km", "50=<distance<100km", "100=<distance<200km",
				"200=<distance<300km", "300=<distance<400km", "400=<distance<500km", "500=<distance<600km",
				"600=<distance<700km", "distance>=700km" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int len = countArr.length;
		int total = mp.get("total");
		float[] yAxis = new float[len];
		for (int j = 0; j < len; j++) {
			String xValue = xAxis[j];
			Integer data = mp.get(xValue);
			if (data != null) {
				countArr[j] = data;
			}
			yAxis[j] = (float) countArr[j] * 100 / total;
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		log.info("xAxis:{}", Arrays.toString(xAxis));
		log.info("yAxis:{}", Arrays.toString(yAxis));
		ret.put("total", total);

		return RestResponse.ok(ret);
	}

	@GetMapping("ChrgTime/{city}/{flag}")
	public RestResponse statChrgTimeDistr(@PathVariable(value = "city") String city,
			@PathVariable(value = "flag") String flag) {
		Map<String, Integer> mp = new HashMap<String, Integer>();
		if (flag.equals("start")) {
			mp = chargingService.statChrgStartTime(city);
		} else if (flag.equals("end")) {
			mp = chargingService.statChrgEndTime(city);
		}

		String[] xAxis = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int len = countArr.length;
		int total = mp.get("total");
		float[] yAxis = new float[len];
		for (int j = 0; j < len; j++) {
			String xValue = xAxis[j];
			Integer data = mp.get(xValue);
			if (data != null) {
				countArr[j] = data;
			}
			yAxis[j] = (float) countArr[j] * 100 / total;
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		log.info("xAxis:{}", Arrays.toString(xAxis));
		log.info("yAxis:{}", Arrays.toString(yAxis));

		return RestResponse.ok(ret);
	}

	@GetMapping("/ChrgDuration")
	// public RestResponse statChrgDurationDistr(@PathVariable(value = "city")
	// String city) {
	public RestResponse statChrgDurationDistr() {
		String city = "All";
		Map<String, Integer> mp = chargingService.statChrgDuration(city);

		String[] xAxis = new String[] { "T<1", "1=<T<2", "2=<T<3", "3=<T<4", "4=<T<5", "5=<T<6", "6=<T<7", "7=<T<8",
				"T>=8" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int len = countArr.length;
		int total = mp.get("total");
		float[] yAxis = new float[len];
		for (int j = 0; j < len; j++) {
			String xValue = xAxis[j];
			Integer data = mp.get(xValue);
			if (data != null) {
				countArr[j] = data;
			}
			yAxis[j] = (float) countArr[j] * 100 / total;
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		log.info("xAxis:{}", Arrays.toString(xAxis));
		log.info("yAxis:{}", Arrays.toString(yAxis));

		return RestResponse.ok(ret);
	}

}
