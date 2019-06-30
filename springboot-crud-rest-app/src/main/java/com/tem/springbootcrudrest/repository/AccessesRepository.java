package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Accesses;

@Repository
public interface AccessesRepository extends JpaRepository<Accesses, Long>{

}
