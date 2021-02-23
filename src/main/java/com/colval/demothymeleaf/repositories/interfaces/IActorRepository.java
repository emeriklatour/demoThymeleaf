package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
    List<Actor> findByLastUpdate(Date lastUpdate);
    Long countAll();
    List<Actor> findAllActorIdAsc();
}
