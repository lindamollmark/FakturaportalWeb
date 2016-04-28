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
  .controller('invoiceListCtrl', function() {
    var self = this;

    var invoiceList = [{
      lineNo: 1254,
      item: 'test'
    },
      {
        lineNo: 1255,
        item: 'test2'

      }
    ];
    self.invoice = invoiceList;
  });
//
//angular.module('springBootClientApp')
//  .controller('newInvoiceCtrl', function() {
//    var self = this;
//
//    var invoiceList = [{
//      lineNo: 1254,
//      item: 'test'
//    },
//      {
//        lineNo: 1255,
//        item: 'test2'
//
//      }
//    ];
//    self.invoice = invoiceList;
//  });


angular.module('springBootClientApp')
  .controller('newInvoiceCtrl', function($routeParams) {
    var self = this;
    self.client = $routeParams.param;
    self.invoiceRows = [];

    for(var i = 1; i < 11; i++){
      var invoiceRow = {
        rowNo: i,
        articleNo:'',
        quantity: 0,
        description: '',
        unitPrice:0,
        total: 0
      };
      self.invoiceRows.push(invoiceRow);

    }

  });


