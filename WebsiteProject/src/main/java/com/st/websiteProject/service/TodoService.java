package com.st.websiteProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.websiteProject.model.ToDo;
import com.st.websiteProject.repository.TodoRepository;

@Service
public class TodoService implements TodoServiceInt
{
	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public List<ToDo> findAll()
	{
		return todoRepository.findAll();
	}
	@Override
	public ToDo findByTitle(String title)
	{
		return todoRepository.findByTitle(title);
	}
	@Override
	public ToDo randomToDo()
	{
		List<ToDo> toDo = new ArrayList<ToDo>();
		toDo.addAll(todoRepository.findAll());
		ToDo random = toDo.get(new Random().nextInt(toDo.size()));
		return random;
	}
	@Override
	public void saveToDo(ToDo toDo)
	{
		todoRepository.save(toDo);
	}
	@Override
	public void deleteAll()
	{
		todoRepository.deleteAll();
	}

	@Override
	public void deleteById(Long id)
	{
		todoRepository.deleteById(id);
	}
	@Override
	public void updateToDo(Long id, ToDo toDo)
	{
		ToDo userToReplace = todoRepository.findToDoById(id);
		String newTitle = toDo.getTitle();
		String newContent = toDo.getContent();
		Integer hrToComplete = toDo.getHrToComplete();
		if(newTitle != null) userToReplace.setTitle(newTitle);;
		if(newContent != null) userToReplace.setContent(newContent);
		if(hrToComplete != null) userToReplace.setHrToComplete(hrToComplete);
		todoRepository.save(userToReplace);
	}
	@Override
	public ToDo findToDoById(Long id) 
	{
		return todoRepository.findToDoById(id);
	}
		
}
