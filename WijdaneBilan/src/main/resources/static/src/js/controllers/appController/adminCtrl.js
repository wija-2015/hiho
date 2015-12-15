app.controller("adminCtrl",function($rootScope,$scope,$http,$state,$window){
   
           $scope.login=function(){
               $http.post("http://localhost:8181/admins/signin",$scope.admin)
               .success(function(response){
              	 if(response!=0)
              		 {
              		$rootScope.authentication=true ;
               		$window.sessionStorage.idUser=response ;
              		 $state.go('app.dashboard-v1');
              		 console.log(response) ;
           
              		 }
              	 else {
              		$rootScope.authentication=false ;
              	
              		 $scope.message="identifiants incorrectes" ;
              		 console.log(response) ;
              	 }
              	 })
                 }
         
    
          });

