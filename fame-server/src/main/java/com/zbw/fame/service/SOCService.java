package com.zbw.fame.service;

import java.util.Map;

public interface SOCService {
	public Map<String, Integer> statChrgStartSOC(String city);

	public Map<String, Integer> statChrgEndSOC(String city);

	public Map<String, Integer> statChrgDeltaSOC(String city);

	public Map<String, Integer> statDriveSOC(String holidayFlag, String city);
}
