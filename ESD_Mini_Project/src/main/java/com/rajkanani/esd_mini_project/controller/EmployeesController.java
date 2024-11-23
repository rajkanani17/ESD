package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.assignStudentsRequest;
import com.rajkanani.esd_mini_project.model.CourseTA;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Employees;
import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{email}")
    public Employees getEmployeeByEmail(@PathVariable String email) {
        return employeesService.getEmployeeByEmail(email);
    }

    @GetMapping("/courses/{emp_id}")
    public List<Courses> getCourseByEmpId(@PathVariable long emp_id) {
        return employeesService.getCourseByEmpId(emp_id);
    }

    @PutMapping("/assignstudent/{course_ta_id}")
    public String assignStudents(@RequestBody assignStudentsRequest request, @PathVariable long course_ta_id) {
        return employeesService.assignStudents(request, course_ta_id);
    }

    // fetch students who applied for course_id
    @GetMapping("/getstudents/{course_id}")
    public List<Students> getStudentsRegisterTA(@PathVariable Long course_id) {
        return employeesService.getStudentsByRegisterTA(course_id);
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employees) {
        return employeesService.createEmployee(employees);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Employees employees) {
//        return employeesService.login(employees);
//    }
}
