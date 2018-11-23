package com.zbw.fame.service;

import java.util.Map;

public interface DayDistanceService {
	public Map<String, Integer> statDayDistance(String holidayFlag, String city);

	public int statVinAvgDayDistance(String holidayFlag, String city);

	public Map<String, Integer> statDayDurationRange(String holidayFlag, String city);

	public int getDayAvgDuration(String holidayFlag, String city);
}
