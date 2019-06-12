package com.plot.socialnetwork.repository;

import org.springframework.data.repository.CrudRepository;

import com.plot.socialnetwork.domain.Role;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Set<Role> findAll();

    Role findByName(String name);

}
