package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service                               // Registra a classe como um componente do Spring
public class CategoryService {	
	
	@Autowired                           // Para o Spring fazer injeção de dependência
	private CategoryRepository repository;   // Declara a dependencia com o CategoryRepository
	
	// Método para buscar todos os usuários
	public List<Category> findAll(){
		return repository.findAll();       // Retorn todos os usuários.
	}
	
	// Operação para buscar usuário por Id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);         // Retorna um objeto Optional
		return obj.get();                              // Retorna objeto Category que está no obj
	}
}
