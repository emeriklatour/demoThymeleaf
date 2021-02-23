package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Store;

import java.util.List;
import java.util.Optional;

public interface IStoreService {
    Optional<Store> readOne(Long storeId);

    List<Store> readAll();

    void delete(Long storeId);

    Long countAllStore();
}
