package com.mathologic.projects.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathologic.projects.dao.UserDao;
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
	public boolean saveUser(Object object) {
		return dao.saveUser(object);
	}}
