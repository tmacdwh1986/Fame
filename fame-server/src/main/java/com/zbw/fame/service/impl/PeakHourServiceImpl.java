package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbw.fame.repository.PeakHourRepository;
import com.zbw.fame.service.PeakHourService;

@Service
public class PeakHourServiceImpl implements PeakHourService {
	@Autowired
	private PeakHourRepository peakHourRepository;

	@Override
	public Map<String, Integer> statPeakHour(String holidayFlag, String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {// 节假日
			if (city.equals("All")) {
				list = peakHourRepository.statPeakHourAllInHoliday(holidayFlag);
			} else {
				list = peakHourRepository.statPeakHourByCityInHoliday(holidayFlag, city);
			}

		} else if (holidayFlag.equals("2")) {// 非节假日
			if (city.equals("All")) {
				list = peakHourRepository.statPeakHourAllNotInHoliday(holidayFlag);
			} else {
				list = peakHourRepository.statPeakHourByCityNotInHoliday(holidayFlag, city);
			}
		} else {// 全部
			if (city.equals("All")) {
				list = peakHourRepository.statPeakHourAll();
			} else {
				list = peakHourRepository.statPeakHourByCity(city);
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
