
angular.module('crewLink_V_1_App').directive(
				"spinner",
				function() {
					return {
						restrict : 'E',
						scope : {
							enable : "=",
							clr : "@", 
							align:'@',
							dimensions: '@',
							type : '@'
							
						},
						template : "<div ng-show='enable' style='text-align: 'align''><i class='fa fa-spinner fa-spin'></i></div>",
						link: function postLink(scope, element, attr) {
							scope.$watch(attr.spinner, function (value) {     
					             element.css('color',scope.clr);
					             element.css('font-size',scope.dimensions +"px")
					             
					           },true); 
								
						   },
						controller:function($scope){
							
						
							
						}
					}
					
				})