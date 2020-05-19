package com.doit.order.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.SchedulerModel;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.repository.OrderDB;

import com.doit.order.repository.ProductTypeDB;
import com.doit.order.repository.SchedulerDB;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeDB productTypeDB;
	
	@Autowired
	private SchedulerService schedulerService;
	
	@Autowired
	private SchedulerDB schedulerDB;	
	
	@Override
    public Optional<ProductTypeModel> getProductTypeDetailByUuid (String uuid) {
        return productTypeDB.findByUuid(uuid);
    }
	
	@Override
	public ProductTypeModel addProductType(ProductTypeModel productType) {
		List<SchedulerModel> sched = schedulerService.addDefaultScheduler();
		ProductTypeModel prod = productTypeDB.save(productType);
		for (SchedulerModel s : sched) {
			s.setProductType(prod);
			schedulerDB.save(s);
		}
		return prod;
	}

	@Override
	public List<ProductTypeModel> getAllProductType() {
		return productTypeDB.findAll();
	}

	@Override
	public Optional<ProductTypeModel> getProductTypeByNameAndAmount(String name, Long amountApply) {
		return productTypeDB.findByNameAndAmountApply(name, amountApply);
	}

	@Override
	public ProductTypeModel changeProduct(ProductTypeModel productUpdated) {
		Optional<ProductTypeModel> newProduct = productTypeDB.findByUuid(productUpdated.getUuid());
		ProductTypeModel newProd = newProduct.get();
		if (newProduct.isPresent()) {
			newProd.setName(productUpdated.getName());
			newProd.setAmountApply(productUpdated.getAmountApply());
			newProd.setBorrowingTerm(productUpdated.getBorrowingTerm());
			newProd.setTenor(productUpdated.getTenor());
			newProd.setServiceFeeRate(productUpdated.getServiceFeeRate());
			newProd.setInterestRate(productUpdated.getInterestRate());
			newProd.setOverdueRate(productUpdated.getOverdueRate());
			newProd.setPenaltyRate(productUpdated.getPenaltyRate());
			newProd.setTargetNpl(productUpdated.getTargetNpl());
			return productTypeDB.save(newProd);
		}
		else {
			return null;
		}
	}

	@Override
	public List<ProductTypeModel> getProductTypeByName(String name) {
		// TODO Auto-generated method stub
		return productTypeDB.findByName(name);
	}
	
	@Override
	public List<ProductTypeModel> getAllActiveProductType() {
		return productTypeDB.findByDisabled(0);
	}
}
