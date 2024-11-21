package com.rajkanani.esd_mini_project.repo;

import com.rajkanani.esd_mini_project.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Long> {

}
