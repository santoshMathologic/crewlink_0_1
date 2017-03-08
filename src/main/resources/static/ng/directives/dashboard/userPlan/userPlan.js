' use strict';

angular.module('crewLink_V_1_App')
    .directive('userPlan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
            controller: function($scope, $state) {
            	
            	$scope.userPlans = [
            	                    {
            	                    	"name":"Plan004"
            	                    		
            	                    	
            	                    },{
            	                    	"name":"Plan004"
            	                    },
            	                    {
            	                    	"name":"Plan004"
            	                    },
            	                    {
            	                    	"name":"Plan004"
            	                    }
            	                    
            	                    
            	                    ]

              
                
            }

        };
    }]);