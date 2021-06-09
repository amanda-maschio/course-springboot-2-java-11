package com.cursoudemy.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.course.entities.User;

/**
 * Responsável por disponibilizar um recurso web correspondente a entidade User
 * @author Amanda Maschio
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//ResponseEntity é um tipo específico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
