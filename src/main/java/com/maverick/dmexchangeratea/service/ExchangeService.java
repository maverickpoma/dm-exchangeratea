package com.maverick.dmexchangeratea.service;

import com.maverick.dmexchangeratea.model.ExchangeRate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ExchangeService {
    Optional<ExchangeRate> getExchangeRate(String sourceCurrencyCode, String targetCurrencyCode);
    BigDecimal convertAmount(BigDecimal amount, String sourceCurrencyCode, String targetCurrencyCode);
    List<ExchangeRate> getAllExchangeRates();
    void updateExchangeRate(String sourceCurrencyCode, String targetCurrencyCode, BigDecimal newRate);

}
