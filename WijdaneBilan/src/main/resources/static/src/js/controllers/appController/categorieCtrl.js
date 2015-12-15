/* app.controller("CollaborateurCtrl",function(Collaborateur,$scope){
           Collaborateur.findAll().then(function(d) {
    $scope.collaborateurs = d;
  });
    
          }); */

app.controller('ModalInstanceCtrlCategorie', ['$scope','$http','$modalInstance', function($scope, $http,$modalInstance) {
  	$scope.categorie={} ;
    $scope.inserer_categorie = function () {
		 $http.post("http://localhost:8181/categories/save",$scope.categorie)
    .success(function(response) {  console.log(response);   console.log(JSON.stringify($scope.categorie));   $scope.cancel();});

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

  }])
  ; 

  app.controller('ModalDemoCtrlCategorie', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContentCat.html',
        controller: 'ModalInstanceCtrlCategorie',
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