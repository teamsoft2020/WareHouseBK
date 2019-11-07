package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.CustomerVendorInvoiceNo;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.repository.TripRepository;

@Component
public class TripSheetServiceImpl implements TripSheetService {

	@Autowired
	TripRepository tripRepository;

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
	public List<TripSheet> createTripSheetByExcel(List<TripSheet> list) {

		int count = 0;
		List<TripSheet> tripsheetList = new ArrayList<TripSheet>();
		try {

			for (TripSheet tripsheet : list) {
				
				TripSheet triploadid = tripRepository.findByLoadNO(tripsheet.getLoadno());

				if (triploadid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				TripSheet missdatetime = tripRepository.findByLoadNOAndDatetime(tripsheet.getLoadno(),tripsheet.getDatetime());

				if (missdatetime == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				/*TripSheet misstripid = tripRepository.findByLoadNOtripnos(tripsheet.getLoadno(),tripsheet.getTripNo());

				if (misstripid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}*/
				
				
				TripSheet missfraitcustomeramnt = tripRepository.findByLoadNOAndFraitcustomeramnt(tripsheet.getLoadno(),tripsheet.getPerkmchargecustomer());

				if (missfraitcustomeramnt == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet misstruckno = tripRepository.findByLoadNOAndTruckNo(tripsheet.getLoadno(),tripsheet.getTruckno());

				if (misstruckno == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet misstraillerequipmenttype = tripRepository.findByLoadNOAndEquipmentType(tripsheet.getLoadno(),tripsheet.getTrailerequipmenttype());

				if (misstraillerequipmenttype == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet missoriginlocationid = tripRepository.findByLoadNOAndOriginlocationid(tripsheet.getLoadno(),tripsheet.getOriginlocationid());

				if (missoriginlocationid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet missdestinationlocationid = tripRepository.findByLoadNOAnddestinationlocationid(tripsheet.getLoadno(),tripsheet.getDestinationlocationid());

				if (missdestinationlocationid == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				
				TripSheet missdiffkm = tripRepository.findByLoadNOAnDdiffKM(tripsheet.getLoadno(),tripsheet.getDiffKM());

				if (missdiffkm == null) {
					count++;
					tripsheetList.add(tripsheet);
				}
				
				

			}
		} catch (NullPointerException e) {

		}
		if (count == 0) {
			return tripsheetList;
		}
/*
		for (TripSheet t : tripsheetList) {
			System.out.println("tripsheetList,... " + t.getLoadno() + " "+t.getTripNo());
		}*/
		return tripsheetList;
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
}
