var welcome = angular.module("welcome", []).config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'templates/welcome.view.html',
		controller : 'welcomeController'
	});
});
welcome.controller('welcomeController', function($scope, $http, $location) {
	$scope.navigateToLogin = function() {
		$location.path('/login');
	};
});
