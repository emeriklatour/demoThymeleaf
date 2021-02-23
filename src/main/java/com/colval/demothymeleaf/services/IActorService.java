package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Actor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IActorService {
    Actor create(Actor actor);

    Optional<Actor> readOne(Long actorId);

    List<Actor> readAll();

    void delete(Long actorId);

    List<Actor> getActorByFirstName(String firstName);

    List<Actor> getActorByLastName(String lastName);

    List<Actor> getActorByLastUpdate(Date lastUpdate);

    Long countAllActor();

    List<Actor> findAllActorIdAscAndLimitTen();

}
