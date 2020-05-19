package com.doit.order.service;

import org.springframework.transaction.annotation.Transactional;


import com.doit.order.model.ReportModel;
import com.doit.order.repository.ReportDB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportDB reportDb;
	
	@Override
	public List<ReportModel> getAllReport(){
		// TODO Auto-generated method stub
		return reportDb.findAll();
	}

	@Override
	public Optional<ReportModel> getReportByPeriod(String period) {
		// TODO Auto-generated method stub
		return reportDb.findByPeriod(period);
	}

	@Override
	public void deleteByMonth(String Period) {
		// TODO Auto-generated method stub
		reportDb.deleteByPeriod(Period);
	}


}
