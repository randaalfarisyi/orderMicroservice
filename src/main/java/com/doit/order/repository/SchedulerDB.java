package com.doit.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.SchedulerModel;

@Repository
public interface SchedulerDB extends JpaRepository<SchedulerModel, Long> {
	Optional<SchedulerModel> findByUuid(String uuid);
}
