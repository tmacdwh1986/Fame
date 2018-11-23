package com.zbw.fame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zbw.fame.model.VehicleCity;

public interface DayDistanceRepository extends JpaRepository<VehicleCity, String> {

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceAll();

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " inner join holiday h on a.day = h.day and h.year = 2018) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceAllInHoliday();

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " where a.day not in(select h.day from holiday h where h.year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceAllNotInHoliday();

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ " inner join holiday h on a.day = h.day and h.year = 2018) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCityInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ " where a.day not in(select h.day from holiday h where h.year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCityNotInHoliday(@Param("city") String city);

	@Query(value = "select CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance", nativeQuery = true)
	Object statAvgDayDistanceAll();

	@Query(value = "SELECT CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance a "
			+ " inner join holiday h on a.day = h.day and h.year = 2018 ", nativeQuery = true)
	Object statAvgDayDistanceAllInHoliday();

	@Query(value = "SELECT CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance a where a.day not in( "
			+ " select h.day from holiday h where h.year = 2018 ) ", nativeQuery = true)
	Object statAvgDayDistanceAllNotInHoliday();

	@Query(value = "select CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city", nativeQuery = true)
	Object statAvgDayDistanceByCity(@Param("city") String city);

	@Query(value = "select CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city"
			+ " inner join holiday h on a.day = h.day and h.year = 2018 ", nativeQuery = true)
	Object statAvgDayDistanceByCityInHoliday(@Param("city") String city);

	@Query(value = "SELECT CAST(round(AVG(dayDistance)) AS UNSIGNED) avg_distance FROM stat_day_distance a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city where a.day not in( "
			+ " select h.day from holiday h where h.year = 2018 ) ", nativeQuery = true)
	Object statAvgDayDistanceByCityNotInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select vin,left(start_time,10),sum(duration) as duration"
			+ " from trip_distance group by vin,left(start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeAll();

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select vin,left(start_time,10),sum(duration) as duration"
			+ " from trip_distance group by vin,left(start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeAllInHoliday();

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select vin,left(start_time,10),sum(duration) as duration"
			+ " from trip_distance group by vin,left(start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeAllNotInHoliday();

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select a.vin,left(a.start_time,10),sum(a.duration) as duration"
			+ " from trip_distance a inner join vehicle_city vc on a.vin = vc.vin "
			+ " and vc.city = :city group by a.vin,left(a.start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select a.vin,left(a.start_time,10),sum(a.duration) as duration"
			+ " from trip_distance a inner join vehicle_city vc on a.vin = vc.vin "
			+ " and vc.city = :city inner join holiday h on left(a.start_time, 10) = h.day and h.year = 2018 "
			+ " group by a.vin,left(a.start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeByCityInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(duration,0,1200,2400,3600,4800,6000,7200,8400,9600,10800,12000,13200,"
			+ " 14400,15600,16800,18000),'01/T<20Min', '02/20Min=<T<40Min', '03/40Min=<T<60Min', '04/60Min=<T<80Min', "
			+ " '05/80Min=<T<100Min','06/100Min=<T<120Min','07/120Min=<T<140Min','08/140Min=<T<160Min', '09/160Min=<T<180Min', "
			+ " '10/180Min=<T<200Min', '11/200Min=<T<220Min', '12/220Min=<T<240Min', '13/240Min=<T<260Min','14/260Min=<T<280Min',"
			+ " '15/280Min=<T<300Min','16/T>=300Min') as duration_range, count(vin)	as counts FROM ("
			+ " select a.vin,left(a.start_time,10) as day,sum(a.duration) as duration"
			+ " from trip_distance a inner join vehicle_city vc on a.vin = vc.vin "
			+ " and vc.city = :city where left(a.start_time, 10) not in(select h.day from holiday h where h.year = 2018 ) "
			+ " group by a.vin,left(a.start_time,10)) r GROUP BY duration_range", nativeQuery = true)
	List<Object[]> statDayDurationRangeByCityNotInHoliday(@Param("city") String city);

	@Query(value = "select round(AVG(duration)) avg_duration FROM ("
			+ " select vin,left(start_time,10) day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a", nativeQuery = true)
	Object statAvgDayDurationAll();

	@Query(value = "SELECT round(AVG(duration)) avg_duration FROM  ("
			+ " select vin,left(start_time,10) as day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a "
			+ " inner join holiday h on a.day = h.day and h.year = 2018 ", nativeQuery = true)
	Object statAvgDayDurationAllInHoliday();

	@Query(value = "SELECT round(AVG(duration)) avg_duration FROM  ("
			+ " select vin,left(start_time,10) as day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a where a.day not in( "
			+ " select h.day from holiday h where h.year = 2018 ) ", nativeQuery = true)
	Object statAvgDayDurationAllNotInHoliday();

	@Query(value = "select round(AVG(duration)) avg_duration FROM ("
			+ " select vin,left(start_time,10) as day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city", nativeQuery = true)
	Object statAvgDayDurationByCity(@Param("city") String city);

	@Query(value = "select round(AVG(duration)) avg_duration FROM ("
			+ " select vin,left(start_time,10) as day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city"
			+ " inner join holiday h on a.day = h.day and h.year = 2018 ", nativeQuery = true)
	Object statAvgDayDurationByCityInHoliday(@Param("city") String city);

	@Query(value = "select round(AVG(duration)) avg_duration FROM ("
			+ " select vin,left(start_time,10) as day,sum(duration) as duration "
			+ " from trip_distance group by vin,day) a"
			+ " inner join vehicle_city vc on a.vin = vc.vin and vc.city = :city where a.day not in( "
			+ " select h.day from holiday h where h.year = 2018 ) ", nativeQuery = true)
	Object statAvgDayDurationByCityNotInHoliday(@Param("city") String city);

}