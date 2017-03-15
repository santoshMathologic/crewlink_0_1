' use strict';

angular.module('crewLink_V_1_App')
    .directive('userPlan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
            controller: function($scope, $state,$http,$log) {
            	
            	$scope.query = {
            			limit:10,
            			page:0,
            			order:"planName",
            			planname : ""
            			
            	}
            	
            	$scope.$watch('query',function(newVal,oldVal){
            		if(newVal!=oldVal){
            		}
            		$scope.getUserPlan();
            	},true);
            	
            	$scope.getUserPlan = function(){
            		var url = "api/v1/userPlan/getPlan"
            		$http.get(url,{params:$scope.query}).then(function success(res){
            			$scope.userPlans   =  res.data.content;
            			
            		},function error(res){
            			
            		})	
            		
            	}
            	$scope.getUserPlan();
            	

              
                
            }

        };
    }]);