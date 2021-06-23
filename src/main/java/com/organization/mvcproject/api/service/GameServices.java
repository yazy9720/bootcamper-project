package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.Game;

public interface GameServices 
{
	List<Game> retrieveAllGames();

	Game saveGame(Game game);
	
}
