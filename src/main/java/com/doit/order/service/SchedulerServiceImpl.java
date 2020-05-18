package com.doit.order.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.SchedulerModel;
import com.doit.order.repository.ProductTypeDB;
import com.doit.order.repository.SchedulerDB;

@Service
@Transactional
public class SchedulerServiceImpl implements SchedulerService {
	@Autowired
	private SchedulerDB schedulerDB;
	
	@Autowired
	private ProductTypeDB productTypeDB;
	
	@Override
	public SchedulerModel changeScheduler(String uuid, SchedulerModel scheduler) {
		Optional<SchedulerModel> schedulerRes = schedulerDB.findByUuid(uuid);
		if (schedulerRes.isPresent()) {
			SchedulerModel schedulerNew = schedulerRes.get();
			schedulerNew.setDay(scheduler.getDay());
			schedulerNew.setTime(scheduler.getTime());
			
			LocalDateTime now = LocalDateTime.now();
			Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant()); 
			schedulerNew.setUpdatedTime(date);
			
			schedulerDB.save(schedulerNew);
			return schedulerNew;
		} else {
			return null;
		}
	}

	@Override
	public List<SchedulerModel> addDefaultScheduler() {
		SchedulerModel sched1 = new SchedulerModel();
		sched1.setDay(3);
		sched1.setTime("12:00");
		sched1.setMessage("Pinjaman kamu sudah mendekati jatuh tempo");
		
		SchedulerModel sched2 = new SchedulerModel();
		sched2.setDay(2);
		sched2.setTime("15:00");
		sched2.setMessage("Hai, dalam dua hari lagi pinjaman kamu sudah masuk jatuh tempo");
		
		SchedulerModel sched3 = new SchedulerModel();
		sched3.setDay(2);
		sched3.setTime("09:00");
		sched3.setMessage("Besok pinjaman kamu jatuh tempo, pastikan kamu sudah mempersiapkan dana pembayarannya");
		
		LocalDateTime now = LocalDateTime.now();
		Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		
		sched1.setCreatedTime(date);
		sched1.setUpdatedTime(date);
		
		sched2.setCreatedTime(date);
		sched2.setUpdatedTime(date);
		
		sched3.setCreatedTime(date);
		sched3.setUpdatedTime(date);
		
		sched1.setDisabled(0);
		sched2.setDisabled(0);
		sched3.setDisabled(0);
		
		List<SchedulerModel> listOfScheduler = new ArrayList<>();
		listOfScheduler.add(sched1);
		listOfScheduler.add(sched2);
		listOfScheduler.add(sched3);
		
		return listOfScheduler;
	}
	
	
}
