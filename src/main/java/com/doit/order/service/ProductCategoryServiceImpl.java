package com.doit.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doit.order.model.ProductCategoryModel;
import com.doit.order.repository.ProductCategoryDB;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryDB productCategoryDB;
	
	@Override
	public List<ProductCategoryModel> getAllActiveProductCategory() {
		return productCategoryDB.findByDisabled(0);
	}
}
