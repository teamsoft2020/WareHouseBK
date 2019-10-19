package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.VendorPaymentParent;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.VendorPaymentParentRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentRepository;
import com.tem.util.UTCDateTime;

@Component
public class VendorPaymentServiceImpl implements VendorPaymentService{
	
	@Autowired
	VendorPaymentParentRepository vendorPaymentParentRepository;
	
	@Autowired
	VendorPaymentRepository vendorPaymentRepository;

	@Override
	public VendorPaymentParent createVendorPayment(VendorPaymentParent vendorpaymentparent) {
		vendorpaymentparent.setCreateddate(UTCDateTime.getCurentTimeAndDate());
		VendorPaymentParent vendoerpaymentesponse = vendorPaymentParentRepository.save(vendorpaymentparent);
		
		return vendoerpaymentesponse;
		
	}


	@Override
	public List<Vendorpayment> getVendorPaymentByStatusBalAmount() {
		
		return vendorPaymentRepository.findVendorPaymentByStatusAmount();
	}
	
	@Override
	public List<Vendorpayment> getVendorPaymentByStatus() {
		
		List<Vendorpayment>alllists =new ArrayList<Vendorpayment>();
		
		List<Vendorpayment>list = vendorPaymentRepository.findVendorPaymentByRemainingStatus();
		
		List<Vendorpayment>secondlist = vendorPaymentRepository.findVendorPaymentByRemainingSecondStatus();
		alllists.addAll(list);
		alllists.addAll(secondlist);
		return alllists;
	}


	@Override
	public List<Vendorpayment> updateVendorPaymentChild(List<Vendorpayment> vendorPaymentChild) {
		List<Vendorpayment> vendorPaymentlist = new ArrayList<Vendorpayment>();
		for(Vendorpayment vendpay:vendorPaymentChild) {
			Vendorpayment vendorpayment=vendorPaymentRepository.findByVendorPaymentId(vendpay.getVendorpaymentid());
			vendorpayment.setBalanceamount(vendpay.getBalanceamount());
			vendorpayment.setStatus(vendpay.getStatus());
			vendorpayment.setInstrumentno(vendpay.getInstrumentno());
			Vendorpayment vendorpaymentobject = vendorPaymentRepository.save(vendorpayment);
			vendorPaymentlist.add(vendorpaymentobject);
		}
		return vendorPaymentlist;
	}


	@Override
	public List<Vendorpayment> getVendorListByName(String name) {
		
		return vendorPaymentRepository.findByVendorName(name);
	}


	@Override
	public List<Vendorpayment> getVendorChequeList() {
		return vendorPaymentRepository.findAll();
	}
	
	@Override
	public List<Vendorpayment> updateVendorCheque(List<Vendorpayment> vendorChequeList) {
		
		List<Vendorpayment> vendorChequelist = new ArrayList<Vendorpayment>();
		for(Vendorpayment vendcheque:vendorChequeList) {
			Vendorpayment vendorcheque=vendorPaymentRepository.findByVendorPaymentId(vendcheque.getVendorpaymentid());
			Vendorpayment vendorpaymentchequeobj = new Vendorpayment();
			if(vendcheque.getStatus().equals("Bounced")) {
				vendorpaymentchequeobj.setAmount(vendorcheque.getAmount());
				vendorpaymentchequeobj.setBalanceamount(vendorcheque.getBalanceamount());
				vendorpaymentchequeobj.setInstrumentno(vendorcheque.getInstrumentno());
				vendorpaymentchequeobj.setPaymenttype(vendorcheque.getPaymenttype());
				vendorpaymentchequeobj.setStatus("Pending");
				vendorpaymentchequeobj.setVendorreceiptdate(vendorcheque.getVendorreceiptdate());
				vendorpaymentchequeobj.setModifieddate(UTCDateTime.getCurentTimeAndDate());
				vendorpaymentchequeobj.setVendorname(vendorcheque.getVendorname());
				vendorpaymentchequeobj.setVendorPaymentParent(vendorcheque.getVendorPaymentParent());
				vendorPaymentRepository.save(vendorpaymentchequeobj);
				
			}
			//vendorpayment.setBalanceamount(vendcheque.getBalanceamount());
			vendorcheque.setStatus(vendcheque.getStatus());
			//vendorpayment.setInstrumentno(vendcheque.getInstrumentno());
			Vendorpayment vendorpaymentobject = vendorPaymentRepository.save(vendorcheque);
			vendorChequelist.add(vendorpaymentobject);
		}
		return vendorChequelist;
	}
	
}
