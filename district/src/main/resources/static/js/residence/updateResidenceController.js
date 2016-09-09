residence.controller('updateResidenceController', function($scope, $http,
		$location, $routeParams) {
	var map = new google.maps.Map(document.getElementById('location'), {
		center : {
			lat : 27.975327,
			lng : 84.267845
		},
		zoom : 14
	});
	var url = $location.$$protocol + "://" + $location.$$host + ":"
			+ $location.$$port;
	$http.get(url + "/api/residence/" + $routeParams.id).then(
			function(response) {
				$scope.residence = response.data;
			});
	$scope.updateResidence = function() {
		$http.put(url + "/api/residence", {
			id : $scope.residence.id,
			name : $scope.residence.name,
			age : $scope.residence.age,
			gender : $scope.residence.gender,
			paid : $scope.residence.paid
		}).then(function(response) {
			console.log(response.data);
		})
	};
	$scope.initializeMap = function() {

	};

	var popup = new google.maps.InfoWindow({
		content : residence.name
	});
	google.maps.event.addListener(map, 'click', function(event) {
		var marker = new google.maps.Marker({
			position : event.latLng,
			map : map,
			icon : '/img/person_icon.png'
		});
		google.maps.event.addListener(marker, "mouseover", function(event) {
			popup.setContent(document.getElementById('name').value);
			popup.open(map, this);
		});
		google.maps.event.addListener(marker, "mouseout", function(event) {
			popup.close(map, this);
		});
	});
});