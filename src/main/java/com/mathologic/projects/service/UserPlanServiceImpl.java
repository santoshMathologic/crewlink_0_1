package com.mathologic.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathologic.projects.dao.UserPlanDao;
import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.utils.SelectViewModel;

@Service
public class UserPlanServiceImpl implements UserPlanService {

	 @Autowired
	 UserPlanDao dao;
	public UserPlanServiceImpl() {
		}
	@Override
	public SelectViewModel findUserPlan(String username, String password, String sort, Long page, Long size) {
		
		return dao.findUserPlan(username, password, sort, page, size);
	}
	@Override
	public boolean saveUserPlan(UserPlan userPlan) {
		return dao.saveUserPlan(userPlan);
	}

	


	







}
