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
  .controller('clientCtrl', function($scope, $routeParams, $http, clientService, $window) {
    var self = this;


    var id = $routeParams.param;
    var clientID = {clientId: id};

    $http({method: 'POST', url:'http://localhost:8080/views/clientView', data: clientID}).then(function(response){
      $scope.client = angular.fromJson(response.data);

    });

    $scope.delete = function(){
      clientService.remove(clientID);
      //$http({method: 'POST', url:'http://localhost:8080/views/deleteClient', data: clientID});
    }

    $scope.update = function(){
      var client = {};
      client = $scope.client;
     clientService.updateClient(client).then(function(response){
        self.client = angular.fromJson(response.data);
       $scope.updateMessage = "Kund uppdaterad";
      });
    }

  });



