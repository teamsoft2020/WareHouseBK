package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerVendorInvoiceNo;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.repository.CustomerRepository;
import com.tem.springbootcrudrest.repository.TripRepository;
import com.tem.springbootcrudrest.repository.VendorRepository;

@Component
public class TripSheetServiceImpl implements TripSheetService {

	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public TripSheet createTripSheet(TripSheet tripSheet) {

		tripSheet.setCustomerinvoicestatus("NO");
		tripSheet.setVendorinvoicestatus("NO");
		tripSheet.setStatus("YES");
		tripSheet.setCustomerinvoiceno(0);

		return tripRepository.save(tripSheet);
	}

	@Override
	public TripSheet updateTripSheet(TripSheet tripSheet) {
		return tripRepository.save(tripSheet);
	}

	/*
	 * @Override public String deleteById(long customerId) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Override
	public List<TripSheet> getTripSheetList() {
		/*
		 * List<TripSheet>list = new ArrayList<>(); List<TripSheet>
		 * listtrip=tripRepository.findAll();
		 * 
		 * for(TripSheet tripsheet:listtrip) { if(tripsheet.getStatus().equals("YES")) {
		 * list.add(tripsheet); } }
		 */

		List<TripSheet> listtrip = tripRepository.findAllTripSheet();

		return listtrip;
	}

	@Override
	public String updateTripSheetStatus(long tripid) {
		TripSheet trip = new TripSheet();
		// tripSeet.setTripid(tripid);
		Optional<TripSheet> tripSheet = tripRepository.findById(tripid);

		trip = tripSheet.get();

		trip.setStatus("NO");

		TripSheet finaltrip = tripRepository.save(trip);

		System.out.println(trip.getCLSKM() + " nnmmm" + "status " + finaltrip.getStatus());

		// tripRepository.save(tripSeet);
		return "Status Successfully Updated";
	}

	@Override
	public List<TripSheet> getCustomerInvoiceList() {

		return tripRepository.findAllCustomerInvoiceDetails();
	}

	@Override
	public List<TripSheet> getVendoInvoiceList() {
		return tripRepository.findAllVendorInvoiceDetails();
	}

	@Override
	public List<TripSheet> findCustomerInvoiceBetweenDate(String fromdate, String todate) {

		return tripRepository.findCustomerInvoiceBetweenDateList(fromdate, todate);
	}

	@Override
	public List<String> getTrucknoList() {

		return tripRepository.getListsBytrucknos();
	}

	@Override
	public Set<TripSheet> createTripSheetByExcel(List<TripSheet> list) {
		//System.out.println("size "+list.size());
		int count = 0;
		Set<TripSheet> tripsheetset = new HashSet<TripSheet>();
		List<TripSheet>tripsheetList = new ArrayList<>();
		
		/*for(TripSheet t:list) {
			System.out.println(t.getLoadno());
		}*/
		
		try {

			for (TripSheet tripsheet : list) {
				TripSheet triploadid = new TripSheet();
				triploadid = tripRepository.findByLoadNO(tripsheet.getLoadno());
				//System.out.println(tripsheet.getLoadno());

				if (triploadid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet missdatetime = new TripSheet();
				missdatetime = tripRepository.findByLoadNOAndDatetime(tripsheet.getLoadno(),tripsheet.getDatetime());

				if (missdatetime == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet misstripid = tripRepository.findByLoadNOAndripNo(tripsheet.getLoadno(),tripsheet.getTripNo());

				if (misstripid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet missfraitcustomeramnt = new TripSheet();
				
				missfraitcustomeramnt = tripRepository.findByLoadNOAndFraitcustomeramnt(tripsheet.getLoadno(),tripsheet.getPerkmchargecustomer());

				if (missfraitcustomeramnt == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet misstruckno = new TripSheet();
				misstruckno = tripRepository.findByLoadNOAndTruckNo(tripsheet.getLoadno(),tripsheet.getTruckno());

				if (misstruckno == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet misstraillerequipmenttype = new TripSheet();
				
				 misstraillerequipmenttype = tripRepository.findByLoadNOAndEquipmentType(tripsheet.getLoadno(),tripsheet.getTrailerequipmenttype());

				if (misstraillerequipmenttype == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet missoriginlocationid = new TripSheet();
				
				 missoriginlocationid = tripRepository.findByLoadNOAndOriginlocationid(tripsheet.getLoadno(),tripsheet.getOriginlocationid());

				if (missoriginlocationid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet missdestinationlocationid = new TripSheet();
				
				 missdestinationlocationid = tripRepository.findByLoadNOAnddestinationlocationid(tripsheet.getLoadno(),tripsheet.getDestinationlocationid());

				if (missdestinationlocationid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet missdiffkm = new TripSheet();
				
				 missdiffkm = tripRepository.findByLoadNOAnDdiffKM(tripsheet.getLoadno(),tripsheet.getDiffKM());

				if (missdiffkm == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				

			}
			
		} catch (NullPointerException e) {

		}
		tripsheetset.addAll(tripsheetList);
		if (count == 0) {
			return tripsheetset;
		}
		/*System.out.println("end size "+tripsheetset.size());
		for (TripSheet t : tripsheetset) {
			System.out.println("tripsheetList,... " + t.getLoadno() + " "+t.getTripNo());
		}*/
		return tripsheetset;
	}

	@Override
	public String updateCustomerInvoiceNo(CustomerVendorInvoiceNo customerInvoiceNo) {

		for (String loadno : customerInvoiceNo.getLoadnnumber()) {
			TripSheet tripsheetupdate = new TripSheet();
			tripsheetupdate = tripRepository.findByLoadNO(loadno);
			tripsheetupdate.setCustomerinvoicestatus("YES");
			tripsheetupdate.setCustomerinvoiceno(customerInvoiceNo.getInvoiceid());

			tripRepository.save(tripsheetupdate);
		}

		return "Updated Successfully";
	}

	@Override
	public String updateVendorInvoiceNo(CustomerVendorInvoiceNo vendorInvoiceNo) {

		for (String loadno : vendorInvoiceNo.getLoadnnumber()) {
			TripSheet tripsheetupdate = new TripSheet();
			tripsheetupdate = tripRepository.findByLoadNO(loadno);
			tripsheetupdate.setVendorinvoicestatus("YES");
			tripsheetupdate.setVendorinvoiceno(vendorInvoiceNo.getInvoiceid());

			tripRepository.save(tripsheetupdate);
		}

		return "Updated Successfully";
	}

	@Override
	public List<TripSheet> findVendorInvoiceBetweenDate(String fromdate, String todate, String truckno) {
		return tripRepository.findVendorInvoiceBetweenDateList(fromdate, todate, truckno);
	}

	@Override
	public List<Object> findCustomerVendorObject(String name) {
		
		List<Object> customervendorobject=null;
		try {

			customervendorobject = customerRepository.findCustomerByNameObject(name);
			Customer customer =null;
			for(Object obj : customervendorobject) {
				 customer = (Customer) obj;
			}
			
			
			if(customer==null) {
				customervendorobject = vendorRepository.findVendorNameObject(name);
				
			}
			
		} catch (NullPointerException e) {

		}
		return customervendorobject;
	}
}
