package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Staff;
import com.colval.demothymeleaf.model.entities.Store;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    Optional<Staff> readOne(Long staffId);

    List<Staff> readAll();

    void delete(Long staffId);

    List<Staff> getAllTenRandomStaff();

    List<Staff> findAllByStore(Long storeId);

}
