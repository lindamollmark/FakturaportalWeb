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

  var service = {
    fetchClient: fetchClient,
    save: save,
    remove: remove,
    getClientList: getClientList,
    updateClient: updateClient
  };

  return service;

  function fetchClient(clientID){
 return $http({method: 'POST', url:'http://localhost:8080/views/clientView', data: clientID});
  }

  function save(theClient){
    $http({method: 'POST', url:'http://localhost:8080/views/newClient', data: theClient});
  }

  function remove(theClient){
    $http({method: 'POST', url:'http://localhost:8080/views/deleteClient', data: clientID});
  }

  function getClientList(){
    return $http({method: 'get', url:'http://localhost:8080/views/clientlist'});

  }

  function  updateClient(theClient){
  return $http({method: 'POST', url:'http://localhost:8080/views/updateClient', data: theClient});
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
