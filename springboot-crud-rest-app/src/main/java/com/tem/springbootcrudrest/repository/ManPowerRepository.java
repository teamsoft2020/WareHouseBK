package com.tem.springbootcrudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tem.springbootcrudrest.model.ManPower;


@Repository
@Transactional
public interface ManPowerRepository extends JpaRepository<ManPower, Long>{

	
	@Query(value = "select m From ManPower m where m.customername=:customername and m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDateAndCustomerName(@Param("customername") String customername,@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	@Query(value = "select m From ManPower m where m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDate(@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	
	@Query(value = "select m From ManPower m where m.customername=:customername")
	public List<ManPower> findManPowerCustomerByCustomerName(@Param("customername") String customername);
}
