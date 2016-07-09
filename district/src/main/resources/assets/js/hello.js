function Hello($scope, $http) {
$http.get('//localhost:8080/api/experiment').
  success(function(data) {
      console.log("test Server data");
      $scope.greeting = data;
  });
}
