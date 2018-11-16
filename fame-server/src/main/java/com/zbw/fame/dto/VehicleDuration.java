package com.zbw.fame.dto;

public class VehicleDuration {
	private String duration_range;
	private int counts;
	private int avg_duration;

	public String getDuration_range() {
		return duration_range;
	}

	public void setDuration_range(String duration_range) {
		this.duration_range = duration_range;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getAvg_duration() {
		return avg_duration;
	}

	public void setAvg_duration(int avg_duration) {
		this.avg_duration = avg_duration;
	}

}
