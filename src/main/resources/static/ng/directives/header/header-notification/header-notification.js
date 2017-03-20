'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('crewLink_V_1_App')
	.directive('headerNotification',function(){
		return {
	        templateUrl:'ng/directives/header/header-notification/header-notification.tmpl.html',
	        restrict: 'E',
	        replace: true,
	        scope :{
	        	color:'@'
	        	
	        },
	        link:function(scope,element,attrs){
	        	scope.$watch(attrs.headerNotification, function (newVal) {
	        		element.css('color',scope.color);
	        		//element.css('border',"1px solid grey")
	        	},true);
	        	
	        },
	        controller:function($scope,$http,$window,$cookies){
	        	$scope.userName = "ADMIN";
            
	        	$scope.logout = function(){
	        	
	        		$http.get('/logout').then(function(response){
	        			$window.location.href="/login/login.html";
	        		});
	        	}
	        }
    	}
	});


