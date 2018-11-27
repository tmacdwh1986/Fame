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

import com.zbw.fame.service.DayDistanceService;
import com.zbw.fame.util.RestResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/day")
public class DayDistanceController {
	@Autowired
	private DayDistanceService dayDistanceService;

	@GetMapping("distance/{city}")
	public RestResponse statDayDistance(@PathVariable(value = "city") String city) {

		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String[] xAxis = new String[] { "0=<distance<1km", "1=<distance<10km", "10=<distance<20km", "20=<distance<30km",
				"30=<distance<40km", "40=<distance<50km", "50=<distance<60km", "60=<distance<70km", "70=<distance<80km",
				"80=<distance<90km", "90=<distance<100km", "100=<distance<120km", "120=<distance<150km",
				"150=<distance<200km", "distance>=200km" };
		String[] xAxisAccu = new String[] { "0=<distance<1km", "0=<distance<10km", "0=<distance<20km",
				"0=<distance<30km", "0=<distance<40km", "0=<distance<50km", "0=<distance<60km", "0=<distance<70km",
				"0=<distance<80km", "0=<distance<90km", "0=<distance<100km", "0=<distance<120km", "0=<distance<150km",
				"0=<distance<200km", "distance>=200km" };
		int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int len = countArr.length;
		String[] isWorkArr = new String[] { "1", "2", "0" };
		for (int i = 0; i < isWorkArr.length; i++) {
			long s = System.currentTimeMillis();
			log.info("query start:{}", s);
			Map<String, Integer> mp = dayDistanceService.statDayDistance(isWorkArr[i], city);
			long e = System.currentTimeMillis();
			log.info("query end:{},query cost:{}", e, (e - s));
			int total = mp.get("total");
			float[] yAxis = new float[len];
			float[] yAxisAccu = new float[len];
			for (int j = 0; j < len; j++) {
				String xValue = xAxis[j];
				Integer data = mp.get(xValue);
				if (data != null) {
					countArr[j] = data;
				}
				yAxis[j] = (float) countArr[j] * 100 / total;

				if (j == 0 || j == len - 1) {
					yAxisAccu[j] = (float) countArr[j] * 100 / total;
				} else {
					yAxisAccu[j] = (float) (countArr[j] + countArr[j - 1]) * 100 / total;
					countArr[j] = countArr[j] + countArr[j - 1];
				}
			}

			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("xAxis", xAxis);
			ret.put("yAxis", yAxis);
			ret.put("xAxisAccu", xAxisAccu);
			ret.put("yAxisAccu", yAxisAccu);

			log.info("xAxis:{}", Arrays.toString(xAxis));
			log.info("yAxis:{}", Arrays.toString(yAxis));
			log.info("xAxisAccu:{}", Arrays.toString(xAxisAccu));
			log.info("yAxisAccu:{}", Arrays.toString(yAxisAccu));
			log.info("[DEBUG]distance return value: {}", ret);
			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}

	@GetMapping("duration/{city}")
	public RestResponse statDayDurationRange(@PathVariable(value = "city") String city) {

		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String[] isWorkArr = new String[] { "1", "2", "0" };
		for (int i = 0; i < isWorkArr.length; i++) {
			Map<String, Integer> mp = dayDistanceService.statDayDurationRange(isWorkArr[i], city);

			String[] xAxis = new String[] { "T<20Min", "20Min=<T<40Min", "40Min=<T<60Min", "60Min=<T<80Min",
					"80Min=<T<100Min", "100Min=<T<120Min", "120Min=<T<140Min", "140Min=<T<160Min", "160Min=<T<180Min",
					"180Min=<T<200Min", "200Min=<T<220Min", "220Min=<T<240Min", "240Min=<T<260Min", "260Min=<T<280Min",
					"280Min=<T<300Min", "T>=300Min" };
			String[] xAxisAccu = new String[] { "T<20Min", "T<40Min", "T<60Min", "T<80Min", "T<100Min", "T<120Min",
					"T<140Min", "T<160Min", "T<180Min", "T<200Min", "T<220Min", "T<240Min", "T<260Min", "T<280Min",
					"T<300Min", "T>=300Min" };
			int[] countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int len = countArr.length;
			int total = mp.get("total");
			float[] yAxis = new float[len];
			float[] yAxisAccu = new float[len];
			for (int j = 0; j < len; j++) {
				String xValue = xAxis[j];
				Integer data = mp.get(xValue);
				if (data != null) {
					countArr[j] = data;
				}
				yAxis[j] = (float) countArr[j] * 100 / total;

				if (j == 0 || j == len - 1) {
					yAxisAccu[j] = (float) countArr[j] * 100 / total;
				} else {
					yAxisAccu[j] = (float) (countArr[j] + countArr[j - 1]) * 100 / total;
					countArr[j] = countArr[j] + countArr[j - 1];
				}
			}

			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("xAxis", xAxis);
			ret.put("yAxis", yAxis);
			ret.put("xAxisAccu", xAxisAccu);
			ret.put("yAxisAccu", yAxisAccu);

			log.info("xAxis:{}", Arrays.toString(xAxis));
			log.info("yAxis:{}", Arrays.toString(yAxis));
			log.info("xAxisAccu:{}", Arrays.toString(xAxisAccu));
			log.info("yAxisAccu:{}", Arrays.toString(yAxisAccu));
			log.info("[DEBUG]distance return value: {}", ret);

			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}

	@GetMapping("avgDayDistance/{city}")
	public RestResponse statAvgTripDistance(@PathVariable(value = "city") String city) {
		Map<String, Object> ret = new HashMap<String, Object>();
		String[] isWorkArr = new String[] { "1", "2", "0" };
		String[] xAxis = new String[] { "Holiday", "Work Day", "Natural Day" };
		int[] yAxis = new int[] { 0, 0, 0 };
		for (int i = 0; i < isWorkArr.length; i++) {
			int avg = dayDistanceService.statVinAvgDayDistance(isWorkArr[i], city);
			yAxis[i] = avg;
		}
		ret.put("xAxis", xAxis);
		log.info("xAxis:{}", Arrays.toString(xAxis));
		ret.put("yAxis", yAxis);
		log.info("yAxis:{}", Arrays.toString(yAxis));
		return RestResponse.ok(ret);
	}

	@GetMapping("avgDayDuration/{city}")
	public RestResponse statAvgTripDuration(@PathVariable(value = "city") String city) {
		Map<String, Object> ret = new HashMap<String, Object>();
		String[] isWorkArr = new String[] { "1", "2", "0" };
		String[] xAxis = new String[] { "Holiday", "Work Day", "Natural Day" };
		int[] yAxis = new int[] { 0, 0, 0 };
		for (int i = 0; i < isWorkArr.length; i++) {
			int avg = dayDistanceService.getDayAvgDuration(isWorkArr[i], city);
			yAxis[i] = avg;
		}
		ret.put("xAxis", xAxis);
		log.info("xAxis:{}", Arrays.toString(xAxis));
		ret.put("yAxis", yAxis);
		log.info("yAxis:{}", Arrays.toString(yAxis));
		return RestResponse.ok(ret);
	}
}
