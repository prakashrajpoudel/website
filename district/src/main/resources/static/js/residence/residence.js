var residence = angular.module('residence', []).config(
		function($routeProvider) {
			$routeProvider
			// route for the contact page
			.when('/addResidence', {
				templateUrl : 'templates/residence/addResidence.view.html',
				controller : 'addResidenceController'
			}).when('/updateResidence/:id', {
				templateUrl : 'templates/residence/updateResidence.view.html',
				controller : 'updateResidenceController'
			}).otherwise({
				redirectTo : '/login'
			});
		});

