/**
 * 
 */

(function() {
	'use strict';
	var app = angular.module('crewLink_V_1_App', [ "base64", "ui.router","oc.lazyLoad"
			]);

	app.config([ '$stateProvider', '$urlRouterProvider','$ocLazyLoadProvider',
			function($stateProvider, $urlRouterProvider,$ocLazyLoadProvider) {
				$urlRouterProvider.otherwise('/dashboard/home');
				
				 $ocLazyLoadProvider.config({
				      debug:false,
				      events:true,
				    });
				
				 $stateProvider
		            .state('dashboard', {
		                templateUrl: 'ng/directives/dashboard/dashboard.directive.html',
		                url: '/dashboard',
		                resolve: {
		                    loadMyDirectives: function ($ocLazyLoad) {
		                        return $ocLazyLoad.load({
		                                name: 'crewLink_V_1_App',
		                                files: [
		                                    'ng/directives/dashboard/dashboard.js'
		                                ]
		                            }),
		                            $ocLazyLoad.load(
		                                    {
		                                      name:'ngAnimate',
		                                      files:['bower_components/angular-animate/angular-animate.js']
		                                    }),
		                             $ocLazyLoad.load(
		                                           {
		                                              name:'ngCookies',
		                                              files:['bower_components/angular-cookies/angular-cookies.js']
		                                            }),
		                              $ocLazyLoad.load(
		                                     {
		                                     name:'ngResource',
		                                     files:['bower_components/angular-resource/angular-resource.js']
		                                    }),
		                                    $ocLazyLoad.load(
				                                     {
				                                     name:'ngSanitize',
				                                     files:['bower_components/angular-sanitize/angular-sanitize.js']
				                                    })
		                                    
		                          
		                    }
		                }
		            }).state('dashboard.home',{
		                templateUrl: 'ng/directives/home/home.directive.html',
		                url: '/home',
		                resolve: {
		                    loadMyDirectives: function ($ocLazyLoad) {
		                        return $ocLazyLoad.load(
		                            {
		                                name: 'crewLink_V_1_App',
		                                files: [
		                                    'ng/directives/home/home.js',
		                                    
		                                ]
		                            });
		                    	}
		               		}
		            });

			
	
	
	
	
	
	}]);

})();

/*app.run(function($rootScope) {
 $rootScope.someData = {
 message : "hello"
 };
 });*/