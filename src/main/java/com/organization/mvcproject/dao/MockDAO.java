package com.organization.mvcproject.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.api.dao.GameDao;
@Repository
/*interface DAOInterface
{
	
}*/
public class MockDAO implements GameDao  {
	private static Long gameId = new Long(0);
	
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}
//@Override
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

		if(game.getGamesId() != null) {
		Game gameWasJustFound = gameWillBeFoundById(game.getGamesId());
			if(gameWasJustFound != null)
			{
			   for(int y = 0; y < games.size(); y++)
			   {
				   if (gameWasJustFound.getGamesId().equals(games.get(y).getGamesId()))
				   {
					   games.set(y, gameWasJustFound);
					   return gameWasJustFound;
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
		if (game.getGamesId().equals(id))
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
			   if (id.equals(games.get(p).getGamesId()))
			   {
				   games.remove(games.get(p));
				   return true;
			   }
		   }
	return false;
	}


	/*public List<Game> findGamesByGenere(String Genre) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
 
