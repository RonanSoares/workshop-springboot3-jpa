package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

   // Interface Responsável para fazer operações com a entidade User.
public interface OrderRepository extends JpaRepository<Order, Long>{

}
