angular.module('springBootClientApp')
  .controller('newClientCtrl', function($scope, clientService) {
    var client = {};

    $scope.save = function(){
      // TODO Flytta metod till servicen.
      clientService.save($scope.client);
      //client = $scope.client;
      //$http({method: 'POST', url:'http://localhost:8080/views/newClient', data: client});
      $scope.client = {};
      $scope.newClientForm.$setPristine();
    };
  });
