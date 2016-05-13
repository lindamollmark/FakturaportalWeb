/**
 * @ngdoc function
 * @name springBootClientApp.controller:ClientCtrl
 * @description
 * # clientListCtrl helps with the functions regarding the clientList.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('clientListCtrl', function($http, clientService) {
    var self = this;

   clientService.getClientList().then(function(response){
      self.client = angular.fromJson(response.data);
    });
  });
