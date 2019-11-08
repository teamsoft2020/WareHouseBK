package com.tem.springbootcrudrest.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.CustomerVendorInvoiceNo;
import com.tem.springbootcrudrest.model.TripSheet;

@Service
public interface TripSheetService {
	
	public TripSheet createTripSheet(TripSheet tripSheet);

	public TripSheet updateTripSheet(TripSheet tripSheet);

	public String updateTripSheetStatus(long tripid);

	public List<TripSheet> getTripSheetList();
	
	public List<TripSheet> getCustomerInvoiceList();
	
	public List<TripSheet> getVendoInvoiceList();
	
	public List<TripSheet> findCustomerInvoiceBetweenDate(String fromdate,String todate);
	
	public List<TripSheet> findVendorInvoiceBetweenDate(String fromdate,String todate,String truckno);
	
	public List<String> getTrucknoList();
	
	public Set<TripSheet> createTripSheetByExcel(List<TripSheet> list);
	
	public String updateCustomerInvoiceNo(CustomerVendorInvoiceNo customerInvoiceNo);
	
	public String updateVendorInvoiceNo(CustomerVendorInvoiceNo vendorInvoiceNo);

}
