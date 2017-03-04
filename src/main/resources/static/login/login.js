'use strict';

angular.module('crewLink_V_1_App')
    .controller('loginCtrl', function($scope,$http, $base64,$window) {
        $scope.login = function(username, password){
            $http({
                method:'GET',
                url:'/',
                headers:{
                     'Authorization':'Basic '+ $base64.encode(username+":"+password)

                }
            }).then(function successCallback(response) {
                $window.location.href='/';
            }, function errorCallback(response) {
                alert("User not authorized.");
            });
        };
    });
/**
 * 
 */