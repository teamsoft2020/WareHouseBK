package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentParentRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentRepository;
import com.tem.util.UTCDateTime;

@Component
public class CustomerPaymentServiceImpl implements CustomerPaymentService {

	@Autowired
	CustomerPaymentParentRepository customerPaymentParentRepository;

	@Autowired
	CustomerPaymentRepository customerPaymentRepository;

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
			if(customercheques.getStatus().equals("Bounced")) {
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
			customercheques.setStatus(customercheque.getStatus());
			// customerpayment.setInstrumentno(customercheque.getInstrumentno());

			Customerpayment customerchequetobject = customerPaymentRepository.save(customercheques);

			customerchequeist.add(customerchequetobject);

			
		}
		return customerchequeist;
	}

}
