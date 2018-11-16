package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbw.fame.repository.TripDistanceRepository;
import com.zbw.fame.service.TripDistanceService;

@Service
public class TripDistanceServiceImpl implements TripDistanceService {

	@Autowired
	private TripDistanceRepository tripDistanceRepository;

	@Override
	public Map<String, Integer> statTripDistanceRange(String holidayFlag, String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDistanceRangeInHoliday();
			} else {
				list = tripDistanceRepository.statTripDistanceRangeByCityInHoliday(city);
			}

		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDistanceRangeNotInHoliday();
			} else {
				list = tripDistanceRepository.statTripDistanceRangeByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDistanceRange();
			} else {
				list = tripDistanceRepository.statTripDistanceRangeByCity(city);
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
	public int statTripAvgDistance(String holidayFlag, String city) {
		Object obj = null;
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDistanceInHoliday();
			} else {
				obj = tripDistanceRepository.getTripAvgDistanceByCityInHoliday(city);
			}

		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDistanceNotInHoliday();
			} else {
				obj = tripDistanceRepository.getTripAvgDistanceByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDistance();
			} else {
				obj = tripDistanceRepository.getTripAvgDistanceByCity(city);
			}
		}
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, Integer> statTripDurationRange(String holidayFlag, String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDurationRangeInHoliday();
			} else {
				list = tripDistanceRepository.statTripDurationRangeByCityInHoliday(city);
			}
		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDurationRangeNotInHoliday();
			} else {
				list = tripDistanceRepository.statTripDurationRangeByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				list = tripDistanceRepository.statTripDurationRange();
			} else {
				list = tripDistanceRepository.statTripDurationRangeByCity(city);
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
	public int getTripAvgDuration(String holidayFlag, String city) {
		Object obj = null;
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDurationInHoliday();
			} else {
				obj = tripDistanceRepository.getTripAvgDurationByCityInHoliday(city);
			}

		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDurationNotInHoliday();
			} else {
				obj = tripDistanceRepository.getTripAvgDurationByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				obj = tripDistanceRepository.getTripAvgDuration();
			} else {
				obj = tripDistanceRepository.getTripAvgDurationByCity(city);
			}
		}
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		} else {
			return -1;
		}
	}

}
