package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.assignStudentsRequest;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Employees;
import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5174")
@RequestMapping("api/v1/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{emp_id}")
    public ResponseEntity<Employees> getEmployeeByEmail(@PathVariable Long emp_id) {
        return ResponseEntity.ok(employeesService.getEmployeeByEmpID(emp_id));
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
    @GetMapping("/getstudents/{course_code}")
    public List<Students> getStudentsRegisterTA(@PathVariable String course_code) {
        return employeesService.getStudentsByRegisterTA(course_code);
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
