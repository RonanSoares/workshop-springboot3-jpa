package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController                       // RecursoWeb implementado por um controlador Rest.
@RequestMapping(value = "/users")     // Nome do recurso
public class UserResource {
	
	                     // Método EndPoint para acessar os usuários.
	@GetMapping                               // Anotação para indicar responde ao metodo get http
	public ResponseEntity<User> findAll(){    // Tipo específico do Spring para retornar requisições web.
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);   //Retorna resposta com sucesso http e o corpo da resposta u.
}
}
