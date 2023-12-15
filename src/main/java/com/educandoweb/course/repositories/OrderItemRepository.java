package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

   // Interface Responsável para fazer operações com a entidade User.
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
