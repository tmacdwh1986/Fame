package com.zbw.fame.service;

import java.util.Map;

public interface TripDistanceService {
	public Map<String, Integer> statTripDistanceRange(String holidayFlag, String city);

	public int statTripAvgDistance(String holidayFlag, String city);

	public Map<String, Integer> statTripDurationRange(String holidayFlag, String city);

	public int getTripAvgDuration(String holidayFlag, String city);

}
