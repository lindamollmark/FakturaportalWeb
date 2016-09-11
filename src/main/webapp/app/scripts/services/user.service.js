(function () {
  'use strict';
  //TODO why cant i remove []??
  angular
    .module('springBootClientApp.services.user', [])
    .factory('userService', userService);

  userService.$inject = ['$http'];
  function userService($http){

    var service = {
      fetchUser: fetchUser,
      save: save,
      remove: remove,
      updateUser: updateUser,
      checkUsername: checkUsername
    };

    return service;

    function fetchUser(user){
      return $http({method: 'POST', url:'http://localhost:8080/views/fetchUser', data: user});
    };

    function save(theUser){
      return $http({method: 'POST', url:'http://localhost:8080/views/newUser', data: theUser});
    };

    function remove(theUser){
      return $http({method: 'POST', url:'http://localhost:8080/views/deleteUser', data: theUser});
    };

    function  updateUser(theUser){
      return $http({method: 'POST', url:'http://localhost:8080/views/updateUser', data: theUser});
    };

    function checkUsername(username){
      return $http({method: 'POST', url:'http://localhost:8080/views/username', data: username});
    };
  }
})();
