package com.ironhack.lab44.controller;

import com.ironhack.lab44.controller.dto.DoctorDTO;
import com.ironhack.lab44.controller.dto.DoctorDepartmentDTO;
import com.ironhack.lab44.controller.dto.DoctorStatusDTO;
import com.ironhack.lab44.enums.EmployeeStatus;
import com.ironhack.lab44.model.Doctor;
import com.ironhack.lab44.repository.DoctorRepository;
import com.ironhack.lab44.service.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> search(@RequestParam Optional<EmployeeStatus> status, @RequestParam Optional<String> department) {
        if (status.isPresent()) {
            return doctorRepository.findByStatus(status.get());
        } else if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        } else {
            return doctorRepository.findAll();
        }
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor findById(@PathVariable String id) {
        return doctorRepository.findById(id).get();
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor store(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.store(doctorDTO);
    }

    @PatchMapping("/doctors/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable String id, @RequestBody @Valid DoctorStatusDTO doctorStatusDTO) {
        doctorService.updateStatus(id, doctorStatusDTO);
    }

    @PatchMapping("/doctors/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable String id, @RequestBody @Valid DoctorDepartmentDTO doctorDepartmentDTO) {
        doctorService.updateDepartment(id, doctorDepartmentDTO);
    }

}
