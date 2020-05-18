package com.doit.order.service;

import java.util.List;

import com.doit.order.model.ProductCategoryModel;

public interface ProductCategoryService {
	List<ProductCategoryModel> getAllActiveProductCategory();
}
