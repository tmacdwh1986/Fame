package com.zbw.fame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zbw.fame.model.VehicleCity;

public interface AcceleratorRepository extends JpaRepository<VehicleCity, String> {
	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorAll();

	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "where a.holiday_flag = :holidayFlag group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorAllInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "where a.holiday_flag = :holidayFlag group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorAllNotInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorByCity(@Param("city") String city);

	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorByCityInHoliday(@Param("holidayFlag") String holidayFlag, @Param("city") String city);

	@Query(value = "select a.accel_range,sum(a.counts) counts from stat_accelerator_range a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by accel_range", nativeQuery = true)
	List<Object[]> statAcceleratorByCityNotInHoliday(@Param("holidayFlag") String holidayFlag,
			@Param("city") String city);
}
