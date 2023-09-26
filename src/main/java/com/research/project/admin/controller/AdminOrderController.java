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
	
	
	
	
	@GetMapping("/all")
	public <T> Object all()
	{
		return ResponseEntity.ok().body(orderRepository.findAll());
	}
	
	@GetMapping("/details/{id}")
	public <T> Object findById(@PathVariable("id") Long orderId)
	{
//		return ResponseEntity.ok().body(orderRepository.findById(orderId));
		return ResponseEntity.ok().body(orderRepository.getOrderByIdWithUser(orderId));
	}
	
	
	@PutMapping("/update/order-status")
	public <T> Object all(@RequestBody OrderEntity order)
	{
		if(orderRepository.updateOrderStatus(order.getId(), order.getOrderStatus(),order.getPaymentStatus())>0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
	}
	
	@GetMapping("/{status}")
	public <T> Object getNewOrder(@PathVariable("status") String orderStatus)
	{
		return ResponseEntity.ok().body(orderRepository.findByOrderStatus(orderStatus));
	}
	
	@GetMapping("/payment/{status}")
	public <T> Object getOrderByPaymentStatus(@PathVariable("status") String paymentStatus)
	{
		return ResponseEntity.ok().body(orderRepository.findByPaymentStatus(paymentStatus));
	}

}
