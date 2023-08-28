package com.maverick.dmexchangeratea.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeRequest {

    private String sourceCurrencyCode;
    private String targetCurrencyCode;
    private BigDecimal amount;
}
