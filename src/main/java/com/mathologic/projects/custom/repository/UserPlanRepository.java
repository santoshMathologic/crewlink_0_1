package com.mathologic.projects.custom.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mathologic.projects.models.UserPlan;

@RepositoryRestResource
public interface UserPlanRepository extends JpaRepository<UserPlan, Long> {
	
	@Query("SELECT up from UserPlan as up WHERE (up.planName LIKE %:planname% OR :planname IS NULL OR :planname is '%%')")
	Page<UserPlan> findByAllUserPlanParams(@Param("planname") String planname,Pageable pagable);
	
	

}
