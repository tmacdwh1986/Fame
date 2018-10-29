package com.zbw.fame.controller.distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zbw.fame.dto.VehicleDistance;
import com.zbw.fame.service.DayDistanceService;
import com.zbw.fame.util.RestResponse;

@RestController
@RequestMapping("/api")
public class DayDistanceController {
	@Autowired
	private DayDistanceService dayDistanceService;

	@PostMapping("/statDayDistanceDistr")
	public RestResponse statDayDistance(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		String flag = request.getParameter("flag");
		String city = request.getParameter("city");
		String[] isWorkArr = new String[] { "1", "2", "0" };
		List<VehicleDistance> list = new ArrayList<VehicleDistance>();
		for (int i = 0; i < isWorkArr.length; i++) {
			Map<String, Object> ret = new HashMap<String, Object>();
			list = dayDistanceService.statDayDistance(isWorkArr[i], city);

			String[] xAxis = new String[] {};
			String[] xAxisAccu = new String[] {};
			int[] countArr = new int[] {};
			if (flag.equals("0")) {
				xAxis = new String[] { "0=<distance<1km", "1=<distance<10km", "10=<distance<20km", "20=<distance<30km",
						"30=<distance<40km", "40=<distance<50km", "50=<distance<60km", "60=<distance<70km",
						"70=<distance<80km", "80=<distance<90km", "90=<distance<100km", "100=<distance<120km",
						"120=<distance<150km", "150=<distance<200km", "distance>=200km" };
				countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			} else if (flag.equals("1")) {
				list.remove(0);
				xAxis = new String[] { "1=<distance<10km", "10=<distance<20km", "20=<distance<30km",
						"30=<distance<40km", "40=<distance<50km", "50=<distance<60km", "60=<distance<70km",
						"70=<distance<80km", "80=<distance<90km", "90=<distance<100km", "100=<distance<120km",
						"120=<distance<150km", "150=<distance<200km", "distance>=200km" };
				countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			}
			xAxisAccu = new String[xAxis.length];

			int total = 0;
			for (int j = 0; j < xAxis.length; j++) {
				String xValue = xAxis[j];
				for (int k = 0; k < list.size(); k++) {
					VehicleDistance data = list.get(k);
					String distanceRange = data.getDistance_range().substring(3, data.getDistance_range().length());
					if (xValue.equals(distanceRange)) {
						int counts = data.getCounts();
						countArr[j] = counts;
						total = total + counts;
						break;
					}
				}
				if (xValue.indexOf("=<") != -1) {
					if (flag.equals("0")) {
						xAxisAccu[j] = "0=<" + xValue.substring(xValue.indexOf("=<") + 2, xValue.length());
					} else if (flag.equals("1")) {
						xAxisAccu[j] = "1=<" + xValue.substring(xValue.indexOf("=<") + 2, xValue.length());
					}
				} else {
					xAxisAccu[j] = xValue;
				}
			}
			float[] yAxis = new float[countArr.length];
			for (int j = 0; j < countArr.length; j++) {
				yAxis[j] = (float) countArr[j] * 100 / total;
			}
			ret.put("xAxis", xAxis);
			ret.put("yAxis", yAxis);

			ret.put("xAxisAccu", xAxisAccu);
			float[] yAxisAccu = new float[countArr.length];
			for (int k = 0; k < countArr.length; k++) {
				if (k == 0 || k == countArr.length - 1) {
					yAxisAccu[k] = (float) countArr[k] * 100 / total;
				} else {
					int accu = 0;
					for (int j = k; j >= 0; j--) {
						accu = accu + countArr[j];
					}
					yAxisAccu[k] = (float) accu * 100 / total;
				}

			}
			ret.put("yAxisAccu", yAxisAccu);

			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}
}
