/**
 * 
 */

(function() {
	'use strict';
	var app = angular.module('crewLink_V_1_App', [ "base64", "ui.router","oc.lazyLoad","angular-loading-bar","ngCookies","flow","angucomplete-alt","toaster","smart-table"
			]);

	app.config([ '$stateProvider', '$urlRouterProvider','$ocLazyLoadProvider','$cookiesProvider',
			function($stateProvider, $urlRouterProvider,$ocLazyLoadProvider,$cookiesProvider) {
				$urlRouterProvider.otherwise('/dashboard/home');
				
				 $ocLazyLoadProvider.config({
				      debug:false,
				      events:true,
				    });
				 
				 
				
				 $stateProvider
		            .state('dashboard', {
		                templateUrl: 'ng/directives/dashboard/dashboard.directive.html',
		                url: '/dashboard',
		                abstract: true,
		                resolve: {
		                    loadMyDirectives: function ($ocLazyLoad) {
		                        return $ocLazyLoad.load({
		                                name: 'crewLink_V_1_App',
		                                files: [
		                                    'ng/directives/dashboard/dashboard.js',
		                                    'ng/directives/header/header.js',
		                                    'ng/directives/sidebar/sidebar.js',
		                                    'ng/directives/header/header-notification/header-notification.js',
		                                    'ng/utils/sidebarDirective.js',
		                                    'ng/directives/services/stateService.js',
		                                    'ng/utils/resolveLoader.js',
		                                    'ng/utils/UserService.js',
		                                    'ng/utils/spinner.js',
		                                    'ng/directives/dashboard/state/state.js',
		                                    'ng/utils/passwordValidator.js'
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
				                                    }),
				                                    $ocLazyLoad.load(
						                                     {
						                                     name:'ui.bootstrap',
						                                     files:[	'bower_components/angular-bootstrap/ui-bootstrap.min.js',
						                                            	'bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js'
						                                           ]
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
		            }).state('dashboard.upload',{
		                templateUrl: 'ng/directives/dashboard/upload/upload.directive.html',
		                url: '/upload',
		                controller:"UploadCtrl",
		                resolve: {
		                    loadMyDirectives: function ($ocLazyLoad) {
		                        return $ocLazyLoad.load(
		                            {
		                                name: 'crewLink_V_1_App',
		                                files: [
		                                    'ng/directives/dashboard/upload/upload.js',
		                                    'ng/controllers/upload.js',
		                                    
		                                ]
		                            });
		                    	}
		               		}
		            }).state('dashboard.trains',{
		                templateUrl: 'ng/directives/dashboard/train/train.directive.html',
		                url: '/trains',
		                resolve: {
		                    loadMyDirectives: function ($ocLazyLoad) {
		                        return $ocLazyLoad.load(
		                            {
		                                name: 'crewLink_V_1_App',
		                                files: [
		                                    'ng/directives/dashboard/train/train.js',
		                                    
		                                ]
		                            });
		                    	}
		               		}
		            }).state('dashboard.user',{
		            	templateUrl:"ng/directives/dashboard/user/user.directive.html",
		            	url:"/user",
		                module: 'public',
		                controller:"UserCtrl",
		            	resolve : {
		            		permission: function() {
		                        //console.log("from User");
		                    },
		            		 loadMyDirectives: function ($ocLazyLoad) {
			                        return $ocLazyLoad.load(
			                            {
			                                name: 'crewLink_V_1_App',
			                                files: [
			                                    'ng/directives/dashboard/user/user.js',
			                                    'ng/controllers/User.js',
			                                    'ng/customDirective/panelDirective.js'
			                                    
			                                ]
			                            });
			                    	}
		            		
		            	}
		            	
		            
		            
		            }).state('dashboard.userPlan',{
		            	templateUrl:"ng/directives/dashboard/userPlan/userPlan.directive.html",
		            	url:"/userPlan",
		                controller:"UserPlanCtrl",
		            	resolve : {
		            		 loadMyDirectives: function ($ocLazyLoad) {
			                        return $ocLazyLoad.load(
			                            {
			                                name: 'crewLink_V_1_App',
			                                files: [
			                                    'ng/directives/dashboard/userPlan/userPlan.js',
			                                    'ng/controllers/userPlan.js'
			                                    
			                                    
			                                ]
			                            });
			                    	}
		            			}
		            		});

			
	
	
	
	
	
	}]);
	
	app.run(['$rootScope','$state','$cookies','$window',function($rootScope,$state,$window,$cookies){

	    $rootScope.stateIsLoading = false;
	    $rootScope.$on('$routeChangeStart', function() {
	        $rootScope.stateIsLoading = true;
	    });
	    $rootScope.$on('$routeChangeSuccess', function() {
	        $rootScope.stateIsLoading = false;
	    });
	    $rootScope.$on('$routeChangeError', function() {
	        //catch error
	    });
	    
	    $rootScope.$on('$stateChangeStart', function(e, toState, toParams, fromState, fromParams) {
	    /* if (toState.module === 'private') {
	            // If logged out and transitioning to a logged in page:
	            e.preventDefault();
	            //$state.go('login');
	        } else if (toState.module === 'public' && !$cookies.Session) {
	            // If logged in and transitioning to a logged out page:
	            e.preventDefault();
	           // $state.go('dashboard.user');
	           // $window.location.href='/';
	        };*/
	    });
	    
	    
	    

	}]);
	
})();
