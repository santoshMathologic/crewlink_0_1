'use strict';

angular.module('crewLink_V_1_App').directive('sidebar',
		[ '$location', function() {
			return {
				templateUrl : 'ng/directives/sidebar/sidebar.tmpl.html',
				restrict : 'E',
				replace : true,
				scope : {},
				controller : function($scope, $location,$rootScope,stateService) {
					$scope.selectedMenu = 'dashboard';
					$scope.state = stateService.getIsState();
					    $scope.toggleState = function() {
					        $scope.state = !$scope.state;
					    	
					    };


				}
			}
		}]);
