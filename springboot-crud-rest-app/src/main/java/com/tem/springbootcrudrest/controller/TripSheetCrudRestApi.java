package com.tem.springbootcrudrest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerVendorInvoiceNo;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.service.TripSheetService;

@RestController
@RequestMapping("/api/v1")
public class TripSheetCrudRestApi {

	@Autowired
	TripSheetService tripSheetService;

	@PostMapping("/createtripsheet")
	public TripSheet createCustomer(@Valid @RequestBody TripSheet tripSheet) {

		TripSheet tripSheetResponse = tripSheetService.createTripSheet(tripSheet);

		return tripSheetResponse;
	}

	@PutMapping("/updatetripsheet")
	public TripSheet updateCustomer(@Valid @RequestBody TripSheet tripSheet) {
		TripSheet tripSheetresponse = tripSheetService.updateTripSheet(tripSheet);

		return tripSheetresponse;
	}

	@PutMapping("/updatecustomerinvoice")
	public ResponseEntity<Map<String, String>> updateCustomerInvoiceNo(
			@RequestBody CustomerVendorInvoiceNo customerInvoiceNo) {

		String customerInvoiceNoRes = tripSheetService.updateCustomerInvoiceNo(customerInvoiceNo);
		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", customerInvoiceNoRes);

		return ResponseEntity.ok(responsemap);

	}

	@PutMapping("/updatevendorinvoice")
	public ResponseEntity<Map<String, String>> updateVendorInvoiceNo(
			@RequestBody CustomerVendorInvoiceNo customerInvoiceNo) {
		String vendorInvoiceNoRes = tripSheetService.updateVendorInvoiceNo(customerInvoiceNo);
		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", vendorInvoiceNoRes);

		return ResponseEntity.ok(responsemap);

	}

	@GetMapping("/customerinvoicebydate")
	public List<TripSheet> findCustomerInvoiceBetweenDate() {
		List<TripSheet> tripSheetList = tripSheetService.getTripSheetList();

		return tripSheetList;
	}

	@GetMapping("/trucknolist")
	public List<String> getVendorListByName() {
		List<String> vendorList = tripSheetService.getTrucknoList();
		return vendorList;
	}

	/*
	 * @DeleteMapping("/tripsheet/{id}") public ResponseEntity<Map<String,String>>
	 * deleteCustomer(@PathVariable(value = "id") Long tripId) { String response =
	 * tripSheetService.deleteById(tripId);
	 * 
	 * Map<String,String>responsemap=new HashMap<String,String>();
	 * responsemap.put("status", response);
	 * 
	 * return ResponseEntity.ok(responsemap);
	 * 
	 * }
	 */

