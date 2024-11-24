package com.rajkanani.esd_mini_project.service;

import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.repo.StudentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    private final StudentsRepo studentsRepo;

    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public Students createStudent(Students student) {
        return studentsRepo.save(student);
    }

    public List<Students> getAllStudents() {
        return studentsRepo.findAll();
    }
}
