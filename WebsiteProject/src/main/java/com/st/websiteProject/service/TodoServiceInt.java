package com.st.websiteProject.service;

import java.util.List;

import com.st.websiteProject.model.ToDo;

public interface TodoServiceInt 
{
	public ToDo findByTitle(String title);
	public ToDo randomToDo();
	public List<ToDo> findAll();
	public void saveToDo(ToDo toDo);
	public void deleteAll();
	public void deleteById(Long id);
	public void updateToDo(Long id, ToDo toDo);
	public ToDo findToDoById(Long id);
}
