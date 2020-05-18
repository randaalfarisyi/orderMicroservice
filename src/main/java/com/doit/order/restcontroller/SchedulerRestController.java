package com.doit.order.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.doit.order.model.SchedulerModel;
import com.doit.order.service.SchedulerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SchedulerRestController {
	@Autowired
	private SchedulerService schedulerService;
	
	@PutMapping(value = "/scheduler/{uuid}")
	public SchedulerModel updateScheduler(@PathVariable("uuid") String uuid, @RequestBody SchedulerModel scheduler) {
		SchedulerModel changedScheduler = schedulerService.changeScheduler(uuid, scheduler);
		if (changedScheduler != null)
			return changedScheduler;
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler Not Found");
		}
	}
}
