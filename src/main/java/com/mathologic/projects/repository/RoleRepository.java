package com.mathologic.projects.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mathologic.projects.models.Role;

@RepositoryRestResource
public interface RoleRepository extends CrudRepository<Role, Long>  {

	Page<Role> findByName(@Param("name") String name,Pageable pagable);
	Role findByNameContains(@Param("name")String name);

}
