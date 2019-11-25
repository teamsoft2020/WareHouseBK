package com.tem.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.extramodel.CustomerInvoiceLedgerForm;
import com.tem.springbootcrudrest.service.LedgerReportFormService;

@RestController
@RequestMapping("/api/v1")
public class LedgerReportFormCrudRestApi {

	@Autowired
	LedgerReportFormService ledgerReportFormService;

	
	@RequestMapping(path = "/ledgerreportform", method = RequestMethod.GET)
	public List<CustomerInvoiceLedgerForm> findLedgerReportFormRecord(@RequestParam String fromdate, @RequestParam String todate,@RequestParam String custvendorname) {

		System.out.println("sys "+custvendorname +" "+fromdate+ " "+todate);
		List<CustomerInvoiceLedgerForm> tripSheetList = ledgerReportFormService.findLedgerReportFormRecord(fromdate, todate,custvendorname);

		return tripSheetList;
	}
	
}
