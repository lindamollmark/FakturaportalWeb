/**
 * Created by Linda on 2016-03-12.
 */
(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.client', [])
    .factory('clientService', clientService);

  clientService.$inject = ['$http'];
function clientService($http){

  var restURL = 'http://localhost:8080/#/newClient';

  var service = {
    save: save
  };

  return service;

  function save(theClient){
    $http({method: 'POST', url:'http://localhost:8080/views/newClient', data: theClient});


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
