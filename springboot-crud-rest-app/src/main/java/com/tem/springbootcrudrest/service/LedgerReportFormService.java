package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.extramodel.CustomerInvoiceLedgerForm;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.LedgerReportForm;

@Service
public interface LedgerReportFormService {

 public List<CustomerInvoiceLedgerForm>	findLedgerReportFormRecord(String fromdate,String todate,String custvendorname);
}
