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
										$log,timeCalculationService) {
									
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
									
									//var g = timeCalculationService.diff_two_times("10:00",1,"12:45",1);
									var g = timeCalculationService.calculateDifferenceBetweenTwoTimes("14:00",1,"16:45",2);
									
									console.log(g);
								}

							};
						} ]);