/* app.controller("CollaborateurCtrl",function(Collaborateur,$scope){
           Collaborateur.findAll().then(function(d) {
    $scope.collaborateurs = d;
  });
    
          }); */

app.controller('ModalInstanceCtrlTheme', ['$scope','$http','$modalInstance', function($scope, $http,$modalInstance) {
  	$scope.theme={} ;
    $scope.inserer_theme = function () {
		 $http.post("http://localhost:8181/themes/save",$scope.theme)
    .success(function(response) {  console.log(response);  console.log(JSON.stringify($scope.theme));  $scope.cancel();});

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

  }])
  ; 

  app.controller('ModalDemoCtrlTheme', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContentThem.html',
        controller: 'ModalInstanceCtrlTheme',
        size: size,
        resolve: {
          items: function () {
            return $scope.items;
          }
        }
      });

      modalInstance.result.then(function (selectedItem) {
        $scope.selected = selectedItem;
      }, function () {
        $log.info('Modal dismissed at: ' + new Date());
      });
    };
  }])
  ; 