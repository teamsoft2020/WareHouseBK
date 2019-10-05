package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;

@Component
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {

	@Autowired
	CustomerInvoiceRepository customerInvoiceRepository;

	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;

	@Override
	public CustomerInvoice createCustomerInvoice(CustomerInvoice customerinvoice) {
		customerinvoice.setPaymentstatus("Pending");

		return customerInvoiceRepository.save(customerinvoice);

	}

	@Override
	public CustomerInvoice updateCustomerInvoice(CustomerInvoice customerInvoice) {

		return customerInvoiceRepository.save(customerInvoice);
	}

	@Override
	public String deleteById(long custInvoiceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerInvoice> getCustomerInvoiceList() {

		return customerInvoiceRepository.findAll();
	}

	@Override
	public List<Object> findVendorandCustomerList() {

		List<VendorInvoice> vendorinvoicelist = vendorInvoiceRepository.findAll();
		List<CustomerInvoice> customerinvoicelist = customerInvoiceRepository.findAll();
		List<Object> vendorCustomerList = new ArrayList<Object>();

		for (CustomerInvoice customerinvoice : customerinvoicelist) {

			vendorCustomerList.add(customerinvoice);
		}

		for (VendorInvoice vendorinvoice : vendorinvoicelist) {
			vendorCustomerList.add(vendorinvoice);
		}

		return vendorCustomerList;
	}
	
	@Override
	public List<CustomerInvoice> getCustomerInvoiceLists(String fromdate, String todate, String customername) {
		return customerInvoiceRepository.findInvoiceBetweenDateList(fromdate, todate, customername);
	}

}
