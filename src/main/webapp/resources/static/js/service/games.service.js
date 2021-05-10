'use strict';

angular.module('GameLibraryApp').factory('GameLibraryService', ['$http', function($http) {

		var REST_SERVICE_URI = 'http://localhost:8080/game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}

}]);
