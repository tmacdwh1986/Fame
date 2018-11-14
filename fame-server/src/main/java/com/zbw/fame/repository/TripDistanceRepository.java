package com.zbw.fame.repository;

import com.zbw.fame.model.VehicleCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripDistanceRepository {
    public interface DayDistanceRepository extends JpaRepository<VehicleCity, String> {
        @Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
                + " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
                + " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
                + " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
                + " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
                + " FROM (SELECT a.vin, a.distance FROM trip_distance a"
                + " where a.distance >= 0 and left(a.start_time, 10) in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
        List<Object[]> statTripDistanceRange_T1();

        @Query(value = "SELECT elt(INTERVAL(dayDistance,0, 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,120,150,200), "
                + " '01/0=<distance<1km', '02/1=<distance<10km', '03/10=<distance<20km', '04/20=<distance<30km', '05/30=<distance<40km', "
                + " '06/40=<distance<50km',	'07/50=<distance<60km', '08/60=<distance<70km', '09/70=<distance<80km', '10/80=<distance<90km',"
                + " '11/90=<distance<100km', '12/100=<distance<120km', '13/120=<distance<150km',"
                + " '14/150=<distance<200km', '15/distance>=200km') as distance_range, count(vin) as counts"
                + " FROM (SELECT a.vin, a.distance FROM trip_distance a"
                + " where a.distance >= 0 and left(a.start_time, 10) not in(select day from holiday where year = 2018)) r GROUP BY distance_range", nativeQuery = true)
        List<Object[]> statTripDistanceRange_T2();

        @Query(value = "SELECT round(AVG(distance)) avg_distance FROM trip_distance a WHERE DISTANCE >= 0 and left(a.start_time, 10) "
                + " in(SELECT day FROM holiday WHERE year = 2018)", nativeQuery = true)
        List<Object[]> getTripAvgDistance();

        @Query(value = "SELECT round(AVG(distance)) avg_distance FROM trip_distance a WHERE DISTANCE >= 0 and left(a.start_time, 10) "
                + " not in(SELECT day FROM holiday WHERE year = 2018)", nativeQuery = true)
        List<Object[]> getTripAvgDistance1();

        @Query(value = "SELECT round(AVG(distance)) avg_distance FROM trip_distance a WHERE DISTANCE >= 1 and left(a.start_time, 10) "
                + " in(SELECT day FROM holiday WHERE year = 2018)", nativeQuery = true)
        List<Object[]> getTripAvgDistance2();

        @Query(value = "SELECT round(AVG(distance)) avg_distance FROM trip_distance a WHERE DISTANCE >= 1 and left(a.start_time, 10) "
                + " not in(SELECT day FROM holiday WHERE year = 2018)", nativeQuery = true)
        List<Object[]> getTripAvgDistance3();

        @Query(value = "SELECT elt(INTERVAL(duration,0,600, 1200, 1800, 2400, 3000, 3600, 4200, 4800, 5400,6000,6600,7200,7800,8400,9000), "
                + "'01/T<10Min', '02/10Min=<T<20Min', '03/20Min=<T<30Min', '04/30Min=<T<40Min', '05/40Min=<T<50Min','06/50Min=<T<60Min','07/60Min=<T<70Min', "
                + "'08/70Min=<T<80Min', '09/80Min=<T<90Min', '10/90Min=<T<100Min', '11/100Min=<T<110Min','12/110Min=<T<120Min','13/120Min=<T<130Min',"
                + "'14/130Min=<T<140Min','15/140Min=<T<150Min','16/T>=150Min') as duration_range, count(vin) as counts"
                + " FROM (SELECT a.vin, a.duration FROM trip_distance a) r GROUP BY distance_range", nativeQuery = true)
        List<Object[]> statTripDurationRange();

        @Query(value = "select round(AVG(duration)) avg_duration from trip_distance")
        List<Object[]> getTripAvgDuration();

        @Query(value = "")
        List<Object[]> statDayDurationRange();

        @Query(value = "")
        List<Object[]> getDayAvgDuration();
    }
}
