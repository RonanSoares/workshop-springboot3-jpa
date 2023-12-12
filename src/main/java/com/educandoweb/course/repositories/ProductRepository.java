package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

   // Interface Responsável para fazer operações com a entidade Product.
public interface ProductRepository extends JpaRepository<Product, Long>{

}
