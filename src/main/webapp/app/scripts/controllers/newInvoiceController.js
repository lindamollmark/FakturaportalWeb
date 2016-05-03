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
    $scope.invoiceRows = [];
    $scope.invoice = {invoiceNo: 0};


    //var client = {
    //  clientNo: 1,
    //  companyName: "Linda Test"
    //};

    var id  = $routeParams.param;
    var clientID = {clientId: id};

    clientService.fetchClient(clientID).then(function(response){
      $scope.client = angular.fromJson(response.data);
    });

    $scope.saveInvoice = function(){
      var invoice = $scope.invoice;
 var invoiceRows = $scope.invoiceRows;
      invoiceService.save(invoice, $scope.client, invoiceRows );
    }


    //vm.client = client;


    for(var i = 1; i < 15; i++){
      var invoiceRow = {
        rowNo: i,
        articleNo: 45,
        quantity: 0,
        description: '',
        unitPrice:0,
        editing: false
      };
      $scope.invoiceRows.push(invoiceRow);

    }
    $scope.editRows = function (row) {
      row.editing = true;
    }

    $scope.doneEditing = function (row) {
      row.editing = false;
      //dong some background ajax calling for persistence...
    };
  });


