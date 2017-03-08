/**
 * 
 */

(function(){
	' use strict';
	
	var app = angular.module("crewLink_V_1_App");
	app.provider("UserService", function() {

		var pro = {};
		var sideToggleBar = true;
		pro.$get = function($http, $q) {
			var service = {};
			service.getCurrentUser = function() {

				return $q(function(resolve, reject) {
					$http.get("/api/v1/currentUser/currentUserDetails").then(
							function successResponse(resp) {
								resolve(resp);

							}, function errorResponse(resp) {
								reject(resp);
							})

				});

			}

			return service;
			console.log("DASdas");
		}

		return pro;

	})



})();



