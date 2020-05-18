package com.doit.order.restcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doit.order.model.OrderModel;
import com.doit.order.model.OverdueBillModel;
import com.doit.order.model.ProductTypeModel;
import com.doit.order.rest.BaseResponse;
import com.doit.order.rest.LiveMetricsWrapper;
import com.doit.order.service.OrderService;
import com.doit.order.service.OverdueBillService;
import com.doit.order.service.ProductTypeService;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit; 


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class LiveMetricsController {
	@Autowired 
	ProductTypeService productTypeService;
	
	@Autowired 
	OrderService orderService;
	
	@GetMapping(value="/view/{name}/{borrowingAmount}")
	public Object retrieveMetrics(@PathVariable(value="name") String name,
			@PathVariable(value="borrowingAmount") String borrowingAmount) throws ParseException{
		BaseResponse<LiveMetricsWrapper> response = new BaseResponse<LiveMetricsWrapper>();
		LiveMetricsWrapper listLiveMetrics = new LiveMetricsWrapper(null, null, null, null, 
				 null, null,null, null, null, null, null, null) ;
		List<ProductTypeModel> all = productTypeService.getProductTypeByName(name);
		List<ProductTypeModel> detail = productTypeService.getAllProductType();
		try {
			long count_order =0;
			long count_this_month=0;
			long count_active = 0;
			long totalDisbursed =0;
			long totalService =0;
			long totalAmount =0;
			long totalCompleted=0;
			long total_outstanding_notover=0;
			long total_outstanding_overdue=0;
			long total_repaid_this_month = 0;
			Duration diff;
			int d1d2=0;
			int d3d7=0;
			int d8d30=0;
			int d31d90=0;
			int d91 = 0;
			long total_notover =0;
			long total_over=0;
			LocalDateTime now = LocalDateTime.now();
			
			/**
			 * for snapshot this month
			 */
			for(ProductTypeModel y: detail) {
				for(OrderModel o: y.getOrderList()) {
					//int as = o.getCreatedTime().getMonth()+1;
					//int ad = now.getMonthValue();
					//System.out.println(as+"as");
					//System.out.println(ad+"ad");
					//System.out.println(o.getCreatedTime().toInstant());
					if (now.getMonthValue() == o.getCreatedTime().getMonth()+1){
						count_this_month +=1;
						//System.out.println(count_this_month +"count this month");
						//System.out.println(o.getId());
						if(o.getStatus().equalsIgnoreCase("REPAYMENT_COMPLETED")) {
							total_repaid_this_month += o.getRepayAmount();	
							//System.out.println(total_repaid_this_month+"sss");
								}
					}
					else {
						//System.out.println("ok"+o.getId());
						//System.out.println(o.getId());
						break;
					}
				}
			}
			
			
			
			
			 for(ProductTypeModel product: all) {
				 List<OrderModel> listOfOrder = product.getOrderList();
				 for(OrderModel order : listOfOrder) {
					 if(borrowingAmount.equalsIgnoreCase("1") && order.getAmountApply() >= 10000000 && order.getAmountApply() <=50000000) {
						 	//all orders
							count_order +=1 ;
							System.out.println(count_order+"countorder <50jt");
							//System.out.println(order.getBorrowingAmount());
		
							
							
							//amount disburse = amount apply - service fee
							Long service = Math.round((double)(order.getAmountApply() * order.getServiceFeeRate()));
							//System.out.println(service +"service");
							totalService += service;
							System.out.println(totalService+ "totalservice");
							totalAmount += product.getAmountApply();
							System.out.println(totalAmount+ "totalAmount");
							totalDisbursed = totalAmount - totalService;
							System.out.println(totalDisbursed+ "totalDisbursed");
							
							//sum outstanding amount = total disbursed - total repay amount
							/**
							 * If not overdue -> Repay Amount = Amount Apply
							   If overdue -> Repay Amount = Amount Apply + Overdue Fee + Penalty Fee
							 */
							//if overdue
							
							if(((Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant())).toDays() >=1)) {
								total_over += order.getRepayAmount(); 
								System.out.println(total_over+ "totalover");
								total_outstanding_overdue = totalDisbursed - total_over;
								System.out.println(total_outstanding_overdue+"tot out over");
							}else { // not overdue
								total_notover += order.getRepayAmount();
								System.out.println(total_notover+"tot not");
								total_outstanding_notover = totalDisbursed - total_notover;
								System.out.println(total_outstanding_notover+"tot out not ");
							}
							
							//for bar chart: count days detail based on overdue
							if(!(order.getStatus().equalsIgnoreCase("REPAYMENT_COMPLETED"))) {
								//kalo positif dia telat  kalo negatif belom telat 
								diff = Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant());
								if(diff.toDays() >= 1 && diff.toDays() <=2) {
									d1d2+=1;
								}
								else if(diff.toDays() >= 3 && diff.toDays() <=7) {
									d3d7+=1;
								}
								else if(diff.toDays() >= 8 && diff.toDays() <=30) {
									d8d30+=1;
								}
								else if(diff.toDays()>=31 && diff.toDays() <=90) {
									d31d90+=1;
								}
								else {
									d91+=1;
								}	
							}
					 }
					 else {
						 if(borrowingAmount.equalsIgnoreCase("2") && order.getAmountApply() > 50000000) {
							 count_order +=1;
							 System.out.println(count_order+"order >50jt");
							 
							//amount disburse = amount apply - service fee
								Long service = Math.round((double)(order.getAmountApply() * order.getServiceFeeRate()));
								//System.out.println(service +"service");
								totalService += service;
								System.out.println(totalService+ "totalservice");
								totalAmount += product.getAmountApply();
								System.out.println(totalAmount+ "totalAmount");
								totalDisbursed = totalAmount - totalService;
								System.out.println(totalDisbursed+ "totalDisbursed");
								
								//sum outstanding amount = total disbursed - total repay amount
								/**
								 * If not overdue -> Repay Amount = Amount Apply
								   If overdue -> Repay Amount = Amount Apply + Overdue Fee + Penalty Fee
								 */
								//if overdue
								
								if(((Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant())).toDays() >=1)) {
									total_over += order.getRepayAmount(); 
									System.out.println(total_over+ "totalover");
									total_outstanding_overdue = totalDisbursed - total_over;
									System.out.println(total_outstanding_overdue+"tot out over");
								}else { // not overdue
									total_notover += order.getRepayAmount();
									System.out.println(total_notover+"tot not");
									total_outstanding_notover = totalDisbursed - total_notover;
									System.out.println(total_outstanding_notover+"tot out not ");
								}
								//for bar chart: count days detail based on overdue
								if(!(order.getStatus().equalsIgnoreCase("REPAYMENT_COMPLETED"))) {
									//kalo positif dia telat  kalo negatif belom telat 
									diff = Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant());
									if(diff.toDays() >= 1 && diff.toDays() <=2) {
										d1d2+=1;
									}
									else if(diff.toDays() >= 3 && diff.toDays() <=7) {
										d3d7+=1;
									}
									else if(diff.toDays() >= 8 && diff.toDays() <=30) {
										d8d30+=1;
									}
									else if(diff.toDays()>=31 && diff.toDays() <=90) {
										d31d90+=1;
									}
									else {
										d91+=1;
									}	
								}
						 }
					 }
				 }	 
			 }
			 listLiveMetrics.setOrder(count_order);
				listLiveMetrics.setDisburse(totalDisbursed);
				listLiveMetrics.setOutstanding_notover(total_outstanding_notover);
				listLiveMetrics.setOutstanding_over(total_outstanding_overdue);
				listLiveMetrics.setOrder_month(count_this_month);
				listLiveMetrics.setRepaid_month(total_repaid_this_month);
				listLiveMetrics.setActive(count_active);
				listLiveMetrics.setD1d2(d1d2);
				listLiveMetrics.setD3d7(d3d7);
				listLiveMetrics.setD8d30(d8d30);
				listLiveMetrics.setD31d90(d31d90);
				listLiveMetrics.setD91(d91);
				
				response.setResult(listLiveMetrics);
				response.setMessage("OK");
				response.setStatus(200);
		 }
		catch(Error e) {
			 response.setStatus(500);
			 response.setMessage(e.getMessage());
			
		}
		 return response;
	}//retrieve
}