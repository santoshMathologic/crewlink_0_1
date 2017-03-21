/**
 * 
 */

var app = angular.module('crewLink_V_1_App');		

app.service("timeCalculationService",function(){
	
	var Days = ["SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"];
	
	var calculateDifferenceBetweenTwoTimes = function(startTime, startDay, endTime, endDay){
		
		var tDuration = 0;
		var dDay;
		var sTime 		= startTime.split(":");
		var sHr 		= $.trim(sTime[0]); // regular Expresssion for Trim String the startTime
		var sMin 		= $.trim(sTime[1]);// regular Expresssion for Trim String the startTime
		

		var eTime  		= endTime.split(":");
		var eHr 		= $.trim(eTime[0]); // regular Expresssion for Trim String the endTime
		var eMin 		= $.trim(eTime[1]);// regular Expresssion for Trim String the endTime
		
		
		var arrivalTime  	= parseInt(sHr * 60)+ parseInt(sMin);
		var departureTime  	= parseInt(eHr * 60)+ parseInt(eMin);
				
		dDay =  startDay - endDay - 1;
		
		  if(dDay >= 0){
			  tDuration = dDay * 24 * 60 + 24 * 60 - departureTime
				+ arrivalTime;
			  
		  }else if(dDay == -1){
			  tDuration = (arrivalTime - departureTime);
		  }else{
			  dDay = Days.length - 1 - startDay + endDay;
			  tDuration = dDay * 24 * 60 + 24 * 60 - departureTime + arrivalTime;
		  }
		
		return tDuration;
		
	};
	
	var timeToMinutes = function(time){
		  time = time.split(":");
		  return parseInt(time[0])*60+parseInt(time[1]);
	  };
	  
	  var MinutesToHoursAndMinutes = function(minutes){
		  
		  var hr = Math.floor(minutes / 60);
		  var m = minutes % 60;
		  hr = hr < 10 ? '0' + hr : hr;
		  m = m < 10 ? '0' + m : m;
		  return hr + ':' + m;
		  
		  
	  };
	  
	  var currentDateAndTime = function(){
		  var tDay = new Date();
		  return tDay.getFullYear()+ "/" +(tDay.getMonth()+1)+ "/" +tDay.getDate();
	  };
	  
	  var hourAndMinutesToSeconds = function(time){
		  var seconds = new Date('1970-01-01T' + time + 'Z').getTime() / 1000;
		  return seconds;
	  }
	  var diff_two_times = function (time1,day1,time2,day2){
		    var r = 0;
			time1 = timeToMinutes(time1);
		    time2 = timeToMinutes(time2);

		    if(day1 == day2){
		        if(time1 < time2){
		            r = time2-time1;
		        }else if(time1 > time2){
		            r = 6*24*60+time2+(24*60-time1);
		        }else{
		            r = 0;
		        }
		    }else if(day2>day1){
		        r = (day2-day1-1)*24*60+(24*60-time1)+time2;
		    }else{
		        r = (6-day1+day2)*24*60+(24*60-time1)+time2;
		    }
		    return r;
		}

	  
	
	return {
		timeToMinutes : timeToMinutes,
		MinutesToHoursAndMinutes : MinutesToHoursAndMinutes,
		currentDateAndTime : currentDateAndTime,
		hourAndMinutesToSeconds : hourAndMinutesToSeconds,
		diff_two_times : diff_two_times,
		calculateDifferenceBetweenTwoTimes : calculateDifferenceBetweenTwoTimes
	}
			
			
});
