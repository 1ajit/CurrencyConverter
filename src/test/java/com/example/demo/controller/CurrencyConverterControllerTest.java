package com.example.demo.controller;

import static org.springframework.http.HttpStatus.OK;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import com.example.demo.pojo.CurrencyConverterResponse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CurrencyConverterControllerTest {

	@Test
	public void testCurrencyConverter() {
		CurrencyConverterResponse currencyConverterResponse = RestAssured.with().queryParams("format", "json")
				.queryParam("from", "AUD").queryParam("to", "CAD").queryParam("amount", "1").headers(getHeaders())
				.when()
				.request(HttpMethod.POST.toString(), "https://currency-converter5.p.rapidapi.com/currency/convert")
				.then().statusCode(OK.value()).extract().as(CurrencyConverterResponse.class);
		Assert.assertNotNull(currencyConverterResponse.getAmount());
	}

	private Headers getHeaders() {
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("X-RapidAPI-Key", "346b6f0b1amshd9d865dc611b240p19bacdjsnbcf1294233dd");
		return new Headers(header1, header2);
	}

}
