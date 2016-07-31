(function() {
	'use strict';

	angular.module('home', [ 'ngRoute', 'ngCookies' ]).config(config).factory(
			'authentication', function() {
				return {
					isAuthenticated : false,
					user : null
				}
			}).controller('AddResidenceController',
			function($scope, $http, $location, authentication) {
				console.log("Navigated to new controller");
			}).controller(
			'LoginController',
			function($scope, $http, $location, authentication) {
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
			}).run(run);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/login', {
			controller : 'LoginController',
			templateUrl : 'view/login.view.html',
			controllerAs : 'vm'
		}).when('/addResidence', {
			controller : 'AddResidenceController',
			templateUrl : 'view/residence.view.html',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/login'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
	function run($rootScope, $location, $cookieStore, $http) {
		// keep user logged in after page refresh
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata; // jshint
			// ignore:line
		}

		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			// redirect to login page if not logged in and trying to
			// access a restricted page
			console.log("Tracking change");
			// var restrictedPage = $.inArray($location.path(),
			// [ '/login' ]) === -1;
			// var loggedIn = $rootScope.globals.currentUser;
			// if (restrictedPage && !loggedIn) {
			// $location.path('/login');
			// }
		});
	}

})();
