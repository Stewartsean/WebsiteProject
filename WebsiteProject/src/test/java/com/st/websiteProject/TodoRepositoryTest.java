package com.st.websiteProject;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.websiteProject.model.ToDo;
import com.st.websiteProject.repository.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest 
{
	private static ToDo sean;
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Before 
	public void setUp()
	{
		sean = new ToDo("Clean Room", "Pick Upp clothes", 2);
		testEntityManager.persistAndFlush(sean);
	}
	@After
	public void tearDown()
	{
		todoRepository.deleteAll();
	}
	@Test
	public void whenGivenName_thenReturnTodo()
	{
		ToDo found = todoRepository.findByTitle(sean.getTitle());
		assertThat(sean).isEqualToComparingFieldByField(found);
	}
	@Test
	public void whenGivenAllTodos_thenReturnList()
	{
		List<ToDo> found = todoRepository.findAll();
		assertEquals(1, found.size());
	}
}

