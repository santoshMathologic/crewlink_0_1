/**
 * 
 */
package com.mathologic.projects.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.mathologic.projects.models.UserPlan;
import com.mathologic.projects.utils.SelectViewModel;



/**
 * @author SANTOSH
 *
 */
@Repository
public class UserPlanDaoImpl implements UserPlanDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public UserPlanDaoImpl() {

	}



	@Override
	public SelectViewModel findUserPlan(String username, String password, String sort, Long page, Long size) {
		return null;
	}



	@Override
	public boolean saveUserPlan(UserPlan plan) {
		return false;
	}

	

	
	

}



