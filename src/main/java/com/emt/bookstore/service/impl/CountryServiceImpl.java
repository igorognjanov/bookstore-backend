package com.emt.bookstore.service.impl;

import com.emt.bookstore.model.Country;
import com.emt.bookstore.repository.CountryRepository;
import com.emt.bookstore.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll ();
    }
}
