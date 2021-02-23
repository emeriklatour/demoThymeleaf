package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Store;
import com.colval.demothymeleaf.repositories.interfaces.IStoreRepository;
import com.colval.demothymeleaf.services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {
    private final IStoreRepository storeRepository;

    @Autowired
    public StoreService(IStoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Optional<Store> readOne(Long storeId) {
        return storeRepository.findById(storeId);
    }

    @Override
    public List<Store> readAll() {
        return storeRepository.findAll();
    }

    @Override
    public void delete(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    @Override
    public Long countAllStore() {
        return storeRepository.count();
    }

}
