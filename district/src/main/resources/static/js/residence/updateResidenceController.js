residence.controller('updateResidenceController', function($scope, $http,
		$location, $routeParams) {
	var url = $location.$$protocol + "://" + $location.$$host + ":"
			+ $location.$$port;
	$http.get(url + "/api/residence/" + $routeParams.id).then(function(response) {
		$scope.residence = response.data;
	});
	$scope.updateResidence = function() {
		$http.put(url + "/api/residence", {
			id: $scope.residence.id,
			name : $scope.residence.name,
			age : $scope.residence.age,
			gender : $scope.residence.gender,
			paid : $scope.residence.paid
		}).then(function(response) {
			console.log(response.data);
		})
	};
});