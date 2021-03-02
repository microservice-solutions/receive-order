package com.ibm.receive.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQUENCE", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TRANSACTION_ID", unique = true)
	private String transactionId;
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "USERNAME")
	private String username;
}
