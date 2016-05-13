
/**
 * @ngdoc function
 * @name springBootClientApp.controller:newUserCtrl
 * @description
 * # newUserCtrl helps with the functions regarding adding a new user.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('newUserCtrl', function($scope, userService, $location) {

    var exsist = false;
    $scope.save = function(){
      userService.save($scope.user).then(function(response){
        var saved = response.data;
        var userId = saved.id;
        var path = "/login";
        $location.path(path);
      });
    };

    $scope.checkUsername = function() {
      userService.checkUsername($scope.user.username).then(function (response) {
        $scope.exsist = (response.data);
      });
    }
  });

