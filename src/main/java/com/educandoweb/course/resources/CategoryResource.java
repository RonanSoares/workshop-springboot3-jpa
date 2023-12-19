package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController                           // RecursoWeb implementado por um controlador Rest.
@RequestMapping(value = "/categories")    // Nome do recurso
public class CategoryResource {

	@Autowired                            // Para que o Spring faça a dependência
	private CategoryService service;      // Dependencia para o CategoryService

	// Método EndPoint para acessar as categorias.
	@GetMapping                                         // Anotação para indicar responde ao metodo get http                  
	public ResponseEntity<List<Category>> findAll() {   // Tipo específico do Spring para retornar requisições web.
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Método EndPoint para acessar uma categoria pelo Id.
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {  //Tem q colocar a anotação para o Spring aceitar o Id que vai chegar na url
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
