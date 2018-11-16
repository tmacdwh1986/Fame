package com.zbw.fame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zbw.fame.model.VehicleCity;

public interface ChargingRepository extends JpaRepository<VehicleCity, String> {
	@Query(value = "SELECT elt(INTERVAL(distance,0,50,100, 200, 300, 400, 500, 600, 700), '00/distance<50km',"
			+ " '01/50=<distance<100km','02/100=<distance<200km', '03/200=<distance<300km', '04/300=<distance<400km',"
			+ " '05/400=<distance<500km','06/500=<distance<600km','07/600=<distance<700km', '08/distance>=700km') "
			+ " as distance_range, count(vin) as counts FROM (SELECT a.vin,a.distance FROM stat_accu_distance_bef_charge a) "
			+ " r GROUP BY distance_range", nativeQuery = true)
	public List<Object[]> statChargingDistanceAll();

	@Query(value = "SELECT elt(INTERVAL(distance,0,50,100, 200, 300, 400, 500, 600, 700), '00/distance<50km',"
			+ " '01/50=<distance<100km','02/100=<distance<200km', '03/200=<distance<300km', '04/300=<distance<400km',"
			+ " '05/400=<distance<500km','06/500=<distance<600km','07/600=<distance<700km', '08/distance>=700km') "
			+ " as distance_range, count(vin) as counts FROM (SELECT a.vin,a.distance FROM stat_accu_distance_bef_charge a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city) "
			+ " r GROUP BY distance_range", nativeQuery = true)
	public List<Object[]> statChargingDistanceByCity(@Param("city") String city);

	@Query(value = "SELECT CONVERT( SUBSTR(CONVERT_TZ(start_time,'+00:00','+08:00'), 12, 2) , SIGNED) AS charging_hour,"
			+ " COUNT(1) as counts FROM stat_vehicle_charge_time a GROUP BY charging_hour ORDER BY charging_hour", nativeQuery = true)
	public List<Object[]> statChrgStartTime();

	@Query(value = "SELECT CONVERT( SUBSTR(CONVERT_TZ(start_time,'+00:00','+08:00'), 12, 2) , SIGNED) AS charging_hour, "
			+ " COUNT(1) as counts FROM stat_vehicle_charge_time a join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ " GROUP BY charging_hour ORDER BY charging_hour", nativeQuery = true)
	public List<Object[]> statChrgStartTimeByCity(@Param("city") String city);

	@Query(value = "SELECT CONVERT( SUBSTR(CONVERT_TZ(end_time,'+00:00','+08:00'), 12, 2) , SIGNED) AS charging_hour, "
			+ " COUNT(1) as counts FROM stat_vehicle_charge_time a GROUP BY charging_hour ORDER BY charging_hour", nativeQuery = true)
	public List<Object[]> statChrgEndTime();

	@Query(value = "SELECT CONVERT( SUBSTR(CONVERT_TZ(end_time,'+00:00','+08:00'), 12, 2) , SIGNED) AS charging_hour, "
			+ "COUNT(1) as counts FROM stat_vehicle_charge_time a join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ " GROUP BY charging_hour ORDER BY charging_hour", nativeQuery = true)
	public List<Object[]> statChrgEndTimeByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(duration,0,3600,7200,10800,14400,18000,21600,25200,28800),'01/T<1', '02/1=<T<2',"
			+ " '03/2=<T<3', '04/3=<T<4', '05/4=<T<5','06/5=<T<6','07/6=<T<7','08/7=<T<8', '09/T>=8') as duration_range,"
			+ " count(vin) as counts FROM (select a.vin,a.duration from stat_vehicle_charge_time a) r GROUP BY duration_range", nativeQuery = true)
	public List<Object[]> statChrgDuration();

	@Query(value = "SELECT elt(INTERVAL(duration,0,3600,7200,10800,14400,18000,21600,25200,28800),'01/T<1', '02/1=<T<2',"
			+ " '03/2=<T<3', '04/3=<T<4', '05/4=<T<5','06/5=<T<6','07/6=<T<7','08/7=<T<8', '09/T>=8') as duration_range,"
			+ " count(vin) as counts FROM (select a.vin,a.duration from stat_vehicle_charge_time a "
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city) r GROUP BY duration_range", nativeQuery = true)
	public List<Object[]> statChrgDurationByCity(@Param("city") String city);

}
