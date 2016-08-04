var login = angular.module("login", []).config(function($routeProvider) {
	$routeProvider
	.when('/login', {
		templateUrl : 'templates/login.view.html',
		controller : 'loginController'
	});
});
login.controller('loginController',
		function($scope, $http, $location) {
			var url = $location.$$protocol + "://" + $location.$$host + ":"
					+ $location.$$port;
			$scope.login = function() {
				console.log("Logging in " + $scope.username + " -- "
						+ $scope.password);
				$http.post(url + "/api/login", {
					username : $scope.username,
					password : $scope.password
				}).then(function(response) {
					console.log(response.data);
					// $location.absUrl("//localhost:8080/addNewResidence.html");
					$location.path('/addResidence');
					// https://github.com/prakashrajpoudel/website/issues/11
				})
			};
		});
