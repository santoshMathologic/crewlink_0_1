package com.mathologic.projects.custom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mathologic.projects.models.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>  {

	@Query("Select u from User as u where (u.username LIKE %:username% OR :username IS NULL OR username is '%%') AND "
			+ " (u.password LIKE %:password% OR :password IS NULL OR password is '%%')")
	Page<User> findByAllUserParams(
			@Param("username")String username,
			@Param("password")String password,
			Pageable pagable);
	
	Page<User> findByUsernameOrMobileNo(@Param("username") String username,@Param("mobNo")String mobNo,Pageable pagable);
	
	User findByUsernameAndIsActive(@Param("username")String username,@Param("isActive")boolean isActive);
	
	
	Page<User> findAll(Pageable pagable);
	User findByUsername(@Param("username")String username);

}
