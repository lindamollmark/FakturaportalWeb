angular.module('springBootClientApp')
  .controller('newClientCtrl', function($scope, clientService, $location) {
    var client = {};
    var exsist = false;
    $scope.buttonSave = false;

    $scope.save = function(){
      clientService.save($scope.client).then(function(response){
        var saved = response.data;
        var clientID = saved.id;
        var path = "/clientView" + clientID;
        $location.path(path);
      });


      //TODO return to clientList och the client!
    };

    $scope.checkClientNo = function() {
      clientService.checkClientNo($scope.client.clientNo).then(function (response) {
        $scope.exsist = (response.data);
      });
    }
  });
