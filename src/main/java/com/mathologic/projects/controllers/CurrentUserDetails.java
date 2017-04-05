package com.mathologic.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.repository.UserRepository;



@RestController
@RequestMapping("/api/v1/currentUser")
public class CurrentUserDetails {

	 @Autowired
	 UserRepository userRepository;
	public CurrentUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/currentUserDetails",method = RequestMethod.GET)
	public @ResponseBody com.mathologic.projects.models.User getCurrentUserDetails(){
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails!=null) {
			com.mathologic.projects.models.User dbUser = userRepository.findByUsername(userDetails.getUsername());
    		if(dbUser!=null) {
    			return dbUser;		
    		}
		}
		
		return null;
	}

}
