'use strict';

angular.module('GameLibraryApp').controller('GameLibraryController',
		[ 'GameLibraryService', function(GameLibraryService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameLibraryService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameLibraryService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game){
				return GameLibraryService.deleteGame(game.id).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
