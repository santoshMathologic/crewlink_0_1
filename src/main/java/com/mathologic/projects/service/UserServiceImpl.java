package com.mathologic.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathologic.projects.dao.UserDao;
import com.mathologic.projects.models.User;
import com.mathologic.projects.utils.SelectViewModel;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	 UserDao dao;
	public UserServiceImpl() {
		}

	


	@Override
	public SelectViewModel findUser(String username, String password, String sort, Long page, Long size) {
		
		return dao.findUser(username, password,sort,page,size);
	}




	@Override
	public boolean saveUser(User object) {
		return dao.saveUser(object);
	}







}
