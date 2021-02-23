package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Country;
import com.colval.demothymeleaf.repositories.interfaces.ICountryRepository;
import com.colval.demothymeleaf.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    private final ICountryRepository countryRepository;

    @Autowired
    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> readOne(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public List<Country> readAll() {
        return countryRepository.findAll();
    }

    @Override
    public void delete(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public Long countAllCountry() {
        return countryRepository.count();
    }
}
