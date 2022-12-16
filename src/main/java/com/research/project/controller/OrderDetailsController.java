package com.research.project.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.project.entity.AddressEntity;
import com.research.project.entity.OrderDetailsEntity;
import com.research.project.entity.OrderEntity;
import com.research.project.entity.ProductEntity;
import com.research.project.entity.ReviewEntity;
import com.research.project.repository.AddressRepository;
import com.research.project.repository.CartRepository;
import com.research.project.repository.OrderDetailsRepository;
import com.research.project.repository.OrderRepository;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.UserRepository;

@RestController
@RequestMapping("/customer/order")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/all")
	public <T> Object all() {
		return ResponseEntity.ok().body(orderRepository.getUserOrder(this.auth().getId()));
	}
	
	@GetMapping("/view/{id}")
	public <T> Object SingleOrder(@PathVariable(name = "id") Long id) {
		
		return null;
	}
	
	
	@PutMapping("/update/cancel/{id}")
	public <T> Object cancelOrder(@PathVariable(name = "id") Long id) {
		
		if(orderRepository.updateOrderStatus(id, "cancel")>0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
	}
	
	@PostMapping("/add")
	public <T> Object addOrder(@RequestBody List<OrderDetailsEntity> detailsOrders) {
		
		OrderEntity order = new OrderEntity();
		AddressEntity address = new AddressEntity();
		address = addressRepository.findDefaultAddressByUser(this.auth(),true);
		order.setAddress(address);
		order.setUser(this.auth());
		order.setCreatedAt(LocalDate.now().toString());
		order.setPaymentStatus("pending");
		order = orderRepository.save(order);
		
		for(int i=0; i<detailsOrders.size(); i++) {
			detailsOrders.get(i).setOrder(order);
		
			detailsOrders.set(i, orderDetailsRepository.save(detailsOrders.get(i)));
		}
		
		cartRepository.deleteByUser(this.auth());
		
		return ResponseEntity.ok().body(order);
		
	}
	
	@GetMapping("all/payment-complete")
	public <T> Object unreviewedOrder() {
		UserEntity user = this.auth();
		List<OrderEntity> orders = orderRepository.findByUserAndPaymentStatus(user, "completed");
//		List<ProductEntity> products = new ArrayList<ProductEntity>();
//		for(OrderEntity order : orders) {
//			for(OrderDetailsEntity detail : order.getDetails()) {
//				boolean flag = false;
//				for(ReviewEntity review : detail.getProduct().getReview()) {
//					if(review.getUser().getId()== user.getId()) {
//						flag = true;
//						break;
//					}
//				}
//				
//				if(!flag) {
//					products.add(detail.getProduct());
//				}
//			}
//		}
		return ResponseEntity.ok().body(orders);
	}
	
	
	
	
	private  UserEntity auth() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}

}
