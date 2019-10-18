package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.Vendorpayment;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<Customerpayment, Long> {

	@Query(value="SELECT c FROM Customerpayment c WHERE c.paymenttype='Credit' and c.balanceamount>0")
	List<Customerpayment> findCustomerPaymentByStatusBalAmount();
	
	@Query(value="SELECT c FROM Customerpayment c WHERE c.status='Paid' and c.balanceamount>0")
	List<Customerpayment> findCustomerPaymentByRemainingAmountStatus();
	
	@Query(value="SELECT c FROM Customerpayment c WHERE c.status='Realized' and c.balanceamount>0")
	List<Customerpayment> findCustomerPaymentByRemainingAmountSecondStatus();
	
	//public Customerpayment findByChildCustomerPaymentId(long childcustomerpaymentid);
	
	 @Query(value="SELECT c FROM Customerpayment c WHERE c.childcustomerpaymentid=:childcustomerpaymentid") 
	 public Customerpayment findByChildCustomerPaymentId(@Param("childcustomerpaymentid") long childcustomerpaymentid);
	
	 
	 @Query(value="SELECT c FROM Customerpayment c WHERE c.customername=:customername") 
	 public List<Customerpayment> findByCustomerName(@Param("customername") String customername);
	 
	 
	/*@Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno") 
	 public TripSheet findByLoadNO(@Param("loadno") String loadno);*/
}
