package com.cof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cof.entity.FundRaisingActivity;

@Repository
public interface PublicFundRaisingActivityRepository extends JpaRepository<FundRaisingActivity, Integer> {

}
