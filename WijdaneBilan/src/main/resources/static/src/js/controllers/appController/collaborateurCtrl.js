app.controller("CollaborateurCtrl",function(Collaborateur,Manager,$scope,$rootScope,$http,$window,$state){
	
           Collaborateur.findAll().then(function(d) {
             $scope.collaborateurs = d;
           });
           $scope.login=function(){
               $http.post("http://localhost:8181/collaborateurs/signin",$scope.collaborateur)
               .success(function(response){
              	 if(response!=0)
              		 {
              		$rootScope.authentication=true ;
               		$window.sessionStorage.idUser=response ;
               		$rootScope.isCollab=true ;
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
           $scope.modifier=function(SelectedCollab){
              	$http({
              	    url: 'http://localhost:8181/collaborateurs/update/'+SelectedCollab.idCollaborateur,
              	    method: 'PUT',
              	    data:SelectedCollab
              	})
              	.success(function(response) {  
          		          console.log(response);
          				  console.log(JSON.stringify($scope.collaborateur));
          				  window.alert("Collaborateur modifié !");
          				  });
           };
          });

app.controller('ModalInstanceCtrlCollab', ['$scope','$http','$modalInstance','Manager', function($scope, $http,$modalInstance,Manager) {
  	$scope.collaborateur={} ;
	
    Manager.findAll().then(function(d) {
	    $scope.managers = d;
	  });
	  
    $scope.inserer_collab = function () {
    	//var params = $scope.collaborateur.Managerrh.idManagerrh ;
    	datas=$scope.collaborateur
		//$http.post("http://localhost:8181/collaborateurs/save",$scope.collaborateur)
    	$http({
    	    url: 'http://localhost:8181/collaborateurs/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		          console.log(response);
				  console.log(JSON.stringify($scope.collaborateur));				  
				  $scope.cancel();
			
				  });

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

  }])
  ; 

  app.controller('ModalDemoCtrlCollab', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrlCollab',
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
  app.controller("logoutCtrl",['$scope','$window','$location','AuthenticationService','$rootScope',function($scope,$window,$location,AuthenticationService,$rootScope){
		$scope.logout = function() {
    		AuthenticationService.isAuthenticated=false ;
    		$rootScope.authentication=false  ;
	          $window.sessionStorage.clear();
	          $rootScope.isEncadrant=false ;
	          $rootScope.isAdmin=false ;
	          $rootScope.isManager=false ;
	          $rootScope.isCollab=false ;
	          $location.path("/access/administrateur");
	          }
	        }]);