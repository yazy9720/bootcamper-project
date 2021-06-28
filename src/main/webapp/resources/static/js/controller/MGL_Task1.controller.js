'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				gameId : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			self.updateGame = function(){
				return MGL_Task1_Service.updateGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			self.deleteAGame = function(game){
			console.log(game);
			console.log(game.gameId);
			
				return MGL_Task1_Service.deleteAGame(game.gameId).then( function() {
				self.fetchAllGames();
				});
			}
		self.fetchAllGames();
		
		
}]);
