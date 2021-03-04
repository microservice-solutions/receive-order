package com.ibm.receive.order.model;

import lombok.Data;

@Data
public class OrderRequest {
	private String productCode;
	private int productQuantity;
}
