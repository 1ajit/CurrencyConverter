package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CurrencyConverterResponse;
import com.example.demo.service.CurrencyConverterService;

@RestController
@RequestMapping("/v1")
public class CurrencyConverterController {

	@Autowired
	CurrencyConverterService currencyConverterService;

	@GetMapping("/currency/convert")
	public ResponseEntity<CurrencyConverterResponse> getAvaliableCurrencies(
			@RequestParam(required = false, defaultValue = "json") String format, @RequestParam String from,
			@RequestParam String to, @RequestParam String amount) throws IOException {
		return currencyConverterService.getResponse(format, from, to, amount);
	}
}
