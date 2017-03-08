/**
 * 
 */
package com.mathologic.projects.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.mathologic.projects.models.User;
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
	public boolean saveUser(Object object) {
		boolean isSaved = Boolean.FALSE;
		try {
			if (object != null) {
				
				entityManager.persist( object );
				isSaved = Boolean.TRUE;
				return isSaved;
			}

		} catch (Exception e) {
			System.out.println("" + e);
		}

		isSaved = Boolean.FALSE;

		return isSaved;
	}
	
	

}



