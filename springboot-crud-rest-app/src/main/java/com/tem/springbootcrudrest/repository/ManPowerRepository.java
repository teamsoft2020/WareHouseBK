package com.tem.springbootcrudrest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tem.springbootcrudrest.model.ManPower;


@Repository
@Transactional
public interface ManPowerRepository extends JpaRepository<ManPower, Long>{

}
