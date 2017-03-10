/**
 * 
 */
package com.mathologic.projects.dao;

import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.utils.SelectViewModel;

/**
 * @author SANTOSH
 *
 */
public interface UserPlanDao {
	
	public SelectViewModel findUserPlan(String username, String password, String sort, Long page, Long size);
	public boolean saveUserPlan(UserPlan plan);

}
