package com.cursoudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoudemy.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//Não necessita criar implementação dessa interface
	//SpringDataJPA já tem uma implementação padrão para essa interface
}
