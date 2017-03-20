/**
 *  Author @santosh 
 *  TimeCalculation for Crewlink Decision Support Support System
 *   
 * 
 */

function cal_differenceBetweenTwoTimes(startTime, startDay, endTime, endDay) {

	/**
	 *    All Variable Calculation
	 * 
	 */
	var totalDuration = 0;
	var Days = ['SUNDAY','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY'];

	dep = startTime.split(':');
	var dH = $.trim(dep[0]);
	var dM = $.trim(dep[1]);

	console.log("" + dH + "" + dM);

	arr = endTime.split(":");
	var aH = $.trim(arr[0]);
	var aM = $.trim(arr[1]);

	console.log("" + aH + " " + aM);

	var depMin = parseInt(dH * 60) + parseInt(dM);
	var arrMin = parseInt(aH * 60) + parseInt(aM);

	var diff_in_Day = startDay - endDay;
	if (diff_in_Day >= 0) {
		totalDuration = diff_in_Day * 24 * 60 + 24 * 60 - depMin + arrMin;
	} else if (diff_in_Day == -1) {
		totalDuration = (arrMin - depMin);
	} else {
		diff_in_Day = Days.length - 1 - startDay + endDay;
		totalDuration = diff_in_Day * 24 * 60 + 24 * 60 - depMin
				+ arrMin;

	}
	

	return totalDuration;

}
/***
 * This function in converted time to Minutes  (Eg : 10:30  like (10*60)+30 =  630)
 * 
 * @param time String
 * @returns
 */

  function timeToMinutes(time){
	  time = time.split(":");
	  return parseInt(time[0])*60+parseInt(time[1]);
  }
  
  function minutesToHours(minutes){
	  
	  var h = Math.floor(minutes / 60);
	  var m = minutes % 60;
	  h = h < 10 ? '0' + h : h;
	  m = m < 10 ? '0' + m : m;
	  return h + ':' + m;
	  
  }