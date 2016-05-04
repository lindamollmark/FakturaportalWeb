(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.invoice', [])
    .factory('invoiceService', invoiceService);

  invoiceService.$inject = ['$http'];
  function invoiceService($http) {

    var service = {
      save: save
    };

    function save(invoice){

        $http({method: 'POST', url:'http://localhost:8080/views/newInvoice', data: invoice});

    }
    return service;
  }
})();
