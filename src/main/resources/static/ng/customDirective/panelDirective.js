/**
 * 
 */

(function() {

	' use strict';
	angular.module('crewLink_V_1_App').directive('panelState', function() {
		return {
			templateUrl : "ng/customDirective/panelDirective.tmpl.html",
			restrict : 'E',
			replace : true,
			transclude: true,
			scope : {
				'colour' : '@',
				'details' : '@'
				
			}

		}
	});

	console.log("rerer");

})();