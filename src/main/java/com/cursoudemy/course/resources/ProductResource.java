package com.cursoudemy.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.course.entities.Product;
import com.cursoudemy.course.services.ProductService;

/**
 * Responsável por disponibilizar um recurso web correspondente a entidade Product
 * @author Amanda Maschio
 *
 */
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	private ProductService service;
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
	
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//Indica que a requisição aceita um ID de parâmetro
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
