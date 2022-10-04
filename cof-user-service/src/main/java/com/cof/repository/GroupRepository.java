package com.cof.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cof.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

	@Query(value = "select * from group_tbl g inner join user_group_tbl u on u.group_id = g.id where u.user_id = :userId ", nativeQuery = true)
	List<Group> getUserGroups(int userId);
	
	Group findByJoinCode(String joinCode);
	
	@Modifying
	@Query(value = "update group_tbl u set u.group_owner = :newOwnerId where u.group_owner = :userId and u.group_id = :groupId", nativeQuery = true)
	void transferGroupOwnership(int userId, int newOwnerId, int groupId);

}
