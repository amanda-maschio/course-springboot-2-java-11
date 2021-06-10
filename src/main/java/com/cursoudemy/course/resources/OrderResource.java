package com.cursoudemy.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.course.entities.Order;
import com.cursoudemy.course.services.OrderService;

/**
 * Responsável por disponibilizar um recurso web correspondente a entidade Order
 * @author Amanda Maschio
 *
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	private OrderService service;
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
	
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//Indica que a requisição aceita um ID de parâmetro
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
