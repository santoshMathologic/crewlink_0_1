' use strict';

angular.module('crewLink_V_1_App').directive('train',
		[ '$compile', function($compile) {
			return {
				restrict : 'E',
				templateUrl : 'ng/directives/dashboard/train/train.tmpl.html',
				controller : function($scope, $state) {

					$scope.trainlist = [ 
					                     {
						trainNo : "11014",
						trainName : "XYZ EXP",
						from:"SBC",
						to:"SBC"

					},					                     {
						trainNo : "11014",
						trainName : "XYZ EXP",

					}
					 ]

				}

			};
		} ]);