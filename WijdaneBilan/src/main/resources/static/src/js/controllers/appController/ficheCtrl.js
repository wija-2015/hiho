app.controller('FicheCtrl',function(Collaborateur,Categorie,Encadrant,$filter,$http,$scope,$window){
	Encadrant.findAll().then(function(d) {
              $scope.encadrants = d;
            }); 
   Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });
	Categorie.findAll().then(function(d) {
              $scope.categories = d;
            }); 
    /* $scope.collabs=[];			
	$scope.chargerManagerCollabs=function(){
		$http.get("http://localhost:8181/managers/collabs/"+$scope.iduse)
		.success(function(data){
		$scope.collabs=data;
		console.log(data);
		});
		}; */
    $scope.chargerCollab=function(){
		$http.get("http://localhost:8181/collaborateurs/collab/"+$scope.objectif.idCollaborateur)
		.success(function(data){
		$scope.collab=data;
		console.log(data);
		});
		};
	$scope.chargerFiche=function(){
		$http.get("http://localhost:8181/objectifs/ficheCollab/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.ficheObjectif=data;
		console.log(data);
		});
		};
	$scope.objectif={} ;
	$scope.objectif.evaluations=[] ;
	$scope.inserer_objectif = function () {
		$scope.objectif.idManager=$window.sessionStorage.idUser;
    	datas=$scope.objectif ;
    	$http({
    	    url: 'http://localhost:8181/objectifs/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		       window.alert("Objectif inséré !");
				$scope.vider();
				  });
    };
	$scope.vider = function () {
		$scope.objectif={} ;
	    $scope.objectif.evaluations=[] ;
	}
});
