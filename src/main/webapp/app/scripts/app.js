'use strict';

/**
 * @ngdoc overview
 * @name springBootClientApp
 * @description
 * # springBootClientApp
 *
 * Main module of the application.
 * routeProvider helps to redirect what should be shown in the include view.
 */
angular
  .module('springBootClientApp', [
    'ngAnimate',
    'contenteditable',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'ngFileUpload',
    'springBootClientApp.controllers',
    'springBootClientApp.services'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/login', {
        templateUrl: 'app/views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/newUser', {
        templateUrl: 'app/views/newUser.html',
        controller: 'newUserCtrl'
      })
      .when('/', {
        templateUrl: 'app/views/main.html',
        controller: 'LoginCtrl'
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
      .when('/invoiceList:param', {
        templateUrl: 'app/views/invoiceList.html',
        controller: 'invoiceListCtrl'
      })
      .when('/newInvoice:param', {
        templateUrl: 'app/views/newInvoice.html',
        controller: 'newInvoiceCtrl'
      })
      .when('/invoiceView:invoiceNo', {
        templateUrl: 'app/views/invoiceView.html',
        controller: 'invoiceCtrl'
      })
      .when('/clientView:id', {
        templateUrl: 'app/views/clientView.html',
        controller: 'clientCtrl'
      })
      .when('/userSettings', {
        templateUrl: 'app/views/userSettings.html',
        controller: 'userCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).config(['$locationProvider', function ($locationProvider) {
  $locationProvider.hashPrefix('');
}]);
