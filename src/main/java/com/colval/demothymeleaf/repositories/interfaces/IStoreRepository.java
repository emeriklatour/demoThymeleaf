package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreRepository extends JpaRepository<Store, Long> {
}
