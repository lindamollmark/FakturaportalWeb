/**
 * Created by Linda on 2016-03-12.
 */
'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ClientCtrl
 * @description
 * # ClientCtrl
 * Controller of the webappApp
 */
//, clientService
angular.module('springBootClientApp')
  .controller('newClientCtrl', function($scope, $http) {
    var client = {};

    $scope.save = function(){
      // TODO Flytta metod till servicen.
      client = $scope.client;
      $http({method: 'POST', url:'http://localhost:8080/views/newClient', data: client});
      //var promise = clientService.save(client);
      $scope.client = {};
     $scope.newClientForm.$setPristine();
    };
  });

angular.module('springBootClientApp')
  .controller('clientListCtrl', function($http, $scope, $location) {
    var self = this;
    $http({method: 'get', url:'http://localhost:8080/views/clientlist'}).then(function(response){
     var clientList = angular.fromJson(response.data);
      self.client = clientList;
    });
$scope.openClient = function(id){
  alert("ClientId = " + id);
  $location.url('#/client/' + id);
};
  });

angular.module('springBootClientApp')
  .controller('clientCtrl', function() {
    var self = this;

    var aClient = {
      clientNo: 1,
      companyName: 'Berggrens',
      address1: 'Lokesväg 16',
      postCode: 14833,
      postAddress: 'Ösmo',
      contact: 'Kenneth',
      phoneNumber: '0739823191'
    };
    self.client = aClient;
  });



