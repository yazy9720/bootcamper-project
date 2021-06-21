package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGL_Task1.model.Game;
@Repository
public class MockDAO {
	private static Long gameId = new Long(0);
	
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	//@Override
	//Read
	public List<Game> retrieveAllGames() {
		return games;
	}

	//@Override
	// update &create
	public  Game saveGame(Game game) {

		if(game.getId() != null) {
		Game gameIsFound = gameWillBeFoundById(game.getId());
			if(gameIsFound != null)
			{
			   for(int y = 0; y < games.size(); y++)
			   {
				   if (gameIsFound.getId() == (games.get(y).getId()))
				   {
					   games.set(y, gameIsFound);
					   return gameIsFound;
				   }
			   }
			}
		}
		  game.setId(++gameId);
	        games.add(game);
	        return game;
	}

	public Game gameWillBeFoundById(Long id) {
		for(Game game: games) 
		{
		if (game.getId().equals(id))
		{
			return game;
		}
	}
		return null;
	}
		
   // delete
	public boolean gameIsDeleted(Long id) 
	{
	
	
	
		for(int p = 0; p < games.size(); p++)
		   {
			   if (id.equals(games.get(p).getId()))
			   {
				   games.remove(games.get(p));
				   return true;
			   }
		   }
	return false;
	}
}


