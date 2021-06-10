package com.cursoudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.course.entities.Category;
import com.cursoudemy.course.repositories.CategoryRepository;

//@COMPONENT - Registra a classe como componente do Spring
//@REPOSITORY - Registra um repository
//@SERVICE - Registra um serviço
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();

	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
