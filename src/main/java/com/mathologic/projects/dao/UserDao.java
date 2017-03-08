/**
 * 
 */
package com.mathologic.projects.dao;

import java.util.List;

import com.mathologic.projects.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
public interface UserDao {
	
	public SelectViewModel findUser(String username, String password, String sort, Long page, Long size);
	public boolean saveUser(Object object); 

}
