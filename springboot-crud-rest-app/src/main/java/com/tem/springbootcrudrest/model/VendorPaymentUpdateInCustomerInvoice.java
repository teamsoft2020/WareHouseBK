package com.tem.springbootcrudrest.model;

import java.util.Set;

public class VendorPaymentUpdateInCustomerInvoice {

	private long paymentid;
	private Set<Long> invoiceid;

	public long getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(long paymentid) {
		this.paymentid = paymentid;
	}

	public Set<Long> getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Set<Long> invoiceid) {
		this.invoiceid = invoiceid;
	}

}
