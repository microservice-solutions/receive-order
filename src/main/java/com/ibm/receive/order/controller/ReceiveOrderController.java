package com.ibm.receive.order.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.receive.order.model.OrderModel;
import com.ibm.receive.order.model.OrderRequest;
import com.ibm.receive.order.repository.OrderRepository;


@RestController
@RequestMapping
public class ReceiveOrderController {
	
	@Autowired OrderRepository orderRepository;
	
	@PostMapping(path = "/order")
	public ResponseEntity<String> placeOrder(@RequestParam String transactionId, @RequestBody List<OrderRequest> orderRequestList,
			@AuthenticationPrincipal Jwt idToken) {
		
		String response = String.format("[Transaction ID: %s] Order Received from %s ", transactionId, idToken.getClaim("email"));
		
		Iterator<OrderRequest> it = orderRequestList.iterator();
		
		while ( it.hasNext() ) {
			OrderRequest item = it.next();
			
			OrderModel order = new OrderModel();
			order.setProductCode(item.getProductCode());
			order.setQuantity(item.getProductQuantity());
			order.setTransactionId(transactionId);
			order.setUsername(idToken.getClaim("email"));
			
			orderRepository.save(order);
		}
		
		
		
		return ResponseEntity.ok(response);
	}
}
