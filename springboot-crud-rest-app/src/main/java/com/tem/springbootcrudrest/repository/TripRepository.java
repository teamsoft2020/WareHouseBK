package com.tem.springbootcrudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.TripSheet;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<TripSheet, Long>{
	
	 @Query(value="SELECT * FROM TripSheet WHERE status='YES'",nativeQuery=true) 
	 public List<TripSheet> findAllTripSheet();
}
