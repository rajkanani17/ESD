package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping("/create")
    public Students createStudent(@RequestBody Students student) {
        return studentsService.createStudent(student);
    }

    @GetMapping
    public List<Students> getAllStudents() {
        return studentsService.getAllStudents();
    }
}
