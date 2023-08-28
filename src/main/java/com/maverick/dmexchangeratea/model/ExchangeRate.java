package com.maverick.dmexchangeratea.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter

public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Long exchangeRateId;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;
    private BigDecimal rate;


}