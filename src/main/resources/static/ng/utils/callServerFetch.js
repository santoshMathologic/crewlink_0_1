
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
		
		  if(this.baseUrl.indexOf("?")==-1){
			  searchParams = "?";
		  }
		  
		  if(tableState.search.predicateObject){
			  for(searchItem in tableState.search.predicateObject){
				  var re = new RegExp(searchItem+"=(\w+)","g");
					if(searchParams.search(re)!=-1){
						searchParams = searchParams.replace(re, searchItem+'='+tableState.search.predicateObject[searchItem]+'&');
					}else{
						searchParams += searchItem+"=" +tableState.search.predicateObject[searchItem]+"&";
					}
				}
				  
		  }
		
		  var 	call = this.baseUrl + searchParams;
		  		call = call.concat('page='+page+'&');
		  		call = call.concat('limit='+size);
	
		httpProvider.get(call).then(function successFunction(response){
			  var resultObj = response.data.content
			  tableState.pagination.numberOfPages = response.data.totalPages;
			  resultObj.tableState = tableState;
			  this.callBackAfter(resultObj);
			
		}.bind(this),
		function errorResponse(response){
			
			this.callBackAfterError("From CallBackAfter"+response);
		
		}.bind(this));
		
		
	}.bind(this); // End of ProcessFetch
		
}