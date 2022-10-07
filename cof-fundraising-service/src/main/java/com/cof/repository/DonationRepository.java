package com.cof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cof.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer>{

}
