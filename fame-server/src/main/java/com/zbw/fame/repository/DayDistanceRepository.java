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
			+ " where a.day in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceAllInHoliday();

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " where a.day not in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceAllNotInHoliday();

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.day in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCityInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (SELECT a.vin, a.start_mileage,a.end_mileage, a.dayDistance ,a.day FROM stat_day_distance a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ " where a.day not in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statDayDistanceByCityNotInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance GROUP BY vin) a"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceAll();

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance "
			+ " where day in(select day from holiday where year = 2018) GROUP BY vin) a"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceAllInHoliday();

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance "
			+ " where day not in(select day from holiday where year = 2018) GROUP BY vin) a"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceAllNotInHoliday();

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance GROUP BY vin) a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance "
			+ " where day in(select day from holiday where year = 2018) GROUP BY vin) a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceByCityInHoliday(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(averageDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
			+ " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
			+ " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
			+ " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
			+ " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
			+ " FROM (select a.* from (SELECT vin,SUM(dayDistance) totalDistance,COUNT(vin) count,"
			+ " SUM(dayDistance) / COUNT(vin) averageDistance FROM stat_day_distance "
			+ " where day not in(select day from holiday where year = 2018) GROUP BY vin) a"
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city"
			+ " ) r GROUP BY distance_range", nativeQuery = true)
	List<Object[]> statAvgDayDistanceByCityNotInHoliday(@Param("city") String city);

}