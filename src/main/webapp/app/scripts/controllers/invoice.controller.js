/**
 * Created by Linda on 2016-03-13.
 */
'use strict';

/**
 * @ngdoc function
 * @name springBootClientApp.controller:invoiceListCtrl
 * @description
 * # invoiceListCtrl fetches the invoice and helps when we shall print the PDF
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('invoiceCtrl', function ($routeParams, $scope, clientService, invoiceService) {

    var no = $routeParams.invoiceNo;
    var invoiceNo = {invoiceNo: no};

    invoiceService.fetchInvoice(invoiceNo).then(function (response) {
      $scope.invoice = angular.fromJson(response.data);
    })

    $scope.print = function (invoice) {
      invoiceService.printInvoice(invoice);
    }


  });


