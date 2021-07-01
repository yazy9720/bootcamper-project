package com.organization.mvcproject.api.dao;
import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.Game;


public interface GameDao 
{
	 List<Game> retrieveAllGames();
	 Game saveGame(Game game);
	 Game gameWillBeFoundById(Long id);
	 boolean gameIsDeleted(Long id);
	 List<Game> findGameByGenre(String genre);

	
}
