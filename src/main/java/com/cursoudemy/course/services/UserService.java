package com.cursoudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.course.entities.User;
import com.cursoudemy.course.repositories.UserRepository;
import com.cursoudemy.course.services.exceptions.ResourceNotFoundException;

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
		
		//orElseThrow - caso capture um erro ele vai lançar o erro passado por parametro
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		Optional<User> entity = repository.findById(id);
		updateData(entity.get(), obj);
		return repository.save(entity.get());
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
	
}
