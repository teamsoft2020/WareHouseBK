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

	@Query(value = "select t From TripSheet t where t.customerinvoicestatus='NO'and  t.datetime between :fromdate and :todate")
	public List<TripSheet> findCustomerInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate);
	
	
	@Query(value = "select t From TripSheet t where t.vendorinvoicestatus='NO'and t.truckno=:truckno and t.datetime between :fromdate and :todate")
	public List<TripSheet> findVendorInvoiceBetweenDateList(@Param("fromdate") String fromdate,
			@Param("todate") String todate,@Param("truckno") String truckno);
	
	@Query(value = "SELECT truckno FROM Tripsheet", nativeQuery = true)
	public List<String> getListsBytrucknos();
	
	//start query for comparisions from xls sheet query
	
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno") 
	 public TripSheet findByLoadNO(@Param("loadno") String loadno);
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.datetime=:datetime") 
	 public TripSheet findByLoadNOAndDatetime(@Param("loadno") String loadno,@Param("datetime") String datetime);

	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.tripNo=:tripno") 
	 public TripSheet findByLoadNOAndripNo(@Param("loadno") String loadno,@Param("tripno") String tripno);

	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.perkmchargecustomer=:perkmchargecustomer") 
	 public TripSheet findByLoadNOAndFraitcustomeramnt(@Param("loadno") String loadno,@Param("perkmchargecustomer") String perkmchargecustomer);
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.truckno=:truckno") 
	 public TripSheet findByLoadNOAndTruckNo(@Param("loadno") String loadno,@Param("truckno") String truckno);
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.trailerequipmenttype=:trailerequipmenttype") 
	 public TripSheet findByLoadNOAndEquipmentType(@Param("loadno") String loadno,@Param("trailerequipmenttype") String trailerequipmenttype);
	 
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.originlocationid=:originlocationid") 
	 public TripSheet findByLoadNOAndOriginlocationid(@Param("loadno") String loadno,@Param("originlocationid") String originlocationid);
	 
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.destinationlocationid=:destinationlocationid") 
	 public TripSheet findByLoadNOAnddestinationlocationid(@Param("loadno") String loadno,@Param("destinationlocationid") String destinationlocationid);
	 
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.loadno=:loadno and t.diffKM=:diffKM") 
	 public TripSheet findByLoadNOAnDdiffKM(@Param("loadno") String loadno,@Param("diffKM") String diffKM);
	 
	//end query for comparisions
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.customerinvoiceno=:customerinvoiceno") 
	 public List<TripSheet> findByCustomerInvoiceId(@Param("customerinvoiceno") long customerinvoiceno);
	 
	 @Query(value="SELECT t FROM TripSheet t WHERE t.vendorinvoiceno=:vendorinvoiceno") 
	 public List<TripSheet> findVendorInvoiceId(@Param("vendorinvoiceno") long vendorinvoiceno);
	 
	 

	 
	 

}
