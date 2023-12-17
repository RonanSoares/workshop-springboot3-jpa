package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service                               // Registra a classe como um componente do Spring
public class UserService {	
	
	@Autowired                           // Para o Spring fazer injeção de dependência
	private UserRepository repository;   // Declara a dependencia com o UserRepository
	
	// Método para buscar todos os usuários
	public List<User> findAll(){
		return repository.findAll();       // Retorn todos os usuários.
	}
	
	// Operação para buscar usuário por Id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);         // Retorna um objeto Optional
		return obj.get();                              // Retorna objeto User que está no obj
	}
	
	// Operação para inserir um usuário
	public User insert(User obj) {
		return repository.save(obj);         // Para salvar o usuário no BD
	}
	
	// Operação para deletar um usuário
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
