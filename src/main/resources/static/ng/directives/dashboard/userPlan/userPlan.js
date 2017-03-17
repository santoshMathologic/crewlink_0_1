' use strict';

angular
		.module('crewLink_V_1_App')
		.directive(
				'userPlan',
				[
						'$compile',
						function($compile) {
							return {
								restrict : 'E',
								templateUrl : 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
								controller : function($scope, $state, $http,
										$log) {
									
									$scope.isLoading = false;
									$scope.userPlans = [];

									$scope.callServer = new CallServerFetch(
											"api/v1/userPlan/getPlan",
											$http,
											function callBackBefore(responseobj) { // Before processing this is called
												$scope.isLoading = true;
											},
											function callBackAfter(resultObj) { // After processing this is called
												$scope.userPlans  = resultObj;
												$scope.isLoading = false;
											}, function callBackAfterError(
													responseObj) {

											}

									);

								}

							};
						} ]);