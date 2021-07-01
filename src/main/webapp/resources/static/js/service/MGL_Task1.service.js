'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		

		var factory = {
			fetchAllGames : fetchAllGames,
			fetchAllGamesByGenre : fetchAllGamesByGenre,
			createGame : createGame,
			deleteAGame : deleteAGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get('getAll').then(function(response) {
					return response.data;
				}
			);
		}
		function fetchAllGamesByGenre(genreString) {
			return $http(
			{
				url:'search',
				method:'GET',
				params:{genre: genreString}
			}
			
			
			).then(function(response){
					return response.data;
				}
			);
		}
	

		function createGame(game) {
			return $http.post( 'createGame', game).then(function(response) {
					return response.data;
				}
				
			);
		}
		
		function deleteAGame(gameId)
		{
			return $http.delete("http://localhost:8080/deleteAGame/" + gameId).then(function(response) {
					return response.data;
				});
			
		}
		
		

}]);
