var main = angular.module('main',
		[ 'ngRoute', 'login', 'residence', 'welcome', 'gridView' ]).config(
		function($routeProvider) {
			$routeProvider
			// route for the contact page
			// .when('/', {
			// redirectTo : '/'
			// });
		});
main.controller("menuController", function($scope) {
	$scope.expandMenu = function() {
		// Change to Jquery
		var x = document.getElementById("myTopnav");
		if (x.className === "topnav") {
			x.className += " responsive";
		} else {
			x.className = "topnav";
		}
	};
});