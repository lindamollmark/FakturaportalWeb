angular.module('springBootClientApp')
  .controller('clientListCtrl', function($http, clientService) {
    var self = this;
   clientService.getClientList().then(function(response){
      self.client = angular.fromJson(response.data);
    });
  });
