' use strict';

angular.module('crewLink_V_1_App').directive('user',
		[ '$compile', function($compile) {
			return {
				restrict : 'E',
				templateUrl : 'ng/directives/dashboard/user/user.tmpl.html',
				controller : function($scope, $state,UserService,$http,toaster) {
					
							$scope.number = 10;	
							//$scope.userdetails = {};
							
							

				}

			};
		} ]);