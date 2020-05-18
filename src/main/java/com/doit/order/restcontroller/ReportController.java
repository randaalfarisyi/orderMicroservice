package com.doit.order.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doit.order.model.ReportModel;
import com.doit.order.service.ReportService;

@RestController
@RequestMapping("/api")
public class ReportController {
	@Autowired
	ReportService reportService;
	
	@GetMapping(value ="/report")
	public List<ReportModel> getAllReport() {
		List<ReportModel> report = reportService.getAllReport();
		return report;
	}
}
