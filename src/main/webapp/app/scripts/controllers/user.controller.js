'use strict';
/**
 * @ngdoc function
 * @name springBootClientApp.controller:userCtrl
 * @description
 * # userCtrl helps with the functions regarding a user.
 * Controller of the springBootClientApp
 */
angular.module('springBootClientApp')
  .controller('userCtrl', function ($scope, $rootScope, userService, Upload, $timeout) {
    userService.fetchUser($rootScope.currentUser).then(function(response){
      $scope.user = angular.fromJson(response.data);
    });
    $scope.save = function(){
      userService.updateUser($scope.user).then(function(response){
        var saved = response.data;
        var userId = saved.id;
        $scope.updateMessage = "Användarinformation uppdaterad";
      });
    };
    $scope.uploadFiles = function (file, errFiles) {
      $scope.f = file;
      userService.saveLogo(file);
      $scope.errFile = errFiles && errFiles[0];
      if (file) {
        file.upload = Upload.upload({
          url: 'https://angular-file-upload-cors-srv.appspot.com/upload',
          data: {file: file}
        });

        file.upload.then(function (response) {
          $timeout(function () {
            file.result = response.data;
          });
        }, function (response) {
          if (response.status > 0)
            $scope.errorMsg = response.status + ': ' + response.data;
        }, function (evt) {
          file.progress = Math.min(100, parseInt(100.0 *
            evt.loaded / evt.total));
        });
      }
    }
  });


