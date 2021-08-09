package com.qa.springproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springproj.domain.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
