package com.cursoudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.course.entities.User;
import com.cursoudemy.course.repositories.UserRepository;

//@COMPONENT - Registra a classe como componente do Spring
//@REPOSITORY - Registra um repository
//@SERVICE - Registra um serviço
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();

	}
	
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
}
