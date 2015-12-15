app.factory('Manager', function($http) {
  var promise;
  var Manager = {
    findAll: function() {
      if ( !promise ) {
	     // $http.get(...) : c'est une promesse
		//valeur de retour promise (on peut metre .then apres ) 
		//la fct dans .then() représente le callback du succés
		// .then() permet d’appeler des callbacks de succès ou d’erreur , sa signature :then(successCallback, errorCallback, notifyCallback)
        promise = $http.get("http://localhost:8181/managers/findAll").then(function (response) {
          // Test Console
          console.log(response);
          // la valeur de retour sera reccuperé par le controller a travers Then()
          return response.data;
        });
      }
      // Retourner la Promise
      return promise;
    }
  };
  return Manager;
});