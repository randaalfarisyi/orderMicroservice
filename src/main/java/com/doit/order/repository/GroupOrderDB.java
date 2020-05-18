package com.doit.order.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.GroupOrderModel;
import com.doit.order.model.OrderModel;


@Repository
public interface GroupOrderDB extends JpaRepository<GroupOrderModel, Long> {

	Optional<GroupOrderModel> findByUuid(String uuid);


	List<GroupOrderModel> findByUuidBorrower(String uuidBorrower);

	
}

