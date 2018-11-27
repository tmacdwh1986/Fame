package com.zbw.fame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zbw.fame.model.VehicleCity;

public interface PeakHourRepository extends JpaRepository<VehicleCity, String> {
	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourAll();

	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "where a.holiday_flag = :holidayFlag group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourAllInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "where a.holiday_flag = :holidayFlag group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourAllNotInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourByCity(@Param("city") String city);

	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourByCityInHoliday(@Param("holidayFlag") String holidayFlag, @Param("city") String city);

	@Query(value = "select a.hour_range,sum(a.counts) counts from stat_peak_hour_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by hour_range", nativeQuery = true)
	List<Object[]> statPeakHourByCityNotInHoliday(@Param("holidayFlag") String holidayFlag, @Param("city") String city);
}
