app.controller("EncadrantCtrl",function(Encadrant,$scope,$http,$rootScope,$state,$window){
           Encadrant.findAll().then(function(d) {
    $scope.encadrants = d;
  });
           $scope.login=function(){
               $http.post("http://localhost:8181/encadrants/signin",$scope.encadrant)
               .success(function(response){
              	 if(response!=0)
              		 {
              		$rootScope.authentication=true ;
               		$window.sessionStorage.idUser=response ;
               		$rootScope.isEncadrant=true ;
              		$state.go('app.dashboard-v1');
              		console.log(response) ;
              		 }
              	 else {
              		$rootScope.authentication=false ;
              		//AuthenticationService.isAuthenticated=false ;
              		 $scope.message="identifiants incorrectes" ;
              		 console.log(response) ;
              	 }
              	 })
                 }
    $scope.modifier=function(SelectedEncadrant){
              	$http({
              	    url: 'http://localhost:8181/encadrants/update/'+SelectedEncadrant.idEncadrant,
              	    method: 'PUT',
              	    data:SelectedEncadrant
              	})
              	.success(function(response) {  
          		          console.log(response);
          				  console.log(JSON.stringify($scope.encadrant));
          				  window.alert("Encadrant modifié !");
          				  });
           };
    
          });
	
app.controller('ModalInstanceCtrlEncadrant', ['$scope','$http','$modalInstance','Profil', function($scope, $http,$modalInstance,Profil) {
  	$scope.encadrant={} ;
	
	Profil.findAll().then(function(d){
		$scope.profils=d;
	});
	
    $scope.inserer_encadrant = function () {
		 $http.post("http://localhost:8181/encadrants/save",$scope.encadrant)
    .success(function(response) {  console.log(response);   console.log(JSON.stringify($scope.encadrant));   $scope.cancel();});

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

  app.controller('ModalDemoCtrlEncadrant', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrlEncadrant',
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