package com.zbw.fame.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zbw.fame.service.PeakHourService;
import com.zbw.fame.util.RestResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class PeakHourController {
	@Autowired
	private PeakHourService peakHourService;

	// @GetMapping("{city}")
	// public RestResponse statPeakHour(@PathVariable(value = "city") String
	// city) {
	@GetMapping("/period")
	public RestResponse statPeakHour() {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String[] holiday_flag = new String[] { "1", "2", "0" };
		String city = "All";
		String[] xAxis = new String[] { "0~3", "3~6", "6~7", "7~8", "8~9", "9~10", "10~11", "11~12", "12~13", "13~14",
				"14~15", "15~16", "16~17", "17~18", "18~19", "19~20", "20~21", "21~22", "22~24" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int len = countArr.length;
		for (int i = 0; i < holiday_flag.length; i++) {
			Map<String, Integer> mp = peakHourService.statPeakHour(holiday_flag[i], city);

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

			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}
}
