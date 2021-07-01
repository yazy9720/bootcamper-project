'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}
			self.fetchAllGamesByGenre = function(genre){
				MGL_Task1_Service.fetchAllGamesByGenre(genre).then(function(data) {
					self.games = data;
				});
			}
			

			self.addGame = function(){
			
					return MGL_Task1_Service.createGame(self.game).then( function() {
					self.fetchAllGames();
					self.game = {};
					});
				
			}
				
			self.updateGame = function(game){
		
			self.game = angular.copy(game);
				console.log(game);
				
			}
			self.deleteAGame = function(game){
			console.log(game);
			console.log(game.id);
			
				return MGL_Task1_Service.deleteAGame(game.id).then( function() {
				self.fetchAllGames();
				});
			}
		self.fetchAllGames();
		
		
}]);
