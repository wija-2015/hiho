app.controller("adminCtrl",function(Collaborateur,$rootScope,$scope,$http,$state,$window){
	
	Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            }); 
   
        $scope.login=function(){
               $http.post("http://localhost:8181/admins/signin",$scope.admin)
               .success(function(response){
              	 if(response!=0)
              		 {
              		$rootScope.authentication=true ;
               		$window.sessionStorage.idUser=response ;
               		$rootScope.isAdmin=true ;
              		 $state.go('app.dashboard-v1');
              		 console.log(response) ;
           
              		 }
              	 else {
              		$rootScope.authentication=false ;
              	
              		 $scope.message="identifiants incorrectes" ;
              		 console.log(response) ;
              	 }
              	 })
                 };
		
		//$scope.collabs=[];			
	    $scope.chargerManagerCollabs=function(){
	     	$http.get("http://localhost:8181/managers/collabs/"+$scope.idManager)
	  	    .success(function(data){
		    $scope.collabs=data;
		    console.log(data);
		});
		};
		$scope.idCollaborateur=null;
		$scope.chargerFicheObjectifs=function(){
		$http.get("http://localhost:8181/objectifs/ficheCollab/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.ficheObjectifs=data;
		console.log(data);
		});
		};
    
          });

