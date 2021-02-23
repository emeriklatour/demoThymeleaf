package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    Optional<Country> readOne(Long countryId);

    List<Country> readAll();

    void delete(Long countryId);

    Long countAllCountry();

}
