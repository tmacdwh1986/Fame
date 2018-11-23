package com.zbw.fame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import com.zbw.fame.dataobject.TripDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int statVinAvgDayDistance(String holidayFlag, String city) {
		Object obj = null;
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDistanceAllInHoliday();
			} else {
				obj = dayDistanceRepository.statAvgDayDistanceByCityInHoliday(city);
			}
		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDistanceAllNotInHoliday();
			} else {
				obj = dayDistanceRepository.statAvgDayDistanceByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDistanceAll();
			} else {
				obj = dayDistanceRepository.statAvgDayDistanceByCity(city);
			}
		}
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, Integer> statDayDurationRange(String holidayFlag, String city) {
		List<Object[]> list = new ArrayList<Object[]>();
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDurationRangeAllInHoliday();
			} else {
				list = dayDistanceRepository.statDayDurationRangeByCityInHoliday(city);
			}
		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDurationRangeAllNotInHoliday();
			} else {
				list = dayDistanceRepository.statDayDurationRangeByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				list = dayDistanceRepository.statDayDurationRangeAll();
			} else {
				list = dayDistanceRepository.statDayDurationRangeByCity(city);
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
	public int getDayAvgDuration(String holidayFlag, String city) {
		Object obj = null;
		if (holidayFlag.equals("1")) {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDurationAllInHoliday();
			} else {
				obj = dayDistanceRepository.statAvgDayDurationByCityInHoliday(city);
			}

		} else if (holidayFlag.equals("2")) {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDurationAllNotInHoliday();
			} else {
				obj = dayDistanceRepository.statAvgDayDurationByCityNotInHoliday(city);
			}
		} else {
			if (city.equals("All")) {
				obj = dayDistanceRepository.statAvgDayDurationAll();
			} else {
				obj = dayDistanceRepository.statAvgDayDurationByCity(city);
			}
		}
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		} else {
			return -1;
		}
	}

}
