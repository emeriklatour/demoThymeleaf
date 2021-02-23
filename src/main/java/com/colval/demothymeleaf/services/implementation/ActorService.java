package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Actor;
import com.colval.demothymeleaf.repositories.interfaces.IActorRepository;
import com.colval.demothymeleaf.services.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    private final IActorRepository actorRepository;

    @Autowired
    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> readOne(Long actorId) {
        return actorRepository.findById(actorId);
    }

    @Override
    public List<Actor> readAll() {
        return actorRepository.findAll();
    }

    @Override
    public void delete(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> getActorByLastUpdate(Date lastUpdate) {
        return actorRepository.findByLastUpdate(lastUpdate);

    }

    @Override
    public Long countAllActor() {
        return actorRepository.countAll();
    }

    @Override
    public List<Actor> findAllActorIdAscAndLimitTen() {
        return actorRepository.findAllActorIdAsc().stream().limit(10).collect(Collectors.toList());
    }

}
