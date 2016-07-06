function Hello($scope, $http) {
$http.get('http://localhost:8080/api/experiment').
  success(function(data) {
      console.log("test Server data");
      $scope.greeting = data;
  });
}
