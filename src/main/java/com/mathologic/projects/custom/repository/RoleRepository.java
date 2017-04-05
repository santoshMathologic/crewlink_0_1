package com.mathologic.projects.custom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mathologic.projects.models.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>  {

	Page<Role> findByName(@Param("name") String name,Pageable pagable);
	Role findByNameContains(@Param("name")String name);

}
