package com.tem.springbootcrudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.TripSheet;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<TripSheet, Long> {

	@Query(value = "SELECT * FROM TripSheet WHERE status='YES'", nativeQuery = true)
	public List<TripSheet> findAllTripSheet();

	@Query(value = "SELECT * FROM TripSheet WHERE perkmchargecustomer='7.5'", nativeQuery = true)
	public List<TripSheet> findAllCustomerInvoiceDetails();

	@Query(value = "SELECT * FROM TripSheet WHERE perkmchargevendor='6.5'", nativeQuery = true)
	public List<TripSheet> findAllVendorInvoiceDetails();

	@Query(value = "SELECT * FROM TripSheet WHERE perkmchargevendor='6.5'", nativeQuery = true)
	public List<TripSheet> findAllVendorInvoiceDetsails();

	@Query(value = "select t From TripSheet t where t.customerinvoicestatus='NO'and t.truckno=:truckno and t.datetime between :fromdate and :todate")
	public List<TripSheet> findCustomerInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("truckno") String truckno);
	
	
	@Query(value = "select t From TripSheet t where t.vendorinvoicestatus='NO'and t.truckno=:truckno and t.datetime between :fromdate and :todate")
	public List<TripSheet> findVendorInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("truckno") String truckno);
	
	@Query(value = "SELECT truckno FROM Tripsheet", nativeQuery = true)
	public List<String> getListsBytrucknos();
	
	
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno") 
	 public TripSheet findByLoadNO(@Param("loadno") String loadno);
	 
	 

}