	@DeleteMapping("/tripsheet/{tripid}")
	public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable(value = "tripid") long tripid) {
		String response = tripSheetService.updateTripSheetStatus(tripid);

		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

	@GetMapping("/triplist")
	public List<TripSheet> getCustomerList() {
		List<TripSheet> tripSheetList = tripSheetService.getTripSheetList();

		return tripSheetList;
	}
	
	
	@RequestMapping(path = "/customervendorobjectfromtripsheet", method = RequestMethod.GET)

	public List<Object> getCustomerList(@RequestParam String name) {

		List<Object> tripSheetList = tripSheetService.findCustomerVendorObject(name);

		return tripSheetList;
	}

	
	
	

	@GetMapping("/test")
	public String getMap() {
		return "test..";
	}

	// @RequestMapping(path = "/customerinvoicelist/{fromdate}/{todate}", method =
	// RequestMethod.GET)

	/*
	 * public List<TripSheet> getCustomerInvoiceList(@PathVariable String
	 * fromdate, @PathVariable String todate) {
	 */
	@RequestMapping(path = "/customerinvoicelist", method = RequestMethod.GET)

	public List<TripSheet> getCustomerInvoiceList(@RequestParam String fromdate, @RequestParam String todate) {

		List<TripSheet> tripSheetList = tripSheetService.findCustomerInvoiceBetweenDate(fromdate, todate);

		return tripSheetList;
	}

	@RequestMapping(path = "/vendorinvoicelistintripsheet", method = RequestMethod.GET)

	public List<TripSheet> getVendorInvoiceList(@RequestParam String fromdate, @RequestParam String todate,
			@RequestParam String truckno) {

		List<TripSheet> tripSheetList = tripSheetService.findVendorInvoiceBetweenDate(fromdate, todate, truckno);

		return tripSheetList;
	}

	@GetMapping("/vendorinvoicelist")
	public List<TripSheet> getVendorInvoiceList() {
		List<TripSheet> tripSheetList = tripSheetService.getTripSheetList();

		return tripSheetList;
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public Set<TripSheet> singleFileUpload(@RequestParam("file") MultipartFile file)
			throws EncryptedDocumentException, IOException, InvalidFormatException {

		//System.out.println("Wel....");
		List<TripSheet> triplist = new ArrayList<TripSheet>();
		// List<Student> studentlist = new ArrayList<Student>();

		// FileInputStream file = new FileInputStream(new
		// File("C:\\\\Users\\\\sivaraman.r\\\\Downloads\\\\Test.xls"));
		// XSSFWorkbook workbook = new XSSFWorkbook(file);

		// XSSFSheet sheet = workbook.getSheetAt(0) ;

		// Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

		InputStream in = file.getInputStream();

		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = null;

		Row row;
		int sheetcount = workbook.getNumberOfSheets();

		for (int k = 0; k <= sheetcount - 1; k++) {
			sheet = workbook.getSheetAt(k);
			

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row firstrow = sheet.getRow(0);
				TripSheet trip = new TripSheet();
				row = sheet.getRow(i);
				try {

					if (String.valueOf(firstrow.getCell(0)).equals("Scheduled Date/Time(MM/DD/YYYY HH:MM)")) {
						if (row.getCell(0) != null) {
							trip.setDatetime(row.getCell(0).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(1)).equals("Load ID")) {
						if (row.getCell(1) != null) {
							//trip.setLoadno(row.getCell(1).toString());
							trip.setLoadno(new DataFormatter().formatCellValue(row.getCell(1)));
							//System.out.println("destinatio "+row.getCell(1).toString());

							
						}
					}

					if (String.valueOf(firstrow.getCell(2)).equals("Trip ID")) {
						if (row.getCell(2) != null) {
							trip.setTripNo(row.getCell(2).toString());
						//	System.out.println("orgin "+row.getCell(2).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(4)).equals("Gross Rated Amount(INR)")) {
						if (row.getCell(4) != null) {
							trip.setFreightAmtCust(row.getCell(4).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(7)).equals("Tractor Number")) {
						if (row.getCell(7) != null) {
							trip.setTruckno(row.getCell(7).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(8)).equals("Flexible Quantity 2")) {
						if (row.getCell(8) != null) {
							trip.setNoOfCase(row.getCell(8).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(10)).equals("Trailer Equipment Type")) {
						if (row.getCell(10) != null) {
							trip.setTrailerequipmenttype(row.getCell(10).toString());
							//System.out.println("destinatio "+row.getCell(10).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(11)).equals("Origin Location ID")) {
						if (row.getCell(11) != null) {
							trip.setOriginlocationid(row.getCell(11).toString());
							//System.out.println("orgin "+row.getCell(11).toString());
						}
					}

					if (String.valueOf(firstrow.getCell(12)).equals("Destination Location ID")) {
						if (row.getCell(12) != null) {
							trip.setDestinationlocationid(row.getCell(12).toString());
							//System.out.println("destinatio "+row.getCell(12).toString());

						}

					}
					
					if (String.valueOf(firstrow.getCell(13)).equals("Total Distance(KM)")) {
						if (row.getCell(13) != null) {
							trip.setDiffKM(row.getCell(13).toString());
						}

					}
					triplist.add(trip);

				} catch (NullPointerException e) {
					// System.out.println("Null caught..");
				}
				// System.out.println(trip.getDestination() + " " + trip.getLoadNo()+"
				// "+trip.getInvoiceNO());
			}

		}

		workbook.close();

		Set<TripSheet> response = tripSheetService.createTripSheetByExcel(triplist);

		return response;

	}

}
