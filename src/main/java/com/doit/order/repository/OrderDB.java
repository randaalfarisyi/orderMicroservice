package com.doit.order.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.OrderModel;


@Repository
public interface OrderDB extends JpaRepository<OrderModel, Long> {

	Optional<OrderModel> findByUuid(String uuid);


	List<OrderModel> findByUuidBorrower(String uuidBorrower);

	
}

