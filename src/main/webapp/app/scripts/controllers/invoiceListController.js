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
  .controller('invoiceListCtrl', function(invoiceService, $routeParams, $scope) {
    var self = this;
    self.edit = false;
    var id  = $routeParams.param;


    if(id > 0){
      var clientID = {clientId: id};
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




