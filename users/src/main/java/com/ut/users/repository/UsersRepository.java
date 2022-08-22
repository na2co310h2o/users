package com.ut.users.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ut.users.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{

	List<Users> findAll();
	
	Users findByUserId(int userId);
	
	List<Users> findByStatus(String status);

	List<Users> findByLevelGreaterThan(int level);
	
	@Transactional
	int deleteByUserId(int userId);
	
}
