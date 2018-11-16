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

import com.zbw.fame.service.SOCService;
import com.zbw.fame.util.RestResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/soc/")
public class SOCController {
	@Autowired
	private SOCService socService;

	@GetMapping("ChrgSOC/{city}/{flag}")
	public RestResponse statChrgSOCDistri(@PathVariable(value = "city") String city,
			@PathVariable(value = "flag") String flag) {
		Map<String, Integer> mp = new HashMap<String, Integer>();
		if (flag.equals("start")) {
			mp = socService.statChrgStartSOC(city);
		} else if (flag.equals("end")) {
			mp = socService.statChrgEndSOC(city);
		} else if (flag.equals("delta")) {
			mp = socService.statChrgDeltaSOC(city);
		}

		String[] xAxis = new String[] { "0=<soc<10%", "10=<soc<20%", "20=<soc<30%", "30=<soc<40%", "40=<soc<50%",
				"50=<soc<60%", "70=<soc<80%", "80=<soc<90%", "90=<soc<100%", "soc>=100%" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
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

	@GetMapping("DrivingSOC/{city}")
	public RestResponse statDrivingSOCDistr(@PathVariable(value = "city") String city) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String[] holiday_flag = new String[] { "1", "2", "0" };
		for (int i = 0; i < holiday_flag.length; i++) {
			Map<String, Object> ret = new HashMap<String, Object>();
			Map<String, Integer> mp = socService.statDriveSOC(holiday_flag[i], city);

			String[] xAxis = new String[] { "soc<10%", "10%=<soc<20%", "20%=<soc<30%", "30%=<soc<40%", "40%=<soc<50%",
					"50%=<soc<60%", "60%=<soc<70%", "70%=<soc<80%", "80%=<soc<90%", "90%=<soc<100%", "soc>=100%" };
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
