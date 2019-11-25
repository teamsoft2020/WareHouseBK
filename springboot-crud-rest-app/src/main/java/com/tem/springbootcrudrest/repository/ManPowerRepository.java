package com.tem.springbootcrudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.ManPower;


@Repository
@Transactional
public interface ManPowerRepository extends JpaRepository<ManPower, Long>{

	
	@Query(value = "select m From ManPower m where m.status='Pending' and m.customername=:customername and m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDateAndCustomerName(@Param("customername") String customername,@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	@Query(value = "select m From ManPower m where m.status='Pending' and m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDate(@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	
	@Query(value = "select m From ManPower m where m.status='Pending'and m.customername=:customername")
	public List<ManPower> findManPowerCustomerByCustomerName(@Param("customername") String customername);
	
	
	@Query(value = "select m From ManPower m where m.status='Completed' and m.customername=:customername and m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDateAndCustomerNameCompletedStatus(@Param("customername") String customername,@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	@Query(value = "select m From ManPower m where m.status='Completed' and m.invoicedate between :fromdate and :todate")
	public List<ManPower> findManPowerCustomerByFromDateToDateCompletedStatus(@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	
	@Query(value = "select m From ManPower m where m.status='Completed' and m.customername=:customername")
	public List<ManPower> findManPowerCustomerByCustomerNameCompletedStatus(@Param("customername") String customername);
	
	public ManPower findBymanpowerid(long manpowerid);
	
	 @Query(value = "select m From ManPower m where m.customername=:customername and m.invoicedate between :fromdate and :todate")
		public List<ManPower> findInvoiceBetweenDateForLedgerForm(@Param("fromdate") String fromdate,
				@Param("todate") String todate,@Param("customername") String customername);
}
