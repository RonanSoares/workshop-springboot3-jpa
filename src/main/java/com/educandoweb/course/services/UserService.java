package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service                                // Registra a classe como um componente do Spring
public class UserService {

	@Autowired                          // Para o Spring fazer injeção de dependência
	private UserRepository repository;  // Declara a dependencia com o UserRepository

	public List<User> findAll() {       // Método para buscar todos os usuários
		return repository.findAll();    // Retorna todos os usuários.
	}
	
	// Operação para buscar usuário por Id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);                    // Retorna um objeto Optional
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Retorna objeto User que está no obj
	}
	
	public User insert(User obj) {                 // Operação para inserir um usuário
		return repository.save(obj);			   // Salva o usuário no BD
	}
	
	// Operação para deletar um usuário
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Método para atualizar o usuário
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	// Método para att o usuário. Não atualiza nem o id nem a senha.
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
