package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service                                  // Registra a classe como um componente do Spring
public class OrderService {

	@Autowired                            // Para o Spring fazer injeção de dependência
	private OrderRepository repository;   // Declara a dependencia com o OrderRepository
	
	// Método para buscar todos os usuários
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	// Método para buscar usuário por id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);  // Retorna um objeto Optional
		return obj.get();                               // Retorna objeto Order que está no obj              
	}
}
