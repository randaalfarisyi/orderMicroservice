package com.doit.order.service;

public enum OrderStatus {
	USER_DATA_SUBMITTED ("USER_DATA_SUBMITTED", "Data Peminjam telah diterima"),
	USER_DATA_COMPLETED ("USER_DATA_COMPLETED", "Data Peminjam telah lengkap");
	
	private String statusCode;
	private String statusName;
	
	private OrderStatus(String statusCode, String statusName) {
		this.statusCode = statusCode;
		this.statusName = statusName;
	}
	
	public static String fromStatusCode(String code) {
		if (code == null) {
			return null;
		}
		
		for (OrderStatus statusCode : OrderStatus.values()) {
			if (statusCode.getStatusCode().equalsIgnoreCase(code)) {
				return statusCode.getStatusName();
			}
		}
		
		return null;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	
	
}
