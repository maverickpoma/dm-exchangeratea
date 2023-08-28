package com.maverick.dmexchangeratea.service.impl;

import com.maverick.dmexchangeratea.model.Currency;
import com.maverick.dmexchangeratea.repository.CurrencyRepository;
import com.maverick.dmexchangeratea.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency getCurrencyByCode(String code) throws ChangeSetPersister.NotFoundException {
        return currencyRepository.findByCode(code)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }
}
