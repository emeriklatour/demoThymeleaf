package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaffRepository extends JpaRepository<Staff, Long> {
}
