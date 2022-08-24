package com.ironhack.lab44.service.interfaces;

import com.ironhack.lab44.controller.dto.DoctorDTO;
import com.ironhack.lab44.controller.dto.DoctorDepartmentDTO;
import com.ironhack.lab44.controller.dto.DoctorStatusDTO;
import com.ironhack.lab44.enums.EmployeeStatus;
import com.ironhack.lab44.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {
    Doctor store(DoctorDTO doctorDTO);

    void updateStatus(String id, DoctorStatusDTO doctorStatusDTO);

    void updateDepartment(String id, DoctorDepartmentDTO doctorDepartmentDTO);

    List<Doctor> search(Optional<EmployeeStatus> status, Optional<String> department);

    Doctor findById(String id);
}
