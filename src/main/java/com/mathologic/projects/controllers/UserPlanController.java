package com.mathologic.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.repository.UserPlanRepository;

@RestController
@RequestMapping("/api/v1/userPlan")
public class UserPlanController {
	@Autowired
	UserPlanRepository userPlanRepository;
	
	public UserPlanController() {
	}

	@RequestMapping(value = "/createPlan", method = RequestMethod.POST)
	public String createPlan(@RequestBody UserPlan userPlan) {
		if (userPlan != null) {
			userPlanRepository.save(userPlan);
		}
		return "Plan created Successfully";
	}

	@RequestMapping(value = "/getPlan", method = RequestMethod.GET)
	public Page<UserPlan> findByAllParams(
			@RequestParam(value = "planname", required = true)String planname,
			@RequestParam(value = "limit", required = true)int limit,
			@RequestParam(value = "page", required = true)int page,
			@RequestParam(value = "order", required = false)String order
			) {
		
		 Page<UserPlan> userPlanList = userPlanRepository.findByAllUserPlanParams(planname, createPageRequest());
		 return userPlanList;
		
	}
	private Pageable createPageRequest() {
	    return new PageRequest(0, 10, Sort.Direction.ASC, "planName");
	}
}
