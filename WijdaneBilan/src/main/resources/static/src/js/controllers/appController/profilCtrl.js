app.controller('ProfilCtrl',function(Profil,$scope){
           Profil.findAll().then(function(d) {
    $scope.profils = d;
  });
    
          });

app.controller('ModalInstanceCtrlProfil', ['$scope','$http','$modalInstance', function($scope, $http,$modalInstance) {
  	$scope.profil={} ;
    $scope.inserer_profil = function () {
		 $http.post("http://localhost:8181/profils/save",$scope.profil)
    .success(function(response) {  
	      console.log(response);
		  console.log(JSON.stringify($scope.profil));
		  $scope.cancel();});

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

  }])
  ; 

  app.controller('ModalDemoCtrlProfil', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContentProf.html',
        controller: 'ModalInstanceCtrlProfil',
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