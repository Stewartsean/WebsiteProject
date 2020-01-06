package com.st.websiteProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.st.websiteProject.model.ToDo;
import com.st.websiteProject.service.TodoService;

@Controller
public class TodoController 
{
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("/about")
	public String aboutMe()
	{
		return "about";
	}
	@GetMapping("/todos")
	public String findAll(Model model, ToDo toDo)
	{
		List<ToDo> toDos = todoService.findAll();
		model.addAttribute("todo", toDos);
		return "todos";
	}
	
	@GetMapping("/todo/{id}")
	public String getTodoById(@PathVariable("id") Long id, Model model)
	{
		ToDo todoId = todoService.findToDoById(id);
		model.addAttribute("todo", todoId);
		return "todo";
	}
	@GetMapping("/todo/random")
	public String getRandomtodo(Model model, ToDo toDo)
	{
		toDo = todoService.randomToDo();
		model.addAttribute("randtodo", toDo);
		return "todo";
	}
	@GetMapping("/todo/newtodo")
	public String gettodoForm(ToDo toDo)
	{
		return "newtodo";
	}
	@PostMapping("/todo/newtodo")
	public String createtodo(ToDo toDo, Model model)
	{
		todoService.saveToDo(toDo);
		model.addAttribute("message", "New todo Made");
		return "result";
	}
	@DeleteMapping("/todo/{id}")
	public String deletetodoById(@PathVariable("id") Long id, Model model)
	{
		todoService.deleteById(id);
		model.addAttribute("message", "todo deleted Success");
		return "result";
	}
	@GetMapping("/todo/{id}/update")
	public String updatetodo(@PathVariable("id") Long id, ToDo toDo, Model model)
	{
		ToDo currenttodo = todoService.findToDoById(id);
		model.addAttribute("currenttodo", currenttodo);
		return "updatetodo";
	}
	@PostMapping("/todo/{id}")
	public String updatetodoById(@PathVariable("id") Long id, ToDo toDo, Model model)
	{
		todoService.updateToDo(id, toDo);
		model.addAttribute("message", "todo updated");
		return "result";
	}
}
