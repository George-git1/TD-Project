package com.qa.springproj.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springproj.domain.ToDo;
import com.qa.springproj.repo.ToDoRepository;

@Service
public class ToDoService {

	private ToDoRepository todoRepository;

	@Autowired
	public ToDoService(ToDoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<ToDo> getToDos() {
		List<ToDo> todosInDb = todoRepository.findAll();

		return todosInDb;
	}

	public ToDo getToDoById(int id) {
		
			Optional<ToDo> aInOpt = todoRepository.findById(id);
			return aInOpt.orElseThrow(() -> new EntityNotFoundException());

	}


	public ToDo updateToDo(int id, ToDo todo) {
		if (!todoRepository.existsById(id))
			throw new EntityNotFoundException();
		ToDo todosInDb = todoRepository.getById(id);

		todosInDb.setName(todo.getName());
		

		ToDo updatedToDo = todoRepository.save(todosInDb);
		return updatedToDo;
	}

	public ToDo createToDo(ToDo todo) {
		ToDo savedToDo = this.todoRepository.save(todo);
		return savedToDo;
	}

	public void deleteToDo(int id) {
		if (!todoRepository.existsById(id))
			throw new EntityNotFoundException();
		todoRepository.deleteById(id);

	}

	
}
