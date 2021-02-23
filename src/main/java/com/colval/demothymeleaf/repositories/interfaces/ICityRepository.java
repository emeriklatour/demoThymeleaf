package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {
}
