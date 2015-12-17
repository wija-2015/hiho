app.controller("FeedbackCtrl",function(Collaborateur,Projet,Theme,$scope,$http,$window){
	
    Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });  
    Projet.findAll().then(function(d) {
              $scope.projets = d;
            });
	Theme.findAll().then(function(d) {
              $scope.themes = d;
            });	
  	
	$scope.feedback={} ;
	$scope.feedback.qualification=[] ;
	$scope.qualifs=[{"nomQualification":"Critique","poidsQualification":0,"remarque":""},{"nomQualification":"A développer","poidsQualification":1},
	         {"nomQualification":"Selon Attente","poidsQualification":2},{"nomQualification":"Démontre des Forces","poidsQualification":3}] ;

    $scope.inserer_feedback = function () {
		$scope.feedback.idEncadrant=$window.sessionStorage.idUser;
    	datas=$scope.feedback ;
    	$http({
    	    url: 'http://localhost:8181/feedbacks/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		       window.alert("Feedback inséré !");
				$scope.vider();
				  });
    };
	
	$scope.vider = function () {
		$scope.feedback=null ;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////: get Feedbacks of collab
	//$scope.collabfeedbacks={} ;
	$scope.pageCourante=0;	
	$scope.pages=new Array();
    $scope.getEncadrantFeedbacks=function(){
    $http.get("http://localhost:8181/feedbacks/encadrantFeedbacks/"+$scope.idCollaborateur+"/1/"+$scope.pageCourante)
	   .success(function(data){
	   $scope.collabfeedbacks=data;
	   $scope.pages=new Array(data.totalPages);
	   console.log(data);
	   });
	};
	$scope.gotoPage1=function(page){
      $scope.pageCourante=page;
	  $scope.getEncadrantFeedbacks();
    };
	
    $scope.getAdminFeedbacks=function(){
    $http.get("http://localhost:8181/feedbacks/adminFeedbacks/"+$scope.idCollaborateur+"/"+$scope.pageCourante)
	   .success(function(data){
	   $scope.collabfeedbacks=data;
	   $scope.pages=new Array(data.totalPages);
	   console.log(data);
	   });
	};
	$scope.gotoPage2=function(page){
      $scope.pageCourante=page;
	  $scope.getAdminFeedbacks();
    };
	
	$scope.getManagerFeedbacks=function(){
    $http.get("http://localhost:8181/feedbacks/managerFeedbacks/"+$scope.idCollaborateur+"/"+$scope.pageCourante)
	   .success(function(data){
	   $scope.collabfeedbacks=data;
	   $scope.pages=new Array(data.totalPages);
	   console.log(data);
	   });
	};
	$scope.gotoPage3=function(page){
      $scope.pageCourante=page;
	  $scope.getManagerFeedbacks();
    };
	
	//$scope.collabors=[];
	$scope.getMangerCollabs=function(){
    $scope.idManager=$window.sessionStorage.idUser;
    $http.get("http://localhost:8181/managers/collabs/"+$scope.idManager)
	   .success(function(data){
	   $scope.collabors=data;
	   console.log(data);
	   });
	};

});