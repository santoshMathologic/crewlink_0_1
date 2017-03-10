/**
 * 
 */
package com.mathologic.projects.dao;

import com.mathologic.projects.models.User;
import com.mathologic.projects.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
public interface UserDao {
	
	public SelectViewModel findUser(String username, String password, String sort, Long page, Long size);
	public boolean saveUser(User object);

}
