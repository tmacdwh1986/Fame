package com.zbw.fame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zbw.fame.model.VehicleCity;

public interface SOCRepository extends JpaRepository<VehicleCity, String> {
	@Query(value = "SELECT elt(INTERVAL(start_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.start_soc from stat_vehicle_soc_bef_aft_charge a)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgStartSOC();

	@Query(value = "SELECT elt(INTERVAL(start_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.start_soc from stat_vehicle_soc_bef_aft_charge a "
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgStartSOCByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(end_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.end_soc from stat_vehicle_soc_bef_aft_charge a)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgEndSOC();

	@Query(value = "SELECT elt(INTERVAL(end_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.end_soc from stat_vehicle_soc_bef_aft_charge a "
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgEndSOCByCity(@Param("city") String city);

	@Query(value = "SELECT elt(INTERVAL(delta_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.delta_soc from stat_vehicle_soc_bef_aft_charge a)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgDeltaSOC();

	@Query(value = "SELECT elt(INTERVAL(delta_soc,0,10,20,30,40,50,60,70,80,90,100),'01/0=<soc<10%', '02/10=<soc<20%', "
			+ " '03/20=<soc<30%', '04/30=<soc<40%', '05/40=<soc<50%','06/50=<soc<60%','07/60=<soc<70%','08/70=<soc<80%',"
			+ " '09/80=<soc<90%','10/90=<soc<100%','11/soc>=100%') as soc_range,count(vin) as counts FROM "
			+ " (select a.vin,a.delta_soc from stat_vehicle_soc_bef_aft_charge a "
			+ " join vehicle_city vc on a.vin = vc.vin and vc.city = :city)r GROUP BY soc_range", nativeQuery = true)
	public List<Object[]> statChrgDeltaSOCByCity(@Param("city") String city);

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ " group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOC();

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ "where a.holiday_flag = :holidayFlag group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOCInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ "where a.holiday_flag = :holidayFlag group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOCNotInHoliday(@Param("holidayFlag") String holidayFlag);

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOCByCity(@Param("city") String city);

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOCByCityInHoliday(@Param("holidayFlag") String holidayFlag, @Param("city") String city);

	@Query(value = "select a.soc_range,sum(a.counts) counts from stat_vehicle_drive_soc a "
			+ "join vehicle_city vc on a.vin = vc.vin and vc.city = :city "
			+ "where a.holiday_flag = :holidayFlag group by soc_range", nativeQuery = true)
	List<Object[]> statDriveSOCByCityNotInHoliday(@Param("holidayFlag") String holidayFlag, @Param("city") String city);
}
