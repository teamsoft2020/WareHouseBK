package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.extramodel.CustomerInvoiceLedgerForm;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.model.ManPowerItems;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.VendorPaymentParent;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentParentRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentRepository;
import com.tem.springbootcrudrest.repository.ManPowerRepository;
import com.tem.springbootcrudrest.repository.TripRepository;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentParentRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentRepository;

@Component
public class LedgerReportFormServiceImpl implements LedgerReportFormService {

	@Autowired
	TripRepository tripRepository;

	@Autowired
	CustomerInvoiceRepository customerInvoiceRepository;

	@Autowired
	CustomerPaymentRepository customerPaymentRepository;

	@Autowired
	CustomerPaymentParentRepository customerPaymentParentRepository;

	@Autowired
	VendorPaymentParentRepository vendorPaymentParentRepository;

	@Autowired
	VendorPaymentRepository vendorPaymentRepository;

	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;
	
	@Autowired
	ManPowerRepository manPowerRepository;
	
	

	@Override
	public List<CustomerInvoiceLedgerForm> findLedgerReportFormRecord(String fromdate, String todate,
			String custvendorname) {

		List<CustomerInvoiceLedgerForm> custlist = new ArrayList<>();

		List<CustomerInvoice> getcustomerinvoiceid = customerInvoiceRepository
				.findInvoiceBetweenDateForLedgerForm(fromdate, todate, custvendorname);

		List<VendorInvoice> getvendorinvoiceid = vendorInvoiceRepository.findInvoiceBetweenDateForLedgerForm(fromdate,
				todate, custvendorname);

		for (CustomerInvoice cust : getcustomerinvoiceid) {
			CustomerInvoiceLedgerForm custobj = new CustomerInvoiceLedgerForm();
			custobj.setCustomerinvoiceid(cust.getCustomerinvoiceid());
			custobj.setCancatload(cust.getCancatload());
			custobj.setCustinvoiceamount(cust.getAmount());
			custobj.setCustomername(cust.getCustomername());
			custlist.add(custobj);
		}

		for (VendorInvoice vend : getvendorinvoiceid) {

			CustomerInvoiceLedgerForm vendobj = new CustomerInvoiceLedgerForm();
			vendobj.setVendorinvoiceid(vend.getVendorinvoiceid());
			vendobj.setCancatload(vend.getCancatload());
			vendobj.setVendinvoiceamount(vend.getAmount());
			vendobj.setVendorname(vend.getVendorname());

			custlist.add(vendobj);
		}

		List<Customerpayment> customerPaymentid = customerPaymentRepository
				.findInvoiceBetweenDateForLedgerForm(fromdate, todate, custvendorname);

		List<Vendorpayment> vendorPaymentid = vendorPaymentRepository.findInvoiceBetweenDateForLedgerForm(fromdate,
				todate, custvendorname);

		for (Customerpayment custpay : customerPaymentid) {

			CustomerInvoiceLedgerForm custpayobj = new CustomerInvoiceLedgerForm();
			CustomerPaymentParent customerPaymentParent = new CustomerPaymentParent();
			customerPaymentParent = custpay.getCustomerPaymentParent();
			long parentpaymentid = customerPaymentParent.getCuspaymentid();
			custpayobj.setCuspaymentid(parentpaymentid);
			custpayobj.setInstrumentdate(custpay.getInstrumentdate());
			custpayobj.setCustpaymentamount(custpay.getAmount());
			custpayobj.setCustomername(custpay.getCustomername());
			custpayobj.setCancatload("instrument date: " + custpay.getInstrumentdate());
			custpayobj.setCustomerpaymenttype(custpay.getPaymenttype());
			custpayobj.setCustpaymentinstrumentno(custpay.getInstrumentno());
			custpayobj.setCustpaymentbalanceamount(custpay.getBalanceamount());

			custlist.add(custpayobj);
		}

		for (Vendorpayment vendpay : vendorPaymentid) {

			CustomerInvoiceLedgerForm vendobj = new CustomerInvoiceLedgerForm();

			VendorPaymentParent vendorPaymentParent = new VendorPaymentParent();

			vendorPaymentParent = vendpay.getVendorPaymentParent();
			long vendorpaymentid = vendorPaymentParent.getVendpaymentid();

			vendobj.setVendpaymentid(vendorpaymentid);
			vendobj.setInstrumentdate(vendpay.getInstrumentdate());
			vendobj.setVenpaymentdamount(vendpay.getAmount());
			vendobj.setVendorname(vendpay.getVendorname());
			vendobj.setCancatload("instrument date " + vendpay.getInstrumentdate());
			vendobj.setVendorpaymenttype(vendpay.getPaymenttype());
			vendobj.setVendpaymentinstrumentno(vendpay.getInstrumentno());
			vendobj.setVendpaymentbalanceamount(vendpay.getBalanceamount());

			custlist.add(vendobj);
		}
		
		List<ManPower> manpowerPaymentid = manPowerRepository.findInvoiceBetweenDateForLedgerForm(fromdate,
				todate, custvendorname);
		
		for(ManPower manpower:manpowerPaymentid) {
			CustomerInvoiceLedgerForm manobj = new CustomerInvoiceLedgerForm();
			
			List<ManPowerItems> manpoweritemlist = manpower.getItemDetails();
			
			String total=null;
			
			for(ManPowerItems manpoweritems : manpoweritemlist) {
				total = manpoweritems.getTotal();
			}
			manobj.setManpowercustomernamer(manpower.getCustomername());
			manobj.setManpowerid(manpower.getManpowerid());
			manobj.setManpowertotal(total);
			manobj.setManpowerinvoicedate(manpower.getInvoicedate());
			custlist.add(manobj);
		}

		return custlist;
	}

}
