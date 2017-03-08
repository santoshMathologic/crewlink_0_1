' use strict';

angular.module('crewLink_V_1_App')
    .directive('blank', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/blank/blank.tmpl.html',
            controller: function($scope, $state) {

              
                
            }

        };
    }]);