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
  .controller('invoiceCtrl', function($routeParams, $scope, clientService, invoiceService, $location) {
    var vm = this;

    //var cId  = $routeParams.clientID;
    //var clientID = {clientId: cId};

    var no  = $routeParams.invoiceNo;
    var invoiceNo = {invoiceNo: no};

    //clientService.fetchClient(clientID).then(function(response){
    //  $scope.invoice.client = angular.fromJson(response.data);
    //});

    invoiceService.fetchInvoice(invoiceNo).then(function(response){
      $scope.invoice = angular.fromJson(response.data);
    })

    $scope.print = function(invoice){
    invoiceService.printInvoice(invoice);
    }




  });


