app.controller("ManagerCtrl",function(Manager,$rootScope,$scope,$http,$state,$window){
           Manager.findAll().then(function(d) {
    $scope.managers = d;
  });
  $scope.iduse=$window.sessionStorage.idUser;
           $scope.login=function(){			   
               $http.post("http://localhost:8181/managers/signin",$scope.manager)
               .success(function(response){
              	 if(response!=0)
              		 {
              		$rootScope.authentication=true ;
              		$rootScope.isManager=true ;
               		 $window.sessionStorage.idUser=response ;
              		 $state.go('app.ajouterFicheObjectifs');
                     console.log(response) ;
              		 }
              	 else {
              		$rootScope.authentication=false ;             	     
              		 $scope.message="identifiants incorrectes" ;              		 
              	 }
              	 })
                 };
		
		$scope.modifier=function(SelectedManager){
              	$http({
              	    url: 'http://localhost:8181/managers/update/'+SelectedManager.idManagerrh,
              	    method: 'PUT',
              	    data:SelectedManager
              	})
              	.success(function(response) {  
          		          console.log(response);
          				  window.alert("Manager RH modifié !");
          				  });
           };
          });

app.controller('ModalInstanceCtrlManager', ['$scope','$http','$modalInstance', function($scope, $http,$modalInstance) {
  	$scope.manager={} ;
    $scope.inserer_manager = function () {
		 $http.post("http://localhost:8181/managers/save",$scope.manager)
    .success(function(response) {  console.log(response);   console.log(JSON.stringify($scope.manager));   $scope.cancel();});

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

  app.controller('ModalDemoCtrlManager', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrlManager',
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