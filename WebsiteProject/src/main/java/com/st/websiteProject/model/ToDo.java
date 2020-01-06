package com.st.websiteProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String content;
	private Integer hrToComplete;
	
	public ToDo() {}

	public ToDo(String title, String content, Integer hrToComplete) {
		super();
		this.title = title;
		this.content = content;
		this.hrToComplete = hrToComplete;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getHrToComplete() {
		return hrToComplete;
	}

	public void setHrToComplete(Integer hrToComplete) {
		this.hrToComplete = hrToComplete;
	}

	public Long getId() {
		return id;
	};
	
	
}
