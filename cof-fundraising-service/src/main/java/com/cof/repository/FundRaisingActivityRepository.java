package com.cof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cof.entity.FundRaisingActivity;

@Repository
public interface FundRaisingActivityRepository extends JpaRepository<FundRaisingActivity, Integer> {

	@Query(value = "select * from fundraising_tbl f where f.fundraiser_name LIKE %:name%", nativeQuery = true)
	FundRaisingActivity findFundRaisingActivityByfundraiserName(String name);

}
