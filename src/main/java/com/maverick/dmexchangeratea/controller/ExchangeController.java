package com.maverick.dmexchangeratea.controller;

import com.maverick.dmexchangeratea.exception.CustomException;
import com.maverick.dmexchangeratea.model.ExchangeRate;
import com.maverick.dmexchangeratea.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }


    @GetMapping("/rates")
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRates() {
        List<ExchangeRate> exchangeRates = exchangeService.getAllExchangeRates();
        return ResponseEntity.ok(exchangeRates);
    }


    @GetMapping
    public  ResponseEntity<BigDecimal> getExchangeRate(
            @RequestParam String sourceCurrencyCode,
            @RequestParam String targetCurrencyCode,
            @RequestParam BigDecimal amount) {
        try {
            BigDecimal response = exchangeService.convertAmount(amount, sourceCurrencyCode, targetCurrencyCode);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new CustomException("Se produjo un error al convertir el monto.");
        }
    }

    @PostMapping("/update-rate")
    public ResponseEntity<String> updateExchangeRate(
            @RequestParam String sourceCurrencyCode,
            @RequestParam String targetCurrencyCode,
            @RequestParam BigDecimal newRate) {
        try {
            exchangeService.updateExchangeRate(sourceCurrencyCode, targetCurrencyCode, newRate);
            return ResponseEntity.ok("Tipo de cambio actualizado exitosamente.");
        } catch (Exception e) {
            throw new CustomException("Se produjo un error al actualizar el tipo de cambio.");
        }
    }
}