package com.zbw.fame.service;

import java.util.List;
import java.util.Map;

import com.zbw.fame.dto.VehicleDistance;

public interface DayDistanceService {
	public Map<String, Integer> statDayDistance(String holidayFlag, String city);

	List<VehicleDistance> statVinAvgDayDistance(String holidayFlag, String city);

	// public List<VehicleDistance> statVinAvgDayDistance(String holidayFlag,
	// String city);

	// public List<VehicleDistance> statTripDistance(String holidayFlag);
}
