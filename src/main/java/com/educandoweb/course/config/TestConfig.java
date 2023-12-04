package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// Classe auxiliar de configuração para o perfil de test
@Configuration     // Anotação para avisar ao Spring que é uma classe especifica de configuração
@Profile("test")   // Para avisar que é uma classe especifica para o perfil de test.
public class TestConfig implements CommandLineRunner { //implem... executa quando o programa for iniciado
	
	//Essa Classe tem uma dependência para o UserRepository que é responsável para povoar o BD	
	@Autowired    // Anotação para que o spring faça a associação entre o userRepository e a classe TestConfig
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuarios no BD		
	}	
}
