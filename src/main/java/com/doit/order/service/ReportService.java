package com.doit.order.service;

import java.util.List;

import java.util.Optional;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.ReportModel;

public interface ReportService {


	List<ReportModel> getAllReport();
	Optional<ReportModel> getReportByPeriod(String period);
	void deleteByMonth(String Period);


	
	
	
	/**
	 * 	months.put("January", 1);months.put( "February", 2);months.put("March", 3);months.put ("April",4);
			months.put("May",5);months.put("June",6 );months.put ("July",7 );months.put("August",8);
			months.put("September",9);months.put("October", 10);months.put("November",11);months.put("December",12);
	 
	 *
	 *	months.put(1, "January");months.put(2, "February");months.put(3,"March");months.put (4, "April");
			months.put(5, "May");months.put(6, "June");months.put (7, "July");months.put(8, "August");
			months.put(9, "September");months.put(10, "October");months.put(11, "November");months.put(12, "December");
	 */
}


