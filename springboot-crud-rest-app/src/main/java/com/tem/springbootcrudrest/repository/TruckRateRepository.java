package com.tem.springbootcrudrest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.staticdata.model.TruckRate;

@Repository
@Transactional
public interface TruckRateRepository extends JpaRepository<TruckRate, Long>{

}
