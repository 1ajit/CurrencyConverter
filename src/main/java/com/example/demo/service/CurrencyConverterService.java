package com.example.demo.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.pojo.CurrencyConverterResponse;

@Service
public class CurrencyConverterService {

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<CurrencyConverterResponse> getResponse(String format, String from, String to, String amount) {
		
		if (format == null) {
			format = "json";
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "346b6f0b1amshd9d865dc611b240p19bacdjsnbcf1294233dd");
		HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

		String url = "https://currency-converter5.p.rapidapi.com/currency/convert";
		URI uri = UriComponentsBuilder.fromUriString(url).queryParam("format", format.toLowerCase())
				.queryParam("from", from).queryParam("to", to).queryParam("amount", amount).build().toUri();

		ResponseEntity<CurrencyConverterResponse> res = restTemplate.exchange(uri, HttpMethod.GET, httpEntity,
				CurrencyConverterResponse.class);
		return new ResponseEntity<CurrencyConverterResponse>(res.getBody(), res.getStatusCode());
	}
}
