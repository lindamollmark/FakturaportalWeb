angular.module('springBootClientApp')
  .controller('newClientCtrl', function($scope, clientService) {
    var client = {};

    $scope.save = function(){
      clientService.save($scope.client);
      $scope.client = {};
      $scope.newClientForm.$setPristine();
    };
  });
