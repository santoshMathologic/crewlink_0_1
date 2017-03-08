var app = angular.module('crewLink_V_1_App');
app.service('stateService', function() {
	var state = false;
	var setIsState = function(nstate) {
		state = nstate;
	};
	var getIsState = function() {
		return state;
	};
	return {
		setIsState : setIsState,
		getIsState : getIsState
	};
});
