package com.mathologic.projects.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.models.Role;
import com.mathologic.projects.models.User;
import com.mathologic.projects.repository.RoleRepository;
import com.mathologic.projects.repository.UserRepository;
import com.mathologic.projects.service.UserService;
import com.mathologic.projects.utils.SelectViewModel;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService manager;
	@Autowired
	RoleRepository roleRepository;
	
	public UserController() {
	}
	
/*	@RequestMapping(value="/findByAllParams", method = RequestMethod.GET )
	public Page<User> findByAllParams(
			@PathParam("username")String username,
			@PathParam("password")String password
			) 
	{
		
		manager.findUser(username,password);
		// return userRepository.findByUsernameOrMobileNo(username,mobNo, createPageRequest());
		return userRepository.findByAllUserParams(username,password,createPageRequest());
	}*/
	private Pageable createPageRequest() {
	    return new PageRequest(0, 10, Sort.Direction.ASC, "username");
	}
	
	@RequestMapping(value="/findByAllUserParams", method = RequestMethod.GET )
	public SelectViewModel findByAllUserParams(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "page", required = false, defaultValue = "0") Long page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Long size)
			
		{
		
		
		return  manager.findUser(username,password,sort,page,size);
	   }
	

	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public @ResponseBody String saveUser(@RequestBody User user){
		
		if(user!=null){
			
			String rolename = user.getRole().getName();
			Role r = roleRepository.findByNameContains(rolename);
			user.setRole(r);
			
			//userRepository.save(user);
			manager.saveUser(user);
			return "User save Successfully";
		}
	   
	   
		
		
	   return "Not User save successfully";
	   
   }


}
