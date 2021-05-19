package com.ironhack.lab44.service.interfaces;

import com.ironhack.lab44.controller.dto.DoctorDTO;
import com.ironhack.lab44.controller.dto.DoctorDepartmentDTO;
import com.ironhack.lab44.controller.dto.DoctorStatusDTO;
import com.ironhack.lab44.model.Doctor;

public interface IDoctorService {
    Doctor store(DoctorDTO doctorDTO);

    void updateStatus(String id, DoctorStatusDTO doctorStatusDTO);

    void updateDepartment(String id, DoctorDepartmentDTO doctorDepartmentDTO);
}
