package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController                     // RecursoWeb implementado por um controlador Rest.
@RequestMapping(value = "/users")   // Nome do recurso
public class UserResource {

	@Autowired                      // Para que o Spring faça a dependência
	private UserService service;    // Dependencia para o UserService
	
	// Método EndPoint para acessar os usuários.
	@GetMapping                                    // Anotação para indicar responde ao metodo get http
	public ResponseEntity<List<User>> findAll() {  // Tipo específico do Spring para retornar requisições web.
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Método EndPoint para acessar um usuário pelo Id.
	@GetMapping(value = "/{id}")                                   // Indica que a requisição aceita um Id dentro da url.
	public ResponseEntity<User> findById(@PathVariable Long id) {  //Tem q colocar a anotação para o Spring aceitar o Id que vai chegar na url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Método para inserir um usuário
	@PostMapping                                         // Qdo é inserção usa essa anotação
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);    // Response para retornar o cod 201 no postman
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);                              // Deleta o usuário
		return ResponseEntity.noContent().build();       // Retornar a resposta
	}
	
	@PutMapping(value = "/{id}")                         // Anotação para att do usuário
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
	

