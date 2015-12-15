app.controller('FicheCtrl',function(Collaborateur,Categorie,Encadrant,$filter,$http,$scope){
	
    Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });
	Encadrant.findAll().then(function(d) {
              $scope.encadrants = d;
            });  
	Categorie.findAll().then(function(d) {
              $scope.categories = d;
            });  
    $scope.chargerCollab=function(){
		$http.get("http://localhost:8181/collaborateurs/collab/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.collab=data;
		console.log(data);
		});
		};
	$scope.objectif={} ;
	$scope.objectif.evaluationObjectif=[] ;
	$scope.inserer_feedback = function () {
    	datas=$scope.objectif ;
    	$http({
    	    url: 'http://localhost:8181/feedbacks/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		       window.alert("Objectif inséré !");
				$scope.vider();
				  });
    };
});
