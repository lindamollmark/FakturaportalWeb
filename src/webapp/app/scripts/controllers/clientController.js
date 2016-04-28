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
  .controller('clientCtrl', function($scope, $routeParams, $http) {
    var self = this;


    var id = $routeParams.param;
    var clientID = {clientId: id};

    $http({method: 'POST', url:'http://localhost:8080/views/clientView', data: clientID}).then(function(response){
      var client = angular.fromJson(response.data);
      $scope.client = client;
    });

    $scope.delete = function(){
      $http({method: 'POST', url:'http://localhost:8080/views/deleteClient', data: clientID});
    }

    $scope.update = function(){
      var client = {};
      client = $scope.client;
      $http({method: 'POST', url:'http://localhost:8080/views/updateClient', data: client}).then(function(response){
        var clientList = angular.fromJson(response.data);
        self.client = clientList;
      });
    }
    $scope.invoiceDiv = false;
    $scope.makeInvoice = function () {
      //If DIV is visible it will be hidden and vice versa.
      $scope.invoiceDiv = $scope.invoiceDiv ? false : true;
    }
  });



