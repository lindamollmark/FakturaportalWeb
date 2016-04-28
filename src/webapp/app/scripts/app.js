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
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/newClient', {
        templateUrl: 'views/newClient.html',
        controller: 'newClientCtrl'
      })
      .when('/clientList', {
        templateUrl: 'views/clientList.html',
        controller: 'clientListCtrl'
      })
      .when('/invoiceList', {
        templateUrl: 'views/invoiceList.html',
        controller: 'invoiceListCtrl'
      })
      .when('/newInvoice', {
        templateUrl: 'views/newInvoice.html',
        controller: 'newInvoiceCtrl'
      })
      .when('/newInvoice:param', {
        templateUrl: 'views/newInvoice.html',
        controller: 'newInvoiceCtrl'
      })
      .when('/clientView:param', {
      templateUrl: 'views/clientView.html',
      controller: 'clientCtrl'
    })
      .otherwise({
        redirectTo: '/'
      });
  });
