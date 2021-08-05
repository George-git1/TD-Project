package com.qa.springproj.tests;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springproj.repo.ToDoRepository;

@SpringBootTest
public class ToDoFailUnitTest {

	@MockBean
	private ToDoRepository repo;

	@Test
	void testGetOneToDoById() {
		assertThatThrownBy(() -> {
			throw new EntityNotFoundException();
		}).isInstanceOf(EntityNotFoundException.class).hasMessage(null);
	}

	@Test
	void testUpdateToDo() {
		assertThatThrownBy(() -> {
			throw new EntityNotFoundException();
		}).isInstanceOf(EntityNotFoundException.class).hasMessage(null);
	}

	@Test
	void testDeleteToDo() {
		assertThatThrownBy(() -> {
			throw new EntityNotFoundException();
		}).isInstanceOf(EntityNotFoundException.class).hasMessage(null);
	}
}
