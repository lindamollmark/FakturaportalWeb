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
      client = $scope.client;
      $http({method: 'POST', url:'http://localhost:8080/views/newClient', data: client});
      //var promise = clientService.save(client);

      alert(client.companyName);

    };
  });

angular.module('springBootClientApp')
  .controller('clientListCtrl', function() {
      var self = this;

  var clientList = [{
    clientNo: 1,
    companyName: 'Berggrens',
    address1: 'Lokesväg 16',
    postCode: 14833,
    postAddress: 'Ösmo',
    contact: 'Kenneth',
    phoneNumber: '0739823191'
  },
    {
      clientNo: 2,
      companyName: 'Möllmark',
      address1: 'Långvägen 42',
      postCode: 13755,
      postAddress: 'Tungelsta',
      contact: 'Anders',
      phoneNumber: '0723610845'

  }
  ];
  self.client = clientList;
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



