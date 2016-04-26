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
  .controller('newInvoiceCtrl', function() {
    var self = this;

    var aClient = {
      clientNo: 1,
      companyName: 'Berggrens',
      address1: 'Lokesväg 16',
      postCode: 14833,
      postAddress: 'Ösmo',
      contact: 'Kenneth',
      phoneNumber: '0739823191'
    };
    self.client = aClient;
  });

