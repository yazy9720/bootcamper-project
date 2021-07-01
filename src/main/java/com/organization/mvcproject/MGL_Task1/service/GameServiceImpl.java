package com.organization.mvcproject.MGL_Task1.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.MockDAO;

@Service("javaGameService")
public class GameServiceImpl implements GameService 
{
	@Autowired
	private MockDAO mockDao;
     
	@Override
	public List<Game> retrieveAllGames() {

		
		return mockDao.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockDao.saveGame(game) ;
	}
	public Game findGameById(Long id)
	{

	return mockDao.gameWillBeFoundById(id);

}
	@Override
	public boolean gameWillBeDeleted(Long id)
	{
		return mockDao.gameIsDeleted(id);
		
	
}
	

	@Override
	public List<Game> findGameByGenre(String genre) {
		
		return mockDao.findGameByGenre(genre);
	}

}