package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet   extends HttpServlet{


	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/plain");
	        PrintWriter out = response.getWriter();

	        double amount = Double.parseDouble(request.getParameter("amount"));
	        String fromCurrency = request.getParameter("from");
	        String toCurrency = request.getParameter("to");

	        HashMap<String, Double> exchangeRates = new HashMap<>();
	        exchangeRates.put("USD_TO_INR", 83.0);
	        exchangeRates.put("INR_TO_USD", 0.012);
	        exchangeRates.put("USD_TO_EUR", 0.91);
	        exchangeRates.put("EUR_TO_USD", 1.1);
	        exchangeRates.put("INR_TO_EUR", 0.011);
	        exchangeRates.put("EUR_TO_INR", 90.0);

	        String key = fromCurrency + "TO" + toCurrency;
	        double convertedAmount = exchangeRates.containsKey(key) ? amount * exchangeRates.get(key) : 0;

	        out.println(convertedAmount);
	    }
	}

