package com.mathologic.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.repository.UserPlanRepository;
import com.mathologic.projects.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/userPlan")
public class UserPlanController {
	
	
	@Autowired
	UserPlanRepository userPlanRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public UserPlanController() {
	}

	@RequestMapping(value = "/createPlan", method = RequestMethod.POST)
	public String createPlan(@RequestBody UserPlan userPlan) {
		com.mathologic.projects.models.User dbUser  = null;
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails!=null) {
			dbUser = userRepository.findByUsername(userDetails.getUsername());
			
		}
	
		
		if (userPlan != null) {
			//userPlan.setCreatedOn(new Date());
			userPlan.setUser(dbUser);
			userPlanRepository.save(userPlan);
		}
		return "Plan created Successfully";
	}

	@RequestMapping(value = "/getPlan", method = RequestMethod.GET)
	public Page<UserPlan> findByAllParams(
			@RequestParam(value = "planname", required = false)String planname,
			@RequestParam(value = "limit", required = true)int limit,
			@RequestParam(value = "page", required = true)int page,
			@RequestParam(value = "order", required = false)String order
			) {
		
		 Page<UserPlan> userPlanList = userPlanRepository.findByAllUserPlanParams(planname, createPageRequest(page,limit,order));
		 return userPlanList;
		
	}
	private Pageable createPageRequest(int page,int limit,String order) {
	    return new PageRequest(page, limit, Sort.Direction.ASC,"planName");
	}
}
