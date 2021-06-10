package com.cursoudemy.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.course.entities.User;
import com.cursoudemy.course.services.UserService;

/**
 * Responsável por disponibilizar um recurso web correspondente a entidade User
 * @author Amanda Maschio
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//AUTOWIRED - o framework fica responsável pela injeção de dependencia ao incluir essa denotação
	@Autowired
	private UserService service;
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
	
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	//Indica que a requisição aceita um ID de parâmetro
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
