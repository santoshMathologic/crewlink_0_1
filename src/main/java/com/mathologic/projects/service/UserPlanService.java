package com.mathologic.projects.service;


import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.utils.SelectViewModel;


public interface UserPlanService {
	public SelectViewModel findUserPlan(String username, String password, String sort, Long page, Long size);
	public boolean saveUserPlan(UserPlan userPlan);

}
