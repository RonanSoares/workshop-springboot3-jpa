package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController                        // RecursoWeb implementado por um controlador Rest.
@RequestMapping(value = "/orders")     // Nome do recurso
public class OrderResource {
	
	@Autowired	                       // Para que o Spring faça a dependência
	private OrderService service;      // Dependencia para o OrderService
	
	// Método EndPoint para acessar os usuários.
	@GetMapping                                    // Anotação para indicar responde ao metodo get http
	public ResponseEntity<List<Order>> findAll(){  // Tipo específico do Spring para retornar requisições web.
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);     //Retorna resposta com sucesso http e o corpo da resposta u.
} 
	
	// Método EndPoint para acessar um usuário pelo Id.
	@GetMapping(value = "/{id}")                                  // Indica que a requisição aceita um Id dentro da url.
	public ResponseEntity<Order> findById(@PathVariable Long id){ //Tem q colocar a anotação para o Spring aceitar o Id que vai chegar na url
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
