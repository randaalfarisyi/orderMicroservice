package com.doit.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.ProductCategoryModel;

@Repository
public interface ProductCategoryDB extends JpaRepository<ProductCategoryModel, Long> {
	List<ProductCategoryModel> findByDisabled(int disabled);
	Optional<ProductCategoryModel> findByUuid(String uuid);
}
