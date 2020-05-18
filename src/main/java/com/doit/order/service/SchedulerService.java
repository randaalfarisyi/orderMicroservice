package com.doit.order.service;

import java.util.List;

import com.doit.order.model.SchedulerModel;

public interface SchedulerService {
	SchedulerModel changeScheduler(String uuid, SchedulerModel scheduler);
	
	List<SchedulerModel> addDefaultScheduler();
}
