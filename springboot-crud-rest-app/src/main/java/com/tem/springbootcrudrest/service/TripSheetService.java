package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.TripSheet;

@Service
public interface TripSheetService {
	
	public TripSheet createTripSheet(TripSheet tripSheet);

	public TripSheet updateTripSheet(TripSheet tripSheet);

	public String updateTripSheetStatus(long tripid);

	public List<TripSheet> getTripSheetList();

}
