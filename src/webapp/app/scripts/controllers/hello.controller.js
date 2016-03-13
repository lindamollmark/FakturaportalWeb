/**
 * Created by Linda on 2016-03-11.
 */
(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.controllers.hello', [])
    .controller('HelloController', HelpController);

  HelpController.$inject = ['RestService'];

  function HelpController(RestService) {
    /* jshint validthis: true */
    var self = this;

    self.name = 'ett namn';
    self.sayHello = sayHello;
    var privateAPI = {};


    function sayHello(){
      alert('hey ' + self.name);
      RestService.sayHello(self.name).then(function(data){
        self.name = angular.fromJson(data).simpleRespond;
        alert('and now we have been to the server:' + angular.fromJson(data).simpleRespond);
      });
    }



    //    aktService.hamtaAkt(id).then(function (data) {
    //    $scope.akt = modifieraAktData(data);
    //});
  }
})();
