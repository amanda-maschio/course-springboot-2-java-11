package com.cursoudemy.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoudemy.course.entities.User;
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

	/**
	 * O que for inserido neste método vai ser executado quando a aplicação for iniciada 
	 */
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
}
