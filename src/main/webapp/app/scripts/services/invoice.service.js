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

    function save(invoice, client, invoiceRows){
      alert("Fakturanummer: " + invoice.invoiceNo + ", kundnummer: " + client.clientNo);
    }
    return service;
  }
})();
