package com.alanvieceli.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alanvieceli.api.domains.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
