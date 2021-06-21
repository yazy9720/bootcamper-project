package com.organization.mvcproject.MGL_Task1.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.dao.MockDAO;

@Service("javaGameService")
public class Game_Service_Impl implements Game_Service 
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
	public boolean gameWillBeDeleted(Long id)
	{
		return mockDao.gameIsDeleted(id);
	
}
}