(function() {
	' use strict';
	var app = angular.module("crewLink_V_1_App");

	app.directive('state', [ '$compile', function($compile) {
		return {
			restrict : 'E',
			replace : true,
			templateUrl : 'ng/directives/dashboard/state/state.tmpl.html',
			scope : {
				'model' : '=',
				'comments' : '@',
				'number' : '@',
				'name' : '@',
				'colour' : '@',
				'details' : '@',
				'type' : '@',
				'goto' : '@'
			},

			controller : function stateController($scope, $state) {

				console.log("DSDADAS");
				$scope.number = 10;

			}

		};
	}]);

})();
