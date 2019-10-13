package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.Vendorpayment;

@Repository
public interface VendorPaymentRepository extends JpaRepository<Vendorpayment, Long>{

	@Query(value="SELECT v FROM Vendorpayment v WHERE v.paymenttype='Credit' and v.amount>0")
	List<Vendorpayment> findVendorPaymentByStatusBalAmount();
	
}
