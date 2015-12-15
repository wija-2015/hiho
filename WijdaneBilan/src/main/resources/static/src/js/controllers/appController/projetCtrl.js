/* app.controller("ProjetCtrl",function(Projet,$scope){
           Projet.findAll().then(function(d) {
    $scope.projets = d;
  });
    
          }); */

app.controller('ModalInstanceCtrlProjet', ['$scope','$http','$modalInstance', function($scope, $http,$modalInstance) {
  	$scope.projet={} ;
    $scope.inserer_projet = function () {
		 $http.post("http://localhost:8181/projets/save",$scope.projet)
    .success(function(response) {  
	        console.log(response);
			console.log(JSON.stringify($scope.projet));
			$scope.cancel();});

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
  }])
  ; 

  app.controller('ModalDemoCtrlProjet', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContentProj.html',
        controller: 'ModalInstanceCtrlProjet',
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