package com.zbw.fame.service;

import java.util.Map;

public interface PeakHourService {
	public Map<String, Integer> statPeakHour(String holidayFlag, String city);
}
