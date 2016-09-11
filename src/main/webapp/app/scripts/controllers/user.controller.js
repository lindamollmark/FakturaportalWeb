'use strict';
/**
 * @ngdoc function
 * @name springBootClientApp.controller:userCtrl
 * @description
 * # userCtrl helps with the functions regarding a user.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('userCtrl', function($scope, $rootScope, userService) {
    userService.fetchUser($rootScope.currentUser).then(function(response){
      $scope.user = angular.fromJson(response.data);
    });
    $scope.save = function(){
      userService.updateUser($scope.user).then(function(response){
        var saved = response.data;
        var userId = saved.id;
        $scope.updateMessage = "Användarinformation uppdaterad";
      });
    };

  });

