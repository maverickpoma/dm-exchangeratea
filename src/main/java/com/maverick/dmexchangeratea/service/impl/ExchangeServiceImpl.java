package com.maverick.dmexchangeratea.service.impl;

import com.maverick.dmexchangeratea.model.ExchangeRate;
import com.maverick.dmexchangeratea.repository.CurrencyRepository;
import com.maverick.dmexchangeratea.repository.ExchangeRateRepository;
import com.maverick.dmexchangeratea.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    private final CurrencyRepository currencyRepository;
    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeServiceImpl(CurrencyRepository currencyRepository, ExchangeRateRepository exchangeRateRepository) {
        this.currencyRepository = currencyRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateRepository.findAll();
    }

    public Optional<ExchangeRate> getExchangeRate(String sourceCurrencyCode, String targetCurrencyCode) {
        return exchangeRateRepository.findBySourceCurrencyCodeAndTargetCurrencyCode(sourceCurrencyCode, targetCurrencyCode);
    }


    @Override
    public BigDecimal convertAmount(BigDecimal amount, String sourceCurrencyCode, String targetCurrencyCode) {
        Optional<ExchangeRate> exchangeRateOptional = getExchangeRate(sourceCurrencyCode, targetCurrencyCode);

        if (exchangeRateOptional.isPresent()) {
            ExchangeRate exchangeRate = exchangeRateOptional.get();
            return amount.multiply(exchangeRate.getRate());
        } else {
            throw new RuntimeException("tipo de cambio no encontrado");
        }
    }

    @Override
    public void updateExchangeRate(String sourceCurrencyCode, String targetCurrencyCode, BigDecimal newRate) {
        // Actualizar la tasa de cambio en la base de datos o en la fuente de datos correspondiente
        Optional<ExchangeRate> exchangeRateOptional = exchangeRateRepository.findBySourceCurrencyCodeAndTargetCurrencyCode(
                sourceCurrencyCode, targetCurrencyCode);

        if (exchangeRateOptional.isPresent()) {
            ExchangeRate exchangeRate = exchangeRateOptional.get();
            exchangeRate.setRate(newRate);
            exchangeRateRepository.save(exchangeRate);
        } else {
            throw new RuntimeException("Exchange rate not found");
        }
    }


}