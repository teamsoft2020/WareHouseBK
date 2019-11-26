package com.tem.springbootcrudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.CustomerInvoice;

@Repository
@Transactional
public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long>{

	@Query(value = "select t From CustomerInvoice t where t.customername=:customername and t.createddate between :fromdate and :todate")
	public List<CustomerInvoice> findInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("customername") String customername);
	
	public CustomerInvoice findByCustomerinvoiceid(long customerinvoiceid);
	
	
	@Query(value = "select t From CustomerInvoice t where t.customername=:customername and t.paymentdate between :fromdate and :todate")
	public List<CustomerInvoice> findInvoiceBetweenDateForLedgerForm(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("customername") String customername);
	
	//customerinvoice
	
	@Query(value = "select c From CustomerInvoice c where  c.customername=:customername and c.paymentdate between :fromdate and :todate")
	public List<CustomerInvoice> findCustomerInvoiceByCustdatename(@Param("customername") String customername,@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	@Query(value = "select c From CustomerInvoice c where  c.paymentdate between :fromdate and :todate")
	public List<CustomerInvoice> findCustInvoiceByFromDateToDate(@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	
	@Query(value = "select c From CustomerInvoice c where c.customername=:customername")
	public List<CustomerInvoice> findCustInvoiceByCustomerName(@Param("customername") String customername);

	
	}
