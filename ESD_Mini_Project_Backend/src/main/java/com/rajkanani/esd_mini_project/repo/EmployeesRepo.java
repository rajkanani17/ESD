package com.rajkanani.esd_mini_project.repo;

import com.rajkanani.esd_mini_project.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepo extends JpaRepository<Employees, Long> {
    Optional<Employees> findByEmail(String email);
}
