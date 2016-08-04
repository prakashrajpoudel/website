var main = angular.module('main', [ 'ngRoute', 'login', 'residence' ]).config(
		function($routeProvider) {
			$routeProvider
			// route for the contact page
			.when('/', {
				redirectTo : '/login'
			});
		});