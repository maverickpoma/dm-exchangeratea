package com.maverick.dmexchangeratea.service;

import com.maverick.dmexchangeratea.model.Currency;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface CurrencyService {
    Currency getCurrencyByCode(String code) throws ChangeSetPersister.NotFoundException;
}