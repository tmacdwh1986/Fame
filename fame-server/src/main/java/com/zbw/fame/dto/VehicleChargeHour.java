package com.zbw.fame.dto;

public class VehicleChargeHour {
	private String charging_hour;
	private int counts;
	private String duration_range;

	public String getCharging_hour() {
		return charging_hour;
	}

	public void setCharging_hour(String charging_hour) {
		this.charging_hour = charging_hour;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getDuration_range() {
		return duration_range;
	}

	public void setDuration_range(String duration_range) {
		this.duration_range = duration_range;
	}
}
