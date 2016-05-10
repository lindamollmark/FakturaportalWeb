(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.invoice', [])
    .factory('invoiceService', invoiceService);

  invoiceService.$inject = ['$http'];
  function invoiceService($http) {

    var service = {
      save: save,
      getInvoiceNo: getInvoiceNo,
      getInvoiceList: getInvoiceList,
      getClientInvoiceList: getClientInvoiceList,
      updateInvoice: updateInvoice,
      fetchInvoice: fetchInvoice,
      printInvoice: printInvoice
    };

    return service;

    function save(invoice){
      return $http({method: 'POST', url:'http://localhost:8080/views/newInvoice', data: invoice});
    };

    function fetchInvoice(invoiceNo){
      return $http({method: 'POST', url:'http://localhost:8080/views/fetchInvoice', data: invoiceNo});
    }
    function getInvoiceNo(){
      return $http({method: 'GET', url:'/views/newInvoiceNo'});
    };

    function getInvoiceList(){
      return $http({method: 'get', url:'http://localhost:8080/views/invoicelist'});
    };
    function getClientInvoiceList(clientID){
      return $http({method: 'POST', url:'http://localhost:8080/views/clientInvoicelist', data: clientID});
    };
    function  updateInvoice(invoice){
      $http({method: 'POST', url:'http://localhost:8080/views/updateInvoice', data: invoice});
    };
    function  printInvoice(invoice){
      $http({method: 'POST', url:'http://localhost:8080/views/printInvoice', data: invoice});
    }
  }
})();
