(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.auth', [])
    .factory('authService', authService);

  authService.$inject = ['$http'];

  function authService($http) {
  var authService = {
    login:login
  };

    return authService;
    function login(credentials){
    return $http({method: 'POST', url:'/views/login', data: credentials});
     };

  //authService.isAuthenticated = function () {
  //  return !!Session.userId;
  //};
  //
  //authService.isAuthorized = function (authorizedRoles) {
  //  if (!angular.isArray(authorizedRoles)) {
  //    authorizedRoles = [authorizedRoles];
  //  }
  //  return (authService.isAuthenticated() &&
  //  authorizedRoles.indexOf(Session.userRole) !== -1);
  //};


}

})();
