package com.cursoudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.course.entities.Order;
import com.cursoudemy.course.repositories.OrderRepository;

//@COMPONENT - Registra a classe como componente do Spring
//@REPOSITORY - Registra um repository
//@SERVICE - Registra um serviço
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();

	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
