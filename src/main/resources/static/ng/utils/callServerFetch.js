
/**
 *  ServerTable Fetch 
 *  Author : @santosh     
 *     
 */

var CallServerFetch = function(url,httpProvider,callBackBefore,callBackAfter,callBackAfterError){
	
	this.baseUrl = url;
	this.callBackBefore = callBackBefore;
	this.callBackAfter = callBackAfter;
	this.httpProvider = httpProvider;
	this.callBackAfterError = callBackAfterError;
	
	this.processFetch = function(tableState){
		this.callBackBefore("CAllBACK BEFORE");
		
		if(angular.isFunction(this.baseUrl)){
			this.baseUrl = url(tableState);
		} 
		
		if(this.baseUrl == ''){
			this.callBackAfterError("no Fetch");
			return;
		}
		var pagination = tableState.pagination;
		var page = (pagination.start/pagination.number) || 0;     
		var size = pagination.number || 10;  											
		var sort = (tableState.sort.predicate)?tableState.sort.predicate:"";
		var sortDir = (tableState.sort.reverse)?"asc":"desc";
		var searchParams = "";
		
		
	
		httpProvider.get(this.baseUrl).then(function successFunction(response){
			
			this.callBackAfter(response);
			
		}.bind(this),
		function errorResponse(response){
			
			this.callBackAfterError("jjjjjjjjj");
		
		}.bind(this));
		
		
	}.bind(this); // End of ProcessFetch
		
}