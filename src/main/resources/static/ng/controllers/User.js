/**
 * 
 */

var app  = angular.module("crewLink_V_1_App");

app.controller("UserCtrl",function($scope,$timeout, $state,UserService,$http){
	
	console.log("Dasdas");
	
	
	$scope.userList = [];
	UserService.getCurrentUser().then(function(res){
		//console.log(res.data);
	});
	
	$scope.query = {
			username : '',
			password : '',
			sort:'',
			page:'',
			size:10
	}
	
	$scope.text = "abc@gmail.com";
	$scope.isLoading = false;
	$scope.checkActive  = {
			"Active" :true,
			"Deactive" :false
	
	}
	
	
	
	
	$scope.ActiveCheck = function(){
		console.log($scope.selectedActive);
	}
	
	
	$scope.$watch('query', function(newValue, oldValue) {
    if (newValue != oldValue) {
    	$scope.getUser();
    }
     },true);
	 
	

		$scope.getUser = function() {
		$scope.isLoading = true;
		var uri = "/api/v1/user/findByAllParams?username="
				+ $scope.query.username + "&password=" + $scope.query.password

		var userUri = "/api/v1/user/findByAllUserParams?username="
				+ $scope.query.username + "&password=" + $scope.query.password
				+ "&sort=" + $scope.query.sort + "&page=" + $scope.query.page
				+ "&size=" + $scope.query.size
		$http.get(userUri).then(function success(res) {
			$scope.userList = res.data.data;

			$timeout(function(res) {
				$scope.isLoading = false;
			}, 500)

		}, function error(resp) {

		});

	}
		
		
	$scope.getUser();
	
	$scope.getRoles = function(query, timeout){
		return $http.get('/api/v1/role/find?name='+ query);
		
	}
	$scope.selectedRole= function(selected) {
		console.log(selected);
	};
	
	
	$scope.saveUser = function(Userdetails){
		
		console.log("DASdasd"+Userdetails.username);
		
		$http.post("/api/v1/user/saveUser",Userdetails).then(function success(response){
			
			console.log(response);
			
		},function error(response){
			
			
			
		})
		
		
		
	}

	
	
/*
		$scope.getrole = function() {
		var url = "/api/v1/role/findByAllParams";
		$http.get(url).then(function success(res) {
			$scope.roleList = res.data.content;
			$timeout(function(res) {
				$scope.isLoading = false;
			}, 500)

		}, function error(resp) {

		});

	}
	
	$scope.getrole();*/
	
	
	
});

