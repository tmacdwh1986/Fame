package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbw.fame.repository.ChargingRepository;
import com.zbw.fame.service.ChargingService;

@Service
public class ChargingServiceImpl implements ChargingService {

	@Autowired
	private ChargingRepository chargingRepository;

	@Override
	public Map<String, Integer> statChrgDistance(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = chargingRepository.statChargingDistanceAll();
		} else {
			list = chargingRepository.statChargingDistanceByCity(city);
		}
		int total = 0;
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Object[] obj : list) {
			String key = obj[0].toString();
			key = key.substring(3, key.length());
			Integer value = Integer.valueOf(obj[1].toString());
			ret.put(key, value);
			total = total + value;
		}
		ret.put("total", total);
		return ret;
	}

	@Override
	public Map<String, Integer> statChrgStartTime(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = chargingRepository.statChrgStartTime();
		} else {
			list = chargingRepository.statChrgStartTimeByCity(city);
		}
		int total = 0;
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Object[] obj : list) {
			String key = obj[0].toString();
			Integer value = Integer.valueOf(obj[1].toString());
			ret.put(key, value);
			total = total + value;
		}
		ret.put("total", total);
		return ret;
	}

	@Override
	public Map<String, Integer> statChrgEndTime(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = chargingRepository.statChrgEndTime();
		} else {
			list = chargingRepository.statChrgEndTimeByCity(city);
		}
		int total = 0;
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Object[] obj : list) {
			String key = obj[0].toString();
			Integer value = Integer.valueOf(obj[1].toString());
			ret.put(key, value);
			total = total + value;
		}
		ret.put("total", total);
		return ret;
	}

	@Override
	public Map<String, Integer> statChrgDuration(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = chargingRepository.statChrgDuration();
		} else {
			list = chargingRepository.statChrgDurationByCity(city);
		}
		int total = 0;
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Object[] obj : list) {
			String key = obj[0].toString();
			key = key.substring(3, key.length());
			Integer value = Integer.valueOf(obj[1].toString());
			ret.put(key, value);
			total = total + value;
		}
		ret.put("total", total);
		return ret;
	}

}
