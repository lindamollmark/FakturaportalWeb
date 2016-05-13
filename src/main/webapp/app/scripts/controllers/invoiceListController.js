/**
 * Created by Linda on 2016-03-13.
 */
'use strict';

/**
 * @ngdoc function
 * @name springBootClientApp.controller:invoiceListCtrl
 * @description
 * # invoiceListCtrl fetches the list of invoices and helps when updating the dueDate.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('invoiceListCtrl', function(invoiceService, $routeParams, $scope) {
    var self = this;
    self.edit = false;
    var id  = $routeParams.param;


    if(id > 0){
      var clientID = {id: id};
      invoiceService.getClientInvoiceList(clientID).then(function(response){
        self.invoice = angular.fromJson(response.data);
      });
    }
    else{
      invoiceService.getInvoiceList().then(function(response){
        self.invoice = angular.fromJson(response.data);
      });
    }

    self.updateDueDate = function (invoice) {
      invoiceService.updateInvoice(invoice);
    }

  });




