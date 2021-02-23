package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    Optional<City> readOne(Long cityId);

    List<City> readAll();

    void delete(Long cityId);

    Long countAllCity();

    List<City> getAllTenRandomCity();


}
