package com.doit.order.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import com.doit.order.model.ProductTypeModel;

public interface ProductTypeService {


	Optional<ProductTypeModel> getProductTypeDetailByUuid(String uuid);

	List<ProductTypeModel> getAllProductType();

	ProductTypeModel addProductType(ProductTypeModel productType);
	
	Optional<ProductTypeModel> getProductTypeByNameAndAmount(String name, Long amountApply);

	ProductTypeModel changeProduct(ProductTypeModel productUpdated);
	
	List<ProductTypeModel> getProductTypeByName(String name);

	List<ProductTypeModel> getAllActiveProductType();
}
