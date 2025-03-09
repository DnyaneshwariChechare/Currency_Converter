<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <script>
        function convertCurrency() {
            var amount = document.getElementById("amount").value;
            var fromCurrency = document.getElementById("fromCurrency").value;
            var toCurrency = document.getElementById("toCurrency").value;
            
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "CurrencyConverterServlet?amount=" + amount + "&from=" + fromCurrency + "&to=" + toCurrency, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("result").innerHTML = "Converted Amount: " + xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
</head>
<body>
    <h2>Currency Converter</h2>
    <label>Amount:</label>
    <input type="text" id="amount">
    
    <label>From:</label>
    <select id="fromCurrency">
        <option value="USD">USD</option>
        <option value="INR">INR</option>
        <option value="EUR">EUR</option>
    </select>
    
    <label>To:</label>
    <select id="toCurrency">
        <option value="INR">INR</option>
        <option value="USD">USD</option>
        <option value="EUR">EUR</option>
    </select>
    
    <button onclick="convertCurrency()">Convert</button>
    <p id="result"></p>
</body>
</html>