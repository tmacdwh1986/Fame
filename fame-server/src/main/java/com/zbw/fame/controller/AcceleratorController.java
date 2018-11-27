package com.zbw.fame.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zbw.fame.service.AcceleratorService;
import com.zbw.fame.util.RestResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/accel")
public class AcceleratorController {
	@Autowired
	private AcceleratorService acceleratorService;

	@GetMapping("{city}")
	public RestResponse statAcceleratorRange(@PathVariable(value = "city") String city) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String[] holiday_flag = new String[] { "1", "2", "0" };
		for (int i = 0; i < holiday_flag.length; i++) {
			Map<String, Object> ret = new HashMap<String, Object>();
			Map<String, Integer> mp = acceleratorService.statAccelerator(holiday_flag[i], city);

			String[] xAxis = new String[] { "T<10%", "10%=<T<20%", "20%=<T<30%", "30%=<T<40%", "40%=<T<50%'",
					"50%=<T<60%", "60%=<T<70%", "70%=<T<80%", "80%=<T<90%", "90%=<T<100%", "T>=100%" };
			int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

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
			ret.put("xAxis", xAxis);
			ret.put("yAxis", yAxis);
			log.info("xAxis:{}", Arrays.toString(xAxis));
			log.info("yAxis:{}", Arrays.toString(yAxis));

			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}
}
