package com.qa.springproj.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springproj.domain.ToDo;
import com.qa.springproj.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

	private ToDoService todoService;

	@Autowired
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	 public ResponseEntity<List<ToDo>> getToDos() { List<ToDo> data =
	 this.todoService.getToDos();
	  
	  return new ResponseEntity<List<ToDo>>(data, HttpStatus.OK);
	
	}

	@GetMapping("/{id}")
	public ResponseEntity<ToDo> getToDoById(@PathVariable("id") int id) {
		ToDo data = this.todoService.getToDoById(id);

		return new ResponseEntity<ToDo>(data, HttpStatus.OK);

	}

	

	@PutMapping("/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable("id") int id, @Valid @RequestBody ToDo todo) {
		ToDo data = this.todoService.updateToDo(id, todo);

		return new ResponseEntity<ToDo>(data, HttpStatus.ACCEPTED);

	}

	@PostMapping
	public ResponseEntity<ToDo> createToDo(@Valid @RequestBody ToDo todo) {
		ToDo data = this.todoService.createToDo(todo);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("localhost:1999/" + data.getId()));
		headers.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<ToDo>(data, headers, HttpStatus.CREATED);
		
	} 

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteToDo(@PathVariable("id") int id) {
		this.todoService.deleteToDo(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}