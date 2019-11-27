package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.Vendor;
import com.tem.springbootcrudrest.model.VendorPaymentParent;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.CustomerPaymentParentRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentRepository;
import com.tem.springbootcrudrest.repository.CustomerRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentParentRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentRepository;
import com.tem.springbootcrudrest.repository.VendorRepository;
import com.tem.util.UTCDateTime;

@Component
public class CustomerPaymentServiceImpl implements CustomerPaymentService {

	@Autowired
	CustomerPaymentParentRepository customerPaymentParentRepository;

	@Autowired
	CustomerPaymentRepository customerPaymentRepository;

	@Autowired
	VendorPaymentParentRepository vendorPaymentParentRepository;

	@Autowired
	VendorPaymentRepository vendorPaymentRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public CustomerPaymentParent createCustomerPayment(CustomerPaymentParent customerpaymentlist) {

		CustomerPaymentParent customerpaymentresponse = customerPaymentParentRepository.save(customerpaymentlist);

		/*
		 * for(Customerpayment customerpayment:customerpaymentresponse) {
		 * CustomerInvoice customerinvoice = new CustomerInvoice(); customerinvoice =
		 * customerInvoiceRepository.findByCustomerinvoiceid(customerpayment.
		 * getCustomerinvoiceid());
		 * 
		 * customerinvoice.setPaymentstatus(customerpayment.getPaymentstatus());
		 * customerinvoice.setCustomerinvoiceid(customerpayment.getCustomerpaymentid());
		 * 
		 * customerInvoiceRepository.save(customerinvoice);
		 * 
		 * }
		 */

		return customerpaymentresponse;

	}

	@Override
	public List<Customerpayment> getCustomerPaymentByStatusBalAmount() {

		return customerPaymentRepository.findCustomerPaymentByStatusBalAmount();

	}

	@Override
	public List<Customerpayment> getCustomerPaymentByStatus() {
		List<Customerpayment> twolist = new ArrayList<Customerpayment>();

		List<Customerpayment> list1 = customerPaymentRepository.findCustomerPaymentByRemainingAmountStatus();
		List<Customerpayment> list2 = customerPaymentRepository.findCustomerPaymentByRemainingAmountSecondStatus();

		twolist.addAll(list1);
		twolist.addAll(list2);

		return twolist;

	}

	// findByChildCustomerPaymentId

	@Override
	public List<Customerpayment> updateCustomerPayment(List<Customerpayment> customerpaymentlist) {

		List<Customerpayment> customerpaylist = new ArrayList<Customerpayment>();

		for (Customerpayment customerpay : customerpaymentlist) {
			Customerpayment customerpayment = customerPaymentRepository
					.findByChildCustomerPaymentId(customerpay.getChildcustomerpaymentid());

			customerpayment.setBalanceamount(customerpay.getBalanceamount());
			customerpayment.setStatus(customerpay.getStatus());
			customerpayment.setInstrumentno(customerpay.getInstrumentno());

			Customerpayment customerpaymentobject = customerPaymentRepository.save(customerpayment);

			customerpaylist.add(customerpaymentobject);

		}

		return customerpaylist;
	}

	@Override
	public List<Customerpayment> getCustomerListByName(String customername) {
		return customerPaymentRepository.findByCustomerName(customername);
	}

	@Override
	public List<Customerpayment> getCustomerChequeManagementList() {
		return customerPaymentRepository.findAllCustomerCheque();
	}

	@Override
	public List<Customerpayment> updateCustomerChequeManagement(List<Customerpayment> customerchequelist) {

		List<Customerpayment> customerchequeist = new ArrayList<Customerpayment>();

		for (Customerpayment customercheques : customerchequelist) {

			Customerpayment customercheque = customerPaymentRepository
					.findByChildCustomerPaymentId(customercheques.getChildcustomerpaymentid());

			Customerpayment customerpaymentchequeobj = new Customerpayment();
			if (customercheques.getStatus().equals("Bounced")) {
				customerpaymentchequeobj.setAmount(customercheque.getAmount());
				customerpaymentchequeobj.setBalanceamount(customercheque.getBalanceamount());
				customerpaymentchequeobj.setInstrumentno(customercheque.getInstrumentno());
				customerpaymentchequeobj.setPaymenttype(customercheque.getPaymenttype());
				customerpaymentchequeobj.setStatus("Pending");
				customerpaymentchequeobj.setCustomername(customercheque.getCustomername());
				customerpaymentchequeobj.setCustomerPaymentParent(customercheque.getCustomerPaymentParent());
				customerPaymentRepository.save(customerpaymentchequeobj);

			}

			// customerpayment.setBalanceamount(customercheque.getBalanceamount());
			customercheque.setStatus(customercheques.getStatus());
			// customerpayment.setInstrumentno(customercheque.getInstrumentno());

			Customerpayment customerchequetobject = customerPaymentRepository.save(customercheques);

			customerchequeist.add(customerchequetobject);

		}
		return customerchequeist;
	}
	

	@Override
	public String createManpowerPayment(CustomerPaymentParent customerpaymentlist) {

		String datetime = UTCDateTime.getCurentTimeAndDate();

		customerpaymentlist.setCreateddate(datetime);

		String name = null;

		for (Customerpayment customerpayment : customerpaymentlist.getCustomerpayment()) {
			name = customerpayment.getCustomername();
		}

		System.out.println("befor");
		//List<Customerpayment> customerpay = customerPaymentRepository.findByCustomerNameForManPower(name);
		
		Customer customer = customerRepository.findCustomerByNamesforCustpaymentservice(name);
		
		System.out.println("vend");

		//List<Vendorpayment> vendorpay = vendorPaymentRepository.findByVendorNameForManPower(name);
		
		Vendor vendor = vendorRepository.findVendorNamesforCustPayService(name);

		if (customer != null) {

			customerPaymentParentRepository.save(customerpaymentlist);

			return "Customer Payment Created Successfully";
		} else {

			VendorPaymentParent vendorpaymentparent = new VendorPaymentParent();
			Vendorpayment vendorpayment = null;
			List<Vendorpayment> vendorpaymentlist = new ArrayList<Vendorpayment>();

			// vendorpaymentparent

			if (vendor != null) {
				vendorpaymentparent.setCreateddate(customerpaymentlist.getCreateddate());
				vendorpaymentparent.setVendorreceiptdate(customerpaymentlist.getCustomerreceiptdate());
				vendorpaymentparent.setModifieddate(customerpaymentlist.getModifieddate());

				for (Customerpayment customerpayment : customerpaymentlist.getCustomerpayment()) {

					vendorpayment = new Vendorpayment();

					// vendorpayment
					vendorpayment.setAmount(customerpayment.getAmount());
					vendorpayment.setBalanceamount(customerpayment.getBalanceamount());
					vendorpayment.setInstrumentdate(customerpayment.getInstrumentdate());
					vendorpayment.setInstrumentno(customerpayment.getInstrumentno());
					vendorpayment.setPaymenttype(customerpayment.getPaymenttype());
					vendorpayment.setStatus(customerpayment.getStatus());
					vendorpayment.setVendorname(customerpayment.getCustomername());
					vendorpaymentlist.add(vendorpayment);

				}
				vendorpaymentparent.setVendorpayment(vendorpaymentlist);

			} 
			vendorPaymentParentRepository.save(vendorpaymentparent);

			return "Vendor Payment Created Successfully";
		}

	}

}
