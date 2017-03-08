package com.mathologic.projects.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.mathologic.projects.repository.RoleRepository;


@RestController
@RequestMapping("/api/v1/role") // This is my base Url
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;

	public RoleController() {
	}
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public @ResponseBody String createRole(@RequestBody Role r){
		roleRepository.save(r);
		
		return "role model";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public @ResponseBody List<Role> findByRoleName(@RequestParam(value = "name") String name) {
		Page<Role> rolelist = roleRepository.findByName(name, createPageRequest());
		List<Role> r = new ArrayList<Role>();
		r = rolelist.getContent();
		return r;

	}
	@RequestMapping(value="/findByAllParams",method = RequestMethod.GET)
	public @ResponseBody Page<Role> findByAllParams(){
		
		 return roleRepository.findAll(createPageRequest()); 
		
	}
	private Pageable createPageRequest() {
	    return new PageRequest(0, 10, Sort.Direction.ASC, "name");
	}
	
	

}
