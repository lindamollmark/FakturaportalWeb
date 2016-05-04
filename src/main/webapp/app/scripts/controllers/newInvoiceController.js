/**
 * Created by Linda on 2016-03-13.
 */
'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:invoiceListCtrl
 * @description
 * # invoiceListCtrl
 * Controller of the webappApp
 */
angular.module('springBootClientApp')
  .controller('newInvoiceCtrl', function($routeParams, $scope, clientService, invoiceService) {
    var vm = this;
   var invoiceRows = [];
    var client = {};
    $scope.invoice = {invoiceNo: 0,
    client: client,
    invoiceRows: invoiceRows};


    //var client = {
    //  clientNo: 1,
    //  companyName: "Linda Test"
    //};

    var id  = $routeParams.param;
    var clientID = {clientId: id};

    clientService.fetchClient(clientID).then(function(response){
      $scope.invoice.client = angular.fromJson(response.data);
    });

    $scope.saveInvoice = function(){
      var invoice = $scope.invoice;
 var ir = invoice.invoiceRows;
      var rowsToSave = [];
      _.forEach(ir, function(invoiceRow){
        if (invoiceRow.rowNo > 0){
          rowsToSave.push(invoiceRow);
        }
       });

      invoice.invoiceRows = rowsToSave;
      invoiceService.save(invoice);
    }

    for(var i = 1; i < 10; i++){
      var invoiceRow = {
        rowNo: "",
        articleNo: '',
        quantity: 0,
        description: '',
        unitPrice:0,
      };
      $scope.invoice.invoiceRows.push(invoiceRow);

    }

  });


