package com.tem.springbootcrudrest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.ManPowerItems;

@Repository
@Transactional
public interface ManPowerItemRepository extends JpaRepository<ManPowerItems, Long>{

}
