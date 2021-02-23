package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.City;
import com.colval.demothymeleaf.repositories.interfaces.ICityRepository;
import com.colval.demothymeleaf.services.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService {
    private final ICityRepository cityRepository;

    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Optional<City> readOne(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> readAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public Long countAllCity() {
        return cityRepository.count();
    }

    @Override
    public List<City> getAllTenRandomCity() {
        List<City> cities = cityRepository.findAll();
        Collections.shuffle(cities);
        return cities.stream().limit(10).collect(Collectors.toList());
    }
}
