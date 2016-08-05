var app = angular.module('app', [ 'ngAnimate', 'ngTouch', 'ui.grid' ]);
var mySample = angular.module('sample', []);
mySample.controller('WelcomeController', function($scope, $http, $location) {
	var url = $location.$$protocol + "://" + $location.$$host + ":"
			+ $location.$$port;
	$scope.submit = function() {
		$http.post(url + "/api/experiment", {
			content : $scope.firstName
		}).then(function(response) {
			$scope.greeting = '[Response from Server]' + response.data.content;
		})
		$scope.names = [ {
			firstName : $scope.firstName,
			lastName : "Test"
		} ];
	}
});

var residence = angular.module('residence', []).config(
		function($routeProvider) {
			$routeProvider
			// route for the contact page
			.when('/addResidence', {
				templateUrl : 'templates/residence.view.html',
				controller : 'residenceController'
			}).otherwise({
				redirectTo : '/login'
			});
		});

residence.controller('residenceController', function($scope, $http, $location) {
	$scope.residenceList = [];
	var url = $location.$$protocol + "://" + $location.$$host + ":"
			+ $location.$$port;
	$http.get(url + "/api/residence").then(function(response) {
		$scope.residenceList = response.data;
	})

	$scope.residenceAdd = function() {
		$http.post(url + "/api/residence", {
			name : $scope.name,
			age : $scope.age,
			gender : $scope.gender
		}).then(function(response) {
			$scope.residenceList.push(response.data);
		})
		$scope.name = "";
		$scope.age = "";
		$scope.gender = "";
	};
	$scope.markPaid = function() {
		var self = this;
		 $http.put(url + "/api/residence/paid/" + this.residence.id).then(function(response) {
			console.log("Updated");
			self.residence.isPaid = "paid";
		})
	};

	$scope.remove = function() {
		var oldList = $scope.residenceList;
		$scope.residenceList = [];
		angular.forEach(oldList, function(x) {
			$scope.residenceList.push(x);
		});
	};
});
