package com.qa.springproj.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springproj.domain.ToDo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:todo-schema.sql",
		"classpath:todo-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
 @ActiveProfiles("test") 
public class ToDoTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper; // converts requests to json

	private final ToDo testTodo = new ToDo("Run a test", 2);

	private final ToDo testTodoId = new ToDo(1, "Run a test", 2);

	@Test
	@Order(1)
	void testPost() throws Exception {

		ToDo todo = new ToDo("Run a test", 2);

		String ToDoAsJSON = this.mapper.writeValueAsString(todo);

		RequestBuilder mockRequest = post("/todo").contentType(MediaType.APPLICATION_JSON).content(ToDoAsJSON);

		ToDo savedToDo = new ToDo(2, "Run a test", 2);

		String savedToDoAsJSON = this.mapper.writeValueAsString(savedToDo);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedToDoAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	public void testReadOne() throws Exception {
		this.mock.perform(get("/todo/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testTodoId)));
	}

	@Test
	public void testReadAll() throws Exception {
		List<ToDo> todos = new ArrayList<>();
		todos.add(testTodo);

		String result = this.mapper.writeValueAsString(todos);

		RequestBuilder mockRequest = get("/todo").contentType(MediaType.APPLICATION_JSON).content(result);

		List<ToDo> TodoId = new ArrayList<>();
		TodoId.add(testTodoId);

		String savedResult = this.mapper.writeValueAsString(TodoId);

		ResultMatcher matchBody = content().json(savedResult);

		this.mock.perform(mockRequest).andExpect(status().isOk()).andExpect(matchBody);
	}

	@Test
	@Order(2)

	public void testUpdate() throws Exception {

		ToDo newToDo = new ToDo("Run Tests", 2);
		ToDo ToDoInDb = new ToDo(1, "Run Tests", 2);
		String newToDoAsJson = this.mapper.writeValueAsString(newToDo);
		String newToDoAsJsonInDb = this.mapper.writeValueAsString(ToDoInDb);

		RequestBuilder mockRequest = put("/todo/1").contentType(MediaType.APPLICATION_JSON).content(newToDoAsJson);

		ResultMatcher matchBody = content().json(newToDoAsJsonInDb);

		this.mock.perform(mockRequest).andExpect(status().isAccepted()).andExpect(matchBody);

	
	}

	@Test
	public void testDelete() throws Exception {
		this.mock.perform(delete("/todo/1")).andExpect(status().isOk());

	}

}