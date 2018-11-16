package com.zbw.fame.service;

import java.util.Map;

public interface ChargingService {

	public Map<String, Integer> statChrgDistance(String city);

	public Map<String, Integer> statChrgStartTime(String city);

	public Map<String, Integer> statChrgEndTime(String city);

	public Map<String, Integer> statChrgDuration(String city);

}
