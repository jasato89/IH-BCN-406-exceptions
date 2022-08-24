package com.ironhack.lab44.service.impl;

import com.ironhack.lab44.controller.dto.DoctorDTO;
import com.ironhack.lab44.controller.dto.DoctorDepartmentDTO;
import com.ironhack.lab44.controller.dto.DoctorStatusDTO;
import com.ironhack.lab44.enums.EmployeeStatus;
import com.ironhack.lab44.model.Doctor;
import com.ironhack.lab44.repository.DoctorRepository;
import com.ironhack.lab44.service.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    public DoctorRepository doctorRepository;

    public Doctor store(DoctorDTO doctorDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorDTO.getEmployeeId());
        if (doctor.isEmpty()) {
            try {
                Doctor newDoctor = new Doctor(doctorDTO.getEmployeeId(), doctorDTO.getName(), doctorDTO.getDepartment(), doctorDTO.getEmployeeStatus());
                return doctorRepository.save(newDoctor);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department and / or status values not valid.");
            }

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The employeeId already exists in the system.");
        }
    }

    public void updateStatus(String id, DoctorStatusDTO statusDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            try {
                doctor.get().setStatus(statusDTO.getEmployeeStatus());
                doctorRepository.save(doctor.get());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status value not valid.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The employeeId doesn't exist.");
        }
    }

    public void updateDepartment(String id, DoctorDepartmentDTO doctorDepartmentDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            try {
                doctor.get().setDepartment(doctorDepartmentDTO.getDepartment());
                doctorRepository.save(doctor.get());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department value not valid.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The employeeId doesn't exist.");
        }
    }

    @Override
    public List<Doctor> search(Optional<EmployeeStatus> status, Optional<String> department) {
        if (status.isPresent()) {
            return doctorRepository.findByStatus(status.get());
        } else if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        } else {
            return doctorRepository.findAll();
        }
    }

    @Override
    public Doctor findById(String id) {
        return doctorRepository.findById(id).get();
    }
}
