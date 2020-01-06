package com.st.websiteProject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.st.websiteProject.model.ToDo;
import com.st.websiteProject.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
	(
		webEnvironment = WebEnvironment.MOCK, 
		classes = WebsiteProjectApplication.class
	)
@AutoConfigureMockMvc
@TestPropertySource
	(
			locations = "classpath:application-integrationtest.properties"
	)
public class TodoApplicationIntegrationTest {

	private static ToDo sean;
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private MockMvc mvc;
	
	@Before
	public void setUp()
	{
		sean = new ToDo("Shave", "Shave beard for interview", 1);
		todoService.saveToDo(sean);
	}
	
//	@After
//	public void tearDown()
//	{
//		userService.deleteAll();
//	}
	
	@Test
	public void getIndex_returnsHtmlAndStatus200Status() throws Exception
	{
		mvc.perform(get("/")
				.contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
	
	@Test
	public void giveTod_getAllTodos_returnsJsonAllTodos() throws Exception
	{
		mvc.perform
		(
			get("/todos")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].title", is("Shave"))
		);
	}
}
