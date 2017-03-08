package com.mathologic.projects.service;

import com.mathologic.projects.utils.SelectViewModel;

public interface UserService {
	public SelectViewModel findUser(String username, String password, String sort, Long page, Long size);
	public boolean saveUser(Object object);

}
