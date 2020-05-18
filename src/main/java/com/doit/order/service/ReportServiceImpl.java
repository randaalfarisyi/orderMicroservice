package com.doit.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doit.order.model.ReportModel;
import com.doit.order.repository.ReportDB;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDB reportDB;
	
	@Override
	public List<ReportModel> getAllReport(){
		return reportDB.findAll();
	}
}
