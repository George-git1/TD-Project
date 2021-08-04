package com.qa.springproj.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springproj.domain.ToDo;
import com.qa.springproj.repo.ToDoRepository;
import com.qa.springproj.service.ToDoService;

public class ToDoUnitTest {

	
	
	@MockBean
	private ToDoRepository repo;
	
	@Autowired
	private ToDoService service;
	
	
	@Test
	void testCreateUnit() {
		
		ToDo runtest = new ToDo ("Run a test", 2);
		ToDo runtestWithId = new ToDo (1, "Run a test", 2);
		
		Mockito.when(this.repo.saveAndFlush(runtest)).thenReturn(runtestWithId);
		
		assertThat(this.service.createToDo(runtest)).isEqualTo(runtestWithId);
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(runtest);
	}
}
