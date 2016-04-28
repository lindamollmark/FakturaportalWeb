angular.module('springBootClientApp')
  .controller('clientListCtrl', function($http) {
    var self = this;
    $http({method: 'get', url:'http://localhost:8080/views/clientlist'}).then(function(response){
      self.client = angular.fromJson(response.data);
    });
  });
