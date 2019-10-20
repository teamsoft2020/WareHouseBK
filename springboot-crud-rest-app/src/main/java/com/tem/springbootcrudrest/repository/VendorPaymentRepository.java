package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.Vendorpayment;

@Repository
public interface VendorPaymentRepository extends JpaRepository<Vendorpayment, Long>{

	@Query(value="SELECT v FROM Vendorpayment v WHERE v.paymenttype='Credit' and v.balanceamount>0")
	List<Vendorpayment> findVendorPaymentByStatusAmount();
	
	@Query(value="SELECT v FROM Vendorpayment v WHERE v.status='Realized' and v.balanceamount>0")
	List<Vendorpayment> findVendorPaymentByRemainingStatus();
	
	@Query(value="SELECT v FROM Vendorpayment v WHERE v.status='Paid' and v.balanceamount>0")
	List<Vendorpayment> findVendorPaymentByRemainingSecondStatus();
	
	//public Vendorpayment findByVendorPaymentId(long vendorpaymentid);
	
	 @Query(value="SELECT v FROM Vendorpayment v WHERE v.vendorpaymentid=:vendorpaymentid") 
	 public Vendorpayment findByVendorPaymentId(@Param("vendorpaymentid") long vendorpaymentid);
	 
	 @Query(value="SELECT c FROM Vendorpayment c WHERE c.vendorname=:vendorname") 
	 public List<Vendorpayment> findByVendorName(@Param("vendorname") String vendorname);
	 
	 @Query(value="select * from vendorpayment where (paymenttype='DD' and (status='Presented' or status='Pending')) or (paymenttype='Cheque' and (status='Presented' or status='Pending'))",nativeQuery=true) 
	 public List<Vendorpayment> findAllVendorCheque();	 

}
