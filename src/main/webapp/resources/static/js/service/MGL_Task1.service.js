'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get('getAll').then(function(response) {
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

}]);
