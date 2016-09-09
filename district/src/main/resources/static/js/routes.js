// DELETE ME
main.config(function($routeProvider) {
	$routeProvider

	// route for the about page
	.when('/addResidence', {
		templateUrl : 'templates/residence.view.html',
		controller : 'addResidence'
	})

	// route for the contact page
	.when('/login', {
		templateUrl : 'templates/login.view.html',
		controller : 'loginController'
	}).otherwise({
		redirectTo : '/login'
	});
});