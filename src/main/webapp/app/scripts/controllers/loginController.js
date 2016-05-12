'use strict';
angular.module('springBootClientApp')
  .controller('LoginCtrl', function ($scope, $rootScope, authService, $location) {
      $scope.credentials = {
        username: '',
        password: ''
      };
      $scope.login = function (credentials) {

        authService.login(credentials).then(function (response) {
          $rootScope.existingUser = response.data;
          if(response.data == true){
            $rootScope.currentUser = credentials;
            var path = "/";
            $location.path(path);
          }


               });
      };
    });
