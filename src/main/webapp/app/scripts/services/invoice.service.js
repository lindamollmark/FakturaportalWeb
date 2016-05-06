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
      updateInvoice: updateInvoice
    };

    return service;
    function save(invoice){
      $http({method: 'POST', url:'http://localhost:8080/views/newInvoice', data: invoice});
    };


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
      alert("inne i servicen");
       $http({method: 'POST', url:'http://localhost:8080/views/updateInvoice', data: invoice});
    };
  }
})();
