/**
 * 
 */
package com.mathologic.projects.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mathologic.projects.models.Role;
import com.mathologic.projects.models.User;
import com.mathologic.projects.repository.RoleRepository;
import com.mathologic.projects.utils.SelectViewModel;
import com.mathologic.projects.utils.SelectionDetails;



/**
 * @author SANTOSH
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	RoleRepository roleRepository;
	
	public UserDaoImpl() {

	}

	

	@Override
	public SelectViewModel findUser(String username, String password, String sort, Long page, Long size) {
		
		
		String q = "SELECT u from User u where (u.username LIKE :username OR :username IS NULL) AND (u.password LIKE :password OR :password IS NULL)";
		 
		javax.persistence.Query query  =  entityManager.createQuery(q);
		 query.setParameter("username", (username != null) ? "%" + username + "%" : null);
		 query.setParameter("password", (password!=null) ? "%" + password + "%" : null);
			
			query.setFirstResult(page.intValue());
			query.setMaxResults(size.intValue());
			
			 

			 
			Long totalElements = (long) query.getResultList().size();
		 	Long startIndex = page * size;
			Long totalPages = totalElements / size;
			Long currentPage = page;
			String baseItemRestUri = "/api/v1/user/";
		 
			SelectViewModel result = new SelectViewModel(User.class,
					new SelectionDetails(totalElements, startIndex, currentPage,
							totalPages, baseItemRestUri), null);
			try {
				result.setData(query.getResultList());
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
			return result;	
	}



	@Override
	@Transactional
	public boolean saveUser(User object) {
		boolean isSaved = Boolean.FALSE;
		try {
			if (object != null) {
				String rolename = object.getRole().getName();
				Role r = roleRepository.findByNameContains(rolename);
				object.setRole(r);
				entityManager.persist(object);
				isSaved = Boolean.TRUE;
				return isSaved;
			}

		} catch (Exception e) {
			System.out.println("" + e);
		}

		isSaved = Boolean.FALSE;

		return isSaved;
	}

	public Object getUniqueObject(String query){
		Object uniqueObject = null;
		try {
			javax.persistence.Query obj = entityManager.createQuery(query);
			if (obj != null) {
				uniqueObject = obj;
			}
		}
		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
		return uniqueObject;
	}
	
	

}



