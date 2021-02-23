package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Staff;
import com.colval.demothymeleaf.repositories.interfaces.IStaffRepository;
import com.colval.demothymeleaf.services.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffService implements IStaffService {
    private final IStaffRepository staffRepository;

    @Autowired
    public StaffService(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Optional<Staff> readOne(Long staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public List<Staff> readAll() {
        return staffRepository.findAll();
    }

    @Override
    public void delete(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getAllTenRandomStaff() {
        List<Staff> staff = staffRepository.findAll();
        Collections.shuffle(staff);
        return staff.stream().limit(10).collect(Collectors.toList());
    }
}
