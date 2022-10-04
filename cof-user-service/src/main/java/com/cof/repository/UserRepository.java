package com.cof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cof.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from user_tbl  u where u.email = :email and u.password= :password", nativeQuery=true)
	User login(String email, String password);
	 
	
	/* List<Group> findByUserGroupIdUserId(int userId); */

}
