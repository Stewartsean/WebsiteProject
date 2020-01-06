package com.st.websiteProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.websiteProject.model.ToDo;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long>
{
	public List<ToDo> findAll();
	public ToDo findToDoById(Long id);
	public ToDo findByTitle(String title);
	public ToDo findByContent(String content);

}
