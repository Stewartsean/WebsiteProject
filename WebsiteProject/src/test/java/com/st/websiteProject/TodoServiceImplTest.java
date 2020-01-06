package com.st.websiteProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.websiteProject.model.ToDo;
import com.st.websiteProject.repository.TodoRepository;
import com.st.websiteProject.service.TodoService;
import com.st.websiteProject.service.TodoServiceInt;

@RunWith(SpringRunner.class)
public class TodoServiceImplTest 
{

	@TestConfiguration
	static class ServiceConfiguration
	{
		@Bean
		public TodoServiceInt todoService()
		{
			return new TodoService();
		}
	}
	@Autowired
	TodoServiceInt todoServiceImpl;
	
	@MockBean
	TodoRepository todoRepository;
	
	@Before
	public void setUp()
	{
		ToDo sean = new ToDo("Clean bike", "Washup and lube chain", 2);
		Mockito.when(todoRepository.findByTitle(sean.getTitle())).thenReturn(sean);
	}
	
	@Test
	public void whenGivenTitleName_thenReturnMatchingTitle()
	{
		String name = "Sean";
		ToDo sean = todoServiceImpl.findByTitle(name);
		assertEquals(name, sean.getTitle());
	}
	
	@Test
	public void whenGivenUser_thenDeleteUser()
	{
		ToDo name = new ToDo("hehe", "haha", 21);
		todoRepository.deleteById(name.getId());
		assertNull(name);
	}
}
