package com.doit.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.ReportModel;

@Repository
public interface ReportDB extends JpaRepository<ReportModel, Long> {

}
