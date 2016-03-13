/**
 * Created by Linda on 2016-03-12.
 */
(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.client', [])
    .factory('clientService', clientService);

  clientService.$inject = ['$resource'];
//angular.module.factory('clientService', clientService);
//  clientService.$inject = ['$http'];
function clientService($resource){

  var restURL = 'http://localhost:8080/#/newClient/';

  var service = {
    save: save
  };

  var privateAPI = {};


  return service;

  function save(theClient){
    var client = $resource(restURL,
      {
        method: 'JSONP',
        client: '@client'
      });
    client.post({Client: theClient});

  }
}
})();



  //
  //var newClient = {};
  //
  //newClient.save = function(theClient){
  //  var promise = $http({method: 'POST', url:'/newClient/', data: theClient});
  //  return promise;
  //};})
