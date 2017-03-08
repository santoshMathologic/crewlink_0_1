/* global angular */
(function() {

var app = angular.module('crewLink_V_1_App');

app.controller('SidebarController', function($scope) {

   
});

app.directive('sidebarDirective', function($timeout) {
    return {
        link : function(scope, element, attr) {
            scope.$watch(attr.sidebarDirective, function(newVal,oldVal) {
                  if(newVal)
                  {
                	angular.element(document.querySelector('[id="page-wrapper"]')).addClass('page-wrapper-no-margin animate-hide');
                	angular.element(document.querySelector('[id="wrapper"]')).addClass('no-wrapper animate-hide');
                	angular.element(document.querySelector('[id="toggleSideBar"]')).addClass('hide-show-sidebar animate-hide');
                    return;
                  }
                  if(newVal!=oldVal){
                	  
                  }
                  if(!newVal){
                	  element.removeClass('page-wrapper-no-margin');
                      angular.element(document.querySelector('[id="page-wrapper"]')).removeClass('page-wrapper-no-margin animate-hide');
                      angular.element(document.querySelector('[id="wrapper"]')).removeClass('no-wrapper animate-hide');
                      angular.element(document.querySelector('[id="toggleSideBar"]')).removeClass('hide-show-sidebar animate-hide');  

                  }
                  
                  $timeout( function(){ 
                	                  	  
                  }, 3000);
                                    
            });
        }
    };
});  


}())