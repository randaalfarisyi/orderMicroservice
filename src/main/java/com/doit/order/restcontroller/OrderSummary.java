package com.doit.order.restcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.doit.order.model.ReportModel;
import com.doit.order.rest.Amount;
import com.doit.order.rest.BaseResponse;
import com.doit.order.service.OrderService;
import com.doit.order.service.OverdueBillService;
import com.doit.order.service.ProductTypeService;
import com.doit.order.service.ReportService;
import com.doit.order.wrapper.LiveMetricsWrapper;
import com.doit.order.wrapper.ReportWrapper;

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
public class OrderSummary {
	@Autowired 
	ProductTypeService productTypeService;
	
	@Autowired 
	OrderService orderService;
	
	@Autowired 
	ReportService reportService;
	
	@GetMapping(value="/view")
	public Object retrieveAmount(){
		BaseResponse<Amount> response = new BaseResponse<Amount>();
		Amount listOfAmount = new Amount(null, null);
		List<ProductTypeModel> p = productTypeService.getAllProductType();
		List<ReportModel> rep = reportService.getAllReport();
		List<String> listOfPeriod = new ArrayList<String>();
		Map<Integer,String> months = new HashMap<Integer, String>();
		months.put(1, "January");months.put(2, "February");months.put(3,"March");months.put (4, "April");
		months.put(5, "May");months.put(6, "June");months.put (7, "July");months.put(8, "August");
		months.put(9, "September");months.put(10, "October");months.put(11, "November");months.put(12, "December");
		LocalDateTime now = LocalDateTime.now();
		int month = now.getMonthValue();
		int year = now.getYear();
		String datenow = months.get(month) +" "+Integer.valueOf(year);
		
		
		//List<Long> amount = new ArrayList<>();
		//for(ProductTypeModel prod : p) {
		//	amount.add(prod.getBorrowingAmount());
		//}
		
		 /**
		  * to do: get all list of period without current month
		  */
		for(ReportModel r: rep) {
			if(r.getPeriod().equalsIgnoreCase(datenow)) {
				reportService.deleteByMonth(datenow);
			}
			else {
				listOfPeriod.add(r.getPeriod());
			}
		}
		
		listOfAmount.setListOfOrder(p);
		listOfAmount.setListOfPeriod(listOfPeriod);
		response.setResult(listOfAmount);
		response.setMessage("OK");
		response.setStatus(200);
		return response;
	}
//	@GetMapping(value="/report/{period}/{name}/{amountApply}")
//	public Object retrieveReport(@PathVariable(value="period") String period,
//			@PathVariable(value="name") String name,
//			@PathVariable(value="amountApply") Long amountApply) {
//		BaseResponse<ReportWrapper> response = new BaseResponse<ReportWrapper>();
//		ReportWrapper reportWrap = new ReportWrapper(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		List<ReportModel> rep = reportService.getAllReport();
//		//all udah per bulan 2020 
//		ReportModel all = reportService.getReportByPeriod(period).get();
//		List<OrderModel> listOfOrder = all.getOrderList();
//		ProductTypeModel type = productTypeService.getProductTypeByNameAndAmount(name, amountApply).get();
//		System.out.println(type.getUuid());
//		List<String> listOfPeriod = new ArrayList<String>();
//		
//		try {
//			Map<Integer,String> months = new HashMap<Integer, String>();
//			months.put(1, "January");months.put(2, "February");months.put(3,"March");months.put (4, "April");
//			months.put(5, "May");months.put(6, "June");months.put (7, "July");months.put(8, "August");
//			months.put(9, "September");months.put(10, "October");months.put(11, "November");months.put(12, "December");
//			LocalDateTime now = LocalDateTime.now();
//			int month = now.getMonthValue();
//			int year = now.getYear();
//			String datenow = months.get(month) +" "+Integer.valueOf(year);
//			
//			long count_order_accepted=0;
//			long count_all_order =0;
//			long count_order_rejected=0;
//			long total_disburse_out =0;
//			double service_fee_rate = 0;double interest_rate = 0;double penalty_rate=0;
//			long overdue_rate=0;
//			long total_outstanding_amount=0;long totalAmount=0;long totalDisburse=0;
//			long service_fee=0; long total_over =0;long total_notover=0;
//			long total_outstanding_notover=0; long total_outstanding_overdue=0;
//			String status1 = "USER_DATA_SUBMITED";
//			 String status2 = "USER_DATA_COMPLETED";
//			 String status3a = "RISK_COMPLETED";
//			 String status3b = "MANUAL_VERIF_COMPLETED";
//			 String status4 = "FUNDING_COMPLETED";
//			 String status5 = "DIGISIGN_COMPLETED";
//			 String status6 = "FINANCE_COMPLETED";
//			 String status7a = "DISBURSEMENT_COMPLETED";
//			 String status7b ="CUSTOMER_REPAYMENT";
//			 String status7c= "REPAYMENT_COMPLETED";
//		
//			 /**
//			  * to do: get all list of period without current month
//			  */
//			for(ReportModel r: rep) {
//				if(datenow.equalsIgnoreCase(period)) {
//					reportService.deleteByMonth(period);
//				}
//				else {
//					listOfPeriod.add(r.getPeriod());
//				}
//			}
//					/**
//					 * to do: get all report's  content
//					 */
//					for(OrderModel order: listOfOrder) {
//						if(order.getProductType().getUuid().equalsIgnoreCase(type.getUuid())) {
//							count_all_order +=1;
//							//System.out.println(order.getId()+" id");
//							service_fee_rate = order.getServiceFeeRate();
//							//System.out.println(order.getAmountApply()+" apply");
//							interest_rate = order.getInterestRate();
//							//System.out.println(interest_rate);
//							overdue_rate =order.getOverdueRate();
//						//	System.out.println(overdue_rate+" overdue rate");
//							penalty_rate = order.getPenaltyRate();
//						//	System.out.println(penalty_rate+" penalty rate");
//						//	System.out.println(count_all_order+"all order");
//							/**
//							 * to do: get detail order
//							 */
//							if(!(order.getStatus().equalsIgnoreCase(status1))) {
//								count_order_accepted += 1;
//								//System.out.println(count_order_accepted+"accepted");
//								count_order_rejected = count_all_order - count_order_accepted;
//								//System.out.println(count_order_rejected +"rejected");	
//							}
//							/**
//							 * to do : sum total disbursed
//							 */
//								if(order.getStatus().equalsIgnoreCase(status7a)|| order.getStatus().equalsIgnoreCase(status7b)
//										|| order.getStatus().equalsIgnoreCase(status7c)) {
//									totalAmount+= order.getAmountApply();
//									totalDisburse += order.getAmountDisbursed();
//									service_fee = totalAmount - totalDisburse;
//									//System.out.println(service_fee+" service fee");
//									//System.out.println(totalDisburse+"disburse");
//									//System.out.println(totalAmount +"apply");	
//									}
//								/**
//								 * to do: sum outstanding overdue and outstanding not overdue
//								 */
//								if(!(order.getStatus().equalsIgnoreCase(status7c))) {
//									if(((Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant())).toDays() >=1)) {
//										total_over += order.getRepayAmount();
//										total_disburse_out+= order.getAmountDisbursed();
//										System.out.println(total_over+ "totalover");
//										System.out.println(total_disburse_out+"disburse");
//										total_outstanding_overdue = Math.abs(total_disburse_out - total_over);
//										System.out.println(total_outstanding_overdue+"tot out over");
//									}else { // not overdue
//										total_notover += order.getRepayAmount();
//										System.out.println(total_notover+"tot not");
//										total_disburse_out+= order.getAmountDisbursed();
//										total_outstanding_notover = Math.abs(total_disburse_out - total_notover);
//										System.out.println(total_outstanding_notover+"tot out not ");
//									}
//									total_outstanding_amount= total_outstanding_overdue + total_outstanding_notover;
//									System.out.println(total_outstanding_amount+"outs amount");
//								}	
//						}
//					}
//				//}
//			//}
//					reportWrap.setTotal_amount(totalAmount);
//					reportWrap.setPeriod(period);
//					reportWrap.setInterest_rate(interest_rate);
//					reportWrap.setListOfPeriod(listOfPeriod);
//					reportWrap.setOrder_accepted(count_order_accepted);
//					reportWrap.setOrder_rejected(count_order_rejected);
//					reportWrap.setOutstanding_notover_amount(total_outstanding_notover);
//					reportWrap.setOutstanding_overdue_amount(total_outstanding_overdue);
//					reportWrap.setOverdue_fee(overdue_rate);
//					reportWrap.setPenality_rate(penalty_rate);
//					reportWrap.setService_fee(service_fee);
//					reportWrap.setService_fee_rate(service_fee_rate);
//					reportWrap.setTotal_disburse(totalDisburse);
//					reportWrap.setTotal_outstanding_amount(total_outstanding_amount);
//					
//					response.setMessage("OK");
//					response.setStatus(200);
//					response.setResult(reportWrap);
//						
//		}//try
//		catch(Error e) {
//			 response.setStatus(500);
//			 response.setMessage(e.getMessage());
//			
//		}//catch
//		return response;
//	}//retrive 
	
	@GetMapping(value="/view/{name}/{amountApply}")
	public Object retrieveMetrics(@PathVariable(value="name") String name,
			@PathVariable(value="amountApply") Long amountApply) throws ParseException{
		BaseResponse<LiveMetricsWrapper> response = new BaseResponse<LiveMetricsWrapper>();
		 LiveMetricsWrapper listLiveMetrics = new LiveMetricsWrapper(null, null, null, null, 
				 null, null,null, null, null, null, null, null) ;
		 ProductTypeModel all = productTypeService.getProductTypeByNameAndAmount(name, amountApply).get();
		 List<ProductTypeModel> p = productTypeService.getAllProductType();
		 List<OrderModel> listOfOrder= all.getOrderList();
		
		 try {
			 
			 /**
			  * jumlah order = total submitted (1)
			  * order disetujui = status 2 sampe 6 
			  * order didanai = status 7 (disburse)
			  */
			 String status1 = "USER_DATA_SUBMITED";
			 String status2 = "USER_DATA_COMPLETED";
			 String status3a = "RISK_COMPLETED";
			 String status3b = "MANUAL_VERIF_COMPLETED";
			 String status4 = "FUNDING_COMPLETED";
			 String status5 = "DIGISIGN_COMPLETED";
			 String status6 = "FINANCE_COMPLETED";
			 String status7a = "DISBURSEMENT_COMPLETED";
			 String status7b ="CUSTOMER_REPAYMENT";
			 String status7c= "REPAYMENT_COMPLETED";
			 
			 long count_order_disburse=0;
			 long count_all_order =0;
			 long count_order_accepted=0;
			 long count_this_month=0;
			 long count_active = 0;
			 long totalDisburse =0;
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
			LocalDateTime ago = now.minusDays( 90 ) ;
		//	System.out.println(now);
		//	System.out.println(ago); 
			Date date = Date.from( ago.atZone( ZoneId.systemDefault()).toInstant());
			System.out.println(date);
			Date datenow = Date.from( now.atZone( ZoneId.systemDefault()).toInstant());
			System.out.println(datenow);
			
			/**
			 * to do : count all orders
			 */
			for(OrderModel order :listOfOrder) {
				if(order.getCreatedTime().after(date) && order.getCreatedTime().before(datenow)) {
					count_all_order +=1;
					System.out.println(count_all_order+"order");
					System.out.println(order.getCreatedTime());
					
					
					
					/**
					 * to do : count order accepted
					 */
					if(!(order.getStatus().equalsIgnoreCase(status1))){
						count_order_accepted +=1;
						System.out.println(count_order_accepted +"accept");
					}
			
					/**
					 * to do : sum total disbursed
					 */
						if(order.getStatus().equalsIgnoreCase(status7a)|| order.getStatus().equalsIgnoreCase(status7b)
								|| order.getStatus().equalsIgnoreCase(status7c)) {
							totalAmount+= order.getAmountApply();
							totalDisburse += order.getAmountDisbursed();
							System.out.println(totalDisburse+"disburse");
							System.out.println(totalAmount +"apply");
							
							/**
							 * to do : count order disburse
							 */
							count_order_disburse +=1;
							

							//for bar chart: count days detail based on overdue
							if(!(order.getStatus().equalsIgnoreCase(status7c))) {
								//kalo positif dia telat  kalo negatif belom telat 
								diff = Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant());
								if(diff.toDays() >= 1 && diff.toDays() <=2) {
									d1d2+=1;
									System.out.println(d1d2+"d1");
								}
								else if(diff.toDays() >= 3 && diff.toDays() <=7) {
									d3d7+=1;
									System.out.println(d3d7+"d3");
								}
								else if(diff.toDays() >= 8 && diff.toDays() <=30) {
									d8d30+=1;
									System.out.println(d8d30+"d8");
								}
								else if(diff.toDays()>=31 && diff.toDays() <=90) {
									d31d90+=1;
									System.out.println(d31d90+"d31");
								}
								else {
									d91+=1;
									System.out.println(d91+"91");
								}	
								
								
								/**
								 * to do: sum outstanding overdue and outstanding not overdue
								 */
								if(((Duration.between(order.getDueDate().toInstant(), now.atZone(ZoneId.systemDefault()).toInstant())).toDays() >=1)) {
									total_over += order.getRepayAmount(); 
									System.out.println(total_over+ "totalover");
									total_outstanding_overdue = Math.abs(totalDisburse - total_over);
									System.out.println(total_outstanding_overdue+"tot out over");
								}else { // not overdue
									total_notover += order.getRepayAmount();
									System.out.println(total_notover+"tot not");
									total_outstanding_notover = Math.abs(totalDisburse - total_notover);
									System.out.println(total_outstanding_notover+"tot out not ");
								}
								
								
							}

						}
				}
			}

				listLiveMetrics.setD1d2(d1d2);
				listLiveMetrics.setD3d7(d3d7);
				listLiveMetrics.setD8d30(d8d30);
				listLiveMetrics.setD31d90(d31d90);
				listLiveMetrics.setD91(d91);
				listLiveMetrics.setAmount_apply(totalAmount);
				listLiveMetrics.setOrder_accepted(count_order_accepted);
				listLiveMetrics.setTotal_order(count_all_order);
				listLiveMetrics.setTotal_disburse(totalDisburse);
				listLiveMetrics.setOutstanding_notover(total_outstanding_notover);
				listLiveMetrics.setOutstanding_over(total_outstanding_overdue);
				listLiveMetrics.setOrder_disburse(count_order_disburse);
				response.setMessage("OK");
				response.setStatus(200);
				response.setResult(listLiveMetrics);
		 }
		catch(Error e) {
			 response.setStatus(500);
			 response.setMessage(e.getMessage());
			
		}
		 return response;
	}//retrieve
	
	
	
}


