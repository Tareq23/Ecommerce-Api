package com.research.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.OrderEntity;
import com.research.project.repository.OrderRepository;

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PutMapping("/update/order-status")
	public <T> Object all(@RequestBody OrderEntity order)
	{
		if(orderRepository.updateOrderStatus(order.getId(), order.getOrderStatus())>0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
	}

}
