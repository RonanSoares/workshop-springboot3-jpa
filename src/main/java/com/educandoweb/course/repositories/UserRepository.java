package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

//Interface Responsável para fazer operações com a entidade User.
public interface UserRepository extends JpaRepository<User, Long> {

}
