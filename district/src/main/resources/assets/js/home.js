(function () {
    'use strict';

    angular
        .module('home', ['ngRoute', 'ngCookies'])
        .config(config)
        .factory('authentication', function() {
            return {
              isAuthenticated: false,
              user: null
            }
        })
        .controller('LoginController',function($scope, $http, $location, authentication){
          $scope.login = function () {
            console.log("Logging in " + $scope.username  + " -- " + $scope.password);
            $http.post("//localhost:8080/api/login", {username : $scope.username, password: $scope.password}).then(function(response){
              console.log(response.data);
              // $location.absUrl("//localhost:8080/addNewResidence.html");
              window.location.href = "//localhost:8080/addNewResidence.html";
              //https://github.com/prakashrajpoudel/website/issues/11
            })
          };
        })
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'view/login.view.html',
                controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();
