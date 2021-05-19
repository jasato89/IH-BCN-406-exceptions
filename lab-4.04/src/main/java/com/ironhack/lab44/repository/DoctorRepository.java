package com.ironhack.lab44.repository;

import com.ironhack.lab44.enums.EmployeeStatus;
import com.ironhack.lab44.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    List<Doctor> findByStatus(EmployeeStatus status);

    List<Doctor> findByDepartment(String department);

}
