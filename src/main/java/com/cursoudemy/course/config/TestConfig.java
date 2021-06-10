package com.cursoudemy.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoudemy.course.entities.Category;
import com.cursoudemy.course.entities.Order;
import com.cursoudemy.course.entities.User;
import com.cursoudemy.course.entities.enums.OrderStatus;
import com.cursoudemy.course.repositories.CategoryRepository;
import com.cursoudemy.course.repositories.OrderRepository;
import com.cursoudemy.course.repositories.UserRepository;

/**
 * Classe auxiliar que fará algumas configurações na aplicação
 * Classe de configuração específica para o perfil de testes
 * @author Amanda Maschio
 *
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//Resolve a dependencia e associa uma instancia de UserRepository
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * O que for inserido neste método vai ser executado quando a aplicação for iniciada 
	 */
	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	
}
