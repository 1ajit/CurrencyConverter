package com.example.demo.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverterResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String amount;
	private String base_currency_code;
	private String base_currency_name;
	private Map<String, List<RateDetails>> rates = new HashMap<String, List<RateDetails>>();
	private String status;
	private String updated_date;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBase_currency_code() {
		return base_currency_code;
	}

	public void setBase_currency_code(String base_currency_code) {
		this.base_currency_code = base_currency_code;
	}

	public String getBase_currency_name() {
		return base_currency_name;
	}

	public void setBase_currency_name(String base_currency_name) {
		this.base_currency_name = base_currency_name;
	}

	public Map<String, List<RateDetails>> getRates() {
		return rates;
	}

	public void setRates(Map<String, List<RateDetails>> rates) {
		this.rates = rates;
	}

}
