package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import com.zbw.fame.dataobject.TripDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbw.fame.dto.VehicleDistance;
import com.zbw.fame.repository.DayDistanceRepository;
import com.zbw.fame.service.DayDistanceService;

@Service
public class DayDistanceServiceImpl implements DayDistanceService {

	@Autowired
	private DayDistanceRepository dayDistanceRepository;

	// @Autowired
	// private TripDistance tripDistanceRepository;

	@Override
	public Map<String, Integer> statDayDistance(String holidayFlag, String city) {

		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDistanceAllInHoliday();
			} else {
				list = dayDistanceRepository.statDayDistanceByCityInHoliday(city);
			}

		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDistanceAllNotInHoliday();
			} else {
				list = dayDistanceRepository.statDayDistanceByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDistanceAll();
			} else {
				list = dayDistanceRepository.statDayDistanceByCity(city);
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

	@Override
	public List<VehicleDistance> statVinAvgDayDistance(String holidayFlag, String city) {
		List<VehicleDistance> ret = new ArrayList<VehicleDistance>();
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statAvgDayDistanceAllInHoliday();
			} else {
				list = dayDistanceRepository.statAvgDayDistanceByCityInHoliday(city);
			}
		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statAvgDayDistanceAllNotInHoliday();
			} else {
				list = dayDistanceRepository.statAvgDayDistanceByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				list = dayDistanceRepository.statAvgDayDistanceAll();
			} else {
				list = dayDistanceRepository.statAvgDayDistanceByCity(city);
			}
		}
		for (Object[] obj : list) {
			VehicleDistance e = new VehicleDistance();
			e.setDistance_range(obj[0].toString());
			e.setCounts(Integer.valueOf(obj[1].toString()));
			ret.add(e);
		}
		return ret;
	}

	// @Override
	// public List<VehicleDistance> statTripDistance(String holidayFlag) {
	// return null;
	// }
}
