package com.vic.springboot.quota.vic_springboot_rest.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vic.springboot.quota.vic_springboot_rest.entity.User;

import jakarta.transaction.Transactional;

//@Repository
@Cacheable("users")
public interface UserRepository extends JpaRepository<User, Integer> {//Integer - type of primary key
    //automatically created user's CRUD methods
		//findAll
		//findById
		//save(add user)
		//save(update user)
		//deleteById
	
	//example of customized method; it will be added to the automatic methods(findAll,findById,save,save,deleteById)
	//public List<User> findAllByName(String name);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "update users u set lastname = 'AAA' where u.id = :id", nativeQuery = true)
	void updateUser(int id);
	
}
