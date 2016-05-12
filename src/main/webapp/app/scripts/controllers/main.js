'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('springBootClientApp')
  .controller('MainCtrl', function ($scope, $rootScope, $location) {
    $scope.logout = function(){
      $rootScope.existingUser = false;

        $rootScope.currentUser = {};
        var path = "/";
        $location.path(path);
    }
  });
