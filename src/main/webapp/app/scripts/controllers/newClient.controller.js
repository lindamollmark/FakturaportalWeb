/**
 * @ngdoc function
 * @name springBootClientApp.controller:ClientCtrl
 * @description
 * # clientListCtrl helps with the functions regarding adding a new client.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('newClientCtrl', function($scope, clientService, $location, $rootScope) {
    var user = $rootScope.currentUser;
    $scope.client = {user: user};
    var exsist = false;
    $scope.buttonSave = false;

    $scope.save = function(){
      clientService.save($scope.client).then(function(response){
        var saved = response.data;
        var clientID = saved.id;
        var path = "/clientView" + clientID;
        $location.path(path);
      });
    };

    $scope.checkClientNo = function() {
      clientService.checkClientNo($scope.client.clientNo).then(function (response) {
        $scope.exsist = (response.data);
      });
    }
  });
