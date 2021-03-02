package com.ibm.receive.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.receive.order.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
