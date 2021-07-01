package com.organization.mvcproject.MGL_Task1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.MGL_Task1.model.Review;
import com.organization.mvcproject.api.service.GameService;


@Controller
public class MGL_Task1_Controller {

	//private static final int ResponseEntity = 0;
	@Autowired
	private GameService javaGameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("review", "command", new Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("review", "submittedReview", review);
	}
	

	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("games", "command", new Game());
	}
	

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGamesByGenre(@RequestBody String genre) {
		return new ResponseEntity<List<Game>>(javaGameService.findGameByGenre(genre), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED); 
	}
		
	@DeleteMapping(value = "/deleteAGame/{id}")
	public ResponseEntity<?> deleteAGame(@PathVariable String id)
	{
		System.out.println(id);
		javaGameService.gameWillBeDeleted(Long.valueOf(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
	}
	
