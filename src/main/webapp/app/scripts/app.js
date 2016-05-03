'use strict';

/**
 * @ngdoc overview
 * @name webappApp
 * @description
 * # webappApp
 *
 * Main module of the application.
 */
angular
  .module('springBootClientApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'springBootClientApp.controllers',
    'springBootClientApp.services'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'app/views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/newClient', {
        templateUrl: 'app/views/newClient.html',
        controller: 'newClientCtrl'
      })
      .when('/clientList', {
        templateUrl: 'app/views/clientList.html',
        controller: 'clientListCtrl'
      })
      .when('/invoiceList', {
        templateUrl: 'app/views/invoiceList.html',
        controller: 'invoiceListCtrl'
      })
      //.when('/newInvoice', {
      //  templateUrl: 'app/views/newInvoice.html',
      //  controller: 'newInvoiceCtrl'
      //})
      .when('/newInvoice:param', {
        templateUrl: 'app/views/newInvoice.html',
        controller: 'newInvoiceCtrl'
      })
      .when('/clientView:param', {
      templateUrl: 'app/views/clientView.html',
      controller: 'clientCtrl'
    })
      .otherwise({
        redirectTo: '/'
      });
  });
