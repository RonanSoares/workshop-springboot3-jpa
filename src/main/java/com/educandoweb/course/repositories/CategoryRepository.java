package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

//Interface Responsável para fazer operações com a entidade Category.
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
