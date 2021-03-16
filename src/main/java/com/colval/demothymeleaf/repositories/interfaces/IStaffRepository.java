package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.Customer;
import com.colval.demothymeleaf.model.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findAllByStore(Long storeId);
}
