package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service  						// Registra a classe como um componente do Spring
public class ProductService {

	@Autowired                             // Para o Spring fazer injeção de dependência
	private ProductRepository repository;  // Declara a dependencia com o ProductRepository

	// Método para buscar todos os produtos
	public List<Product> findAll() {
		return repository.findAll();  // Retorna todos os produtos
	}

	// Operação para buscar usuário por Id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);  // Retorna um objeto Optional
		return obj.get();								  // Retorna objeto Product que está no obj
	}
}
