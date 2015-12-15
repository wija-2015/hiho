app.controller("logout",['$scope','$window',function($scope,$window){
	$scope.logout = function() {
          $window.sessionStorage.clear();
          $location.path("login");
        });
    };
	
	
})