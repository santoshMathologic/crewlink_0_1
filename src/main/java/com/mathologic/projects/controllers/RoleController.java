package com.mathologic.projects.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathologic.projects.models.Role;
import com.mathologic.projects.repository.RoleRepository;


@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;

	public RoleController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public @ResponseBody String createRole(@RequestBody Role r){
		roleRepository.save(r);
		
		return "role model";
	}
	@RequestMapping(value="/find",method = RequestMethod.GET)
	public @ResponseBody Page<Role> findByRoleName(@PathParam("name")String name){
		
		 return roleRepository.findByName(name,createPageRequest()); 
		
	}
	private Pageable createPageRequest() {
	    return new PageRequest(0, 10, Sort.Direction.ASC, "name");
	}
	
	

}
