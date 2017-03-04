package com.mathologic.projects.controllers;


import javax.websocket.server.PathParam;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.models.User;
import com.mathologic.projects.repository.UserRepository;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	public UserController() {
	}
	
	@RequestMapping(value="/findByAllParams", method = RequestMethod.GET )
	public Page<User> findByAllParams(
			@PathParam("username")String username,
			@PathParam("password")String password
			) 
	{
		
		// return userRepository.findByUsernameOrMobileNo(username,mobNo, createPageRequest());
		return userRepository.findByAllUserParams(username,password,createPageRequest());
	}
	private Pageable createPageRequest() {
	    return new PageRequest(0, 10, Sort.Direction.ASC, "username");
	}


}
