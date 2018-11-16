package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbw.fame.repository.SOCRepository;
import com.zbw.fame.service.SOCService;

@Service
public class SOCServiceImpl implements SOCService {

	@Autowired
	private SOCRepository socRepository;

	@Override
	public Map<String, Integer> statChrgStartSOC(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = socRepository.statChrgStartSOC();
		} else {
			list = socRepository.statChrgStartSOCByCity(city);
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
	public Map<String, Integer> statChrgEndSOC(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = socRepository.statChrgEndSOC();
		} else {
			list = socRepository.statChrgEndSOCByCity(city);
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
	public Map<String, Integer> statChrgDeltaSOC(String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (city.equals("All")) {
			list = socRepository.statChrgDeltaSOC();
		} else {
			list = socRepository.statChrgDeltaSOCByCity(city);
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
	public Map<String, Integer> statDriveSOC(String holidayFlag, String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {// 节假日
			if (city.equals("All")) {
				list = socRepository.statDriveSOCInHoliday(holidayFlag);
			} else {
				list = socRepository.statDriveSOCByCityInHoliday(holidayFlag, city);
			}

		} else if (holidayFlag.equals("2")) {// 非节假日
			if (city.equals("All")) {
				list = socRepository.statDriveSOCNotInHoliday(holidayFlag);
			} else {
				list = socRepository.statDriveSOCByCityNotInHoliday(holidayFlag, city);
			}
		} else {// 全部
			if (city.equals("All")) {
				list = socRepository.statDriveSOC();
			} else {
				list = socRepository.statDriveSOCByCity(city);
			}
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
