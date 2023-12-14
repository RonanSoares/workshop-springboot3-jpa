package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController                       // RecursoWeb implementado por um controlador Rest.
@RequestMapping(value = "/products")     // Nome do recurso
public class ProductResource {
	
	@Autowired	                      // Para que o Spring faça a dependência
	private ProductService service;      // Dependencia para o ProductService
	
	// Método EndPoint para acessar os usuários.
	@GetMapping                                   // Anotação para indicar responde ao metodo get http
	public ResponseEntity<List<Product>> findAll(){  // Tipo específico do Spring para retornar requisições web.
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
}
	
	// Método EndPoint para acessar um usuário pelo Id.
	@GetMapping(value = "/{id}")                                 // Indica que a requisição aceita um Id dentro da url.
	public ResponseEntity<Product> findById(@PathVariable Long id){ //Tem q colocar a anotação para o Spring aceitar o Id que vai chegar na url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
