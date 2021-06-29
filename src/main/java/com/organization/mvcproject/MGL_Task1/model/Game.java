package com.organization.mvcproject.MGL_Task1.model;

import org.springframework.stereotype.Component;
import com.organization.mvcproject.api.model.Games;

@Component
public class Game implements Games {

	private Long id;
	private String name;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
