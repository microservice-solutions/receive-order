package com.ibm.receive.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ReceiveOrderController {
	
	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestParam String productCode, @RequestParam int quantity,
			@AuthenticationPrincipal Jwt accessToken) {
		
		String response = String.format("Order Received [Product:%s][Quantity:%s]", productCode, quantity);
		
		return ResponseEntity.ok(response);
	}
}
