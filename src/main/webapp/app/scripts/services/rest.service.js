/**
 * Created by Linda on 2016-03-11.
 */
(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.rest', [])
    .factory('RestService', RestService);

  RestService.$inject = ['$resource'];

  function RestService($resource) {

    var restURL = 'http://localhost:8080/hello/';

    var service = {
      sayHello: sayHello
    };

    var privateAPI = {};


    return service;

    function sayHello(name){
      var hello = $resource(restURL + ':name',
        {
          method: 'JSONP',
          name: '@name'
        });
      var promise = hello.get({name: name}).$promise;
      return promise;
    }
  }
})();
