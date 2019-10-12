package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.model.VendorInvoice;

@Repository
public interface VendorInvoiceRepository extends JpaRepository<VendorInvoice, Long> {

	@Query(value = "select t From VendorInvoice t where t.vendorname=:vendorname and t.createddate between :fromdate and :todate")
	public List<VendorInvoice> findInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate, @Param("vendorname") String vendorname);

	/*@Query(value = "select v From VendorInvoice v where v.vendorinvoiceid=:vendorinvoiceid",nativeQuery=true)
	public VendorInvoice findByVendorinvoiceid(@Param("vendorinvoiceid") long vendorinvoiceid);*/
	
	//public VendorInvoice findByvendorinvoiceid(long vendorinvoiceid);
	
	 @Query(value="SELECT v FROM VendorInvoice v WHERE v.vendorinvoiceid=:vendorinvoiceid") 
	 public VendorInvoice findByvendorinvoiceid(@Param("vendorinvoiceid") long vendorinvoiceid);
}
