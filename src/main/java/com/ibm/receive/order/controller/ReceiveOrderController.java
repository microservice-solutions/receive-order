package com.ibm.receive.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ReceiveOrderController {
	
	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestParam String transactionId, @RequestParam String productCode, @RequestParam int quantity,
			@AuthenticationPrincipal Jwt idToken) {
		
		String response = String.format("[Transaction ID: %s] Order Received from %s [Product:%s][Quantity:%s]",
				transactionId, idToken.getClaim("email"), productCode, quantity);
		
		return ResponseEntity.ok(response);
	}
}
