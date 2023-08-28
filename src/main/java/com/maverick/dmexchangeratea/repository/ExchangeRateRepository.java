package com.maverick.dmexchangeratea.repository;

import com.maverick.dmexchangeratea.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findBySourceCurrencyCodeAndTargetCurrencyCode(String sourceCurrencyCode, String targetCurrencyCode);

}