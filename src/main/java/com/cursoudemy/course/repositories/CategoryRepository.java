package com.cursoudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	//Não necessita criar implementação dessa interface
	//SpringDataJPA já tem uma implementação padrão para essa interface
}
