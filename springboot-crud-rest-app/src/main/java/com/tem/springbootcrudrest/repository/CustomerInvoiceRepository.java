package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tem.springbootcrudrest.model.CustomerInvoice;

public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long>{

	@Query(value = "select t From CustomerInvoice t where t.customername=:customername and t.createddate between :fromdate and :todate")
	public List<CustomerInvoice> findInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("customername") String customername);
}
