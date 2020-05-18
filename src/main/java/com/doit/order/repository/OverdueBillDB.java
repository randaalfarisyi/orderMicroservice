package com.doit.order.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.OverdueBillModel;

@Repository
public interface OverdueBillDB extends JpaRepository<OverdueBillModel, Long> {
	
	

}
