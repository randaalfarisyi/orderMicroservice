package com.doit.order.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.service.ProductTypeService;

@Repository
public interface ProductTypeDB extends JpaRepository<ProductTypeModel, Long> {


	Optional<ProductTypeModel> findByUuid(String uuid);
	
	Optional<ProductTypeModel> findByNameAndAmountApply(String name, Long borrowingAmount);
	
	List<ProductTypeModel> findByName (String name);
	
	List<ProductTypeModel> findByDisabled(int disabled);

}
