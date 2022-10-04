package com.cof.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cof.entity.Group;
import com.cof.entity.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer>{
	
	  @Query(value = "select * from group_tbl g where g.group_owner = :userId", nativeQuery = true) 
	  List<Group> getUserGroups(int userId);

	  @Modifying
	  @Query(value = "insert into user_group_tbl(user_id, group_id) values (:userId, :groupId)", nativeQuery = true)
	  void saveUserGroupOnCreation(int userId, int groupId);
	  
	  @Modifying
	  @Query(value = "insert into user_group_tbl(user_id, group_id) values (:userId, :groupId)", nativeQuery = true)
	  void saveUserGroupWithJoincode(int userId, int groupId);	
	  
}
