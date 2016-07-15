var app = angular.module('app', ['ngAnimate', 'ngTouch', 'ui.grid']);
var mySample = angular.module('sample', []);
mySample.controller('WelcomeController', ['$scope', '$http', function($scope, $http) {
     console.log("Controller");
      $scope.greeting = 'Welcome!';
      $scope.submit = function () {
        $http.post("//localhost:8080/api/experiment", {content : $scope.firstName}).then(function(response){
          $scope.greeting = '[Response from Server]' + response.data.content;
        })
        $scope.names = [{firstName: $scope.firstName, lastName : "Test"}];
      }
  }]);

  var residence = angular.module('residence', []);
  residence.controller('residenceController', function($scope) {
      $scope.residenceList = [];

      $scope.residenceAdd = function() {
          $scope.residenceList.push({name:$scope.name, age: $scope.age, gender: $scope.gender});
          $scope.name = "";
          $scope.age = "";
          $scope.gender = "";
      };

      $scope.remove = function() {
          var oldList = $scope.residenceList;
          $scope.residenceList = [];
          angular.forEach(oldList, function(x) {
              $scope.residenceList.push(x);
          });
      };
  });
