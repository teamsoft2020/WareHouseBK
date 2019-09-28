package com.tem.springbootcrudrest.model;

import java.util.Set;


public class CustomerVendorInvoiceNo {

	private long invoiceid;
	private Set<String> loadnnumber;

	public long getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(long invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Set<String> getLoadnnumber() {
		return loadnnumber;
	}

	public void setLoadnnumber(Set<String> loadnnumber) {
		this.loadnnumber = loadnnumber;
	}

}
