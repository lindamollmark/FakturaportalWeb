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
  .controller('newInvoiceCtrl', function($routeParams, $scope, clientService, invoiceService, $location) {
    var vm = this;
   var invoiceRows = [];
    var client = {};
    $scope.invoice = {
      id: 0,
      invoiceNo: 0,
      orderNo: "",
    client: client,
    invoiceRows: invoiceRows
    };

    var id  = $routeParams.param;
    var clientID = {clientId: id};

    clientService.fetchClient(clientID).then(function(response){
      $scope.invoice.client = angular.fromJson(response.data);
    });

    invoiceService.getInvoiceNo().then(function(response){
      $scope.invoice.invoiceNo = angular.fromJson(response.data);
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
      invoiceService.save(invoice).then(function(response){
        $scope.invoice = angular.fromJson(response.data);
        var invoiceNo = invoice.invoiceNo;
        var path = "/invoiceView" + invoiceNo;
        $location.path(path);
      });
      //$scope.invoiceMessage = "Faktura skapad";
      var clientID = invoice.client.clientId;


    };

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
    $scope.today = function() {
      $scope.invoice.invoiceDate = new Date();
    };
    $scope.today();

    $scope.clear = function() {
      $scope.dt = null;
    };

    $scope.inlineOptions = {
      customClass: getDayClass,
      minDate: new Date(),
      showWeeks: true
    };

    $scope.dateOptions = {
      dateDisabled: disabled,
      formatYear: 'yy',
      maxDate: new Date(2020, 5, 22),
      minDate: new Date(),
      startingDay: 1
    };

    // Disable weekend selection
    function disabled(data) {
      var date = data.date,
        mode = data.mode;
      return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }

    $scope.toggleMin = function() {
      $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
      $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.toggleMin();

    $scope.open1 = function() {
      $scope.popup1.opened = true;
    };

    $scope.open2 = function() {
      $scope.popup2.opened = true;
    };

    $scope.setDate = function(year, month, day) {
      $scope.dt = new Date(year, month, day);
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.altInputFormats = ['M!/d!/yyyy'];

    $scope.popup1 = {
      opened: false
    };

    $scope.popup2 = {
      opened: false
    };

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 1);
    $scope.events = [
      {
        date: tomorrow,
        status: 'full'
      },
      {
        date: afterTomorrow,
        status: 'partially'
      }
    ];

    function getDayClass(data) {
      var date = data.date,
        mode = data.mode;
      if (mode === 'day') {
        var dayToCheck = new Date(date).setHours(0,0,0,0);

        for (var i = 0; i < $scope.events.length; i++) {
          var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

          if (dayToCheck === currentDay) {
            return $scope.events[i].status;
          }
        }
      }

      return '';
    }

  });


