package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.repository.TripRepository;

@Component
public class TripSheetServiceImpl implements TripSheetService{
	
	@Autowired
	TripRepository tripRepository;

	@Override
	public TripSheet createTripSheet(TripSheet tripSheet) {

		
		return tripRepository.save(tripSheet);
	}

	@Override
	public TripSheet updateTripSheet(TripSheet tripSheet) {
		return tripRepository.save(tripSheet);
	}

	/*@Override
	public String deleteById(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public List<TripSheet> getTripSheetList() {
		/*List<TripSheet>list = new ArrayList<>();
	List<TripSheet>	listtrip=tripRepository.findAll();
	
	for(TripSheet tripsheet:listtrip) {
		if(tripsheet.getStatus().equals("YES")) {
			list.add(tripsheet);
		}
	}*/
		
		List<TripSheet>	listtrip=tripRepository.findAllTripSheet();
		
		return listtrip; 
	}

	@Override
	public String updateTripSheetStatus(long tripid) {
		TripSheet trip = new TripSheet();
	      //	tripSeet.setTripid(tripid);
		Optional<TripSheet> tripSheet = tripRepository.findById(tripid);
		
		 trip=tripSheet.get();
		 
		trip.setStatus("NO");
		
		TripSheet finaltrip = tripRepository.save(trip);
		
		
		System.out.println(trip.getCLSKM()+" nnmmm"+ "status "+ finaltrip.getStatus());
		
	//	tripRepository.save(tripSeet);
		return "Status Successfully Updated";
	}


}
