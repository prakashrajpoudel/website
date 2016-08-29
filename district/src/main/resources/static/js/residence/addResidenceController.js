residence.controller('addResidenceController', function($scope, $http,
		$location) {
	$scope.residenceList = [];
	var url = $location.$$protocol + "://" + $location.$$host + ":"
			+ $location.$$port;
	$http.get(url + "/api/residence").then(function(response) {
		$scope.residenceList = response.data;
	})

	$scope.addResidence = function() {
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

	$scope.naviageToUpdate = function() {
		$location.path('/updateResidence/' + this.residence.id);
	};

	$scope.markPaid = function() {
		var self = this;
		$http.put(url + "/api/residence/paid/" + this.residence.id).then(
				function(response) {
					console.log("Updated");
					self.residence.paid = "paid";
				})
	};

	$scope.remove = function($index) {
		var self = this;
		$http.delete(url + "/api/residence/" + this.residence.id).then(
				function(response) {
					if (response.status === 204) {
					  $scope.residenceList.splice($index,1);
					}
					console.log(response);
				})

	};
});