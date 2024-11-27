package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.assignStudentsRequest;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Employees;
import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{emp_id}")
    public ResponseEntity<Employees> getEmployeeByEmpID(@PathVariable Long emp_id) {
        return ResponseEntity.ok(employeesService.getEmployeeByEmpID(emp_id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Employees> getEmployeeByEmail(@PathVariable String email) {
        return ResponseEntity.ok(employeesService.getEmployeeByEmail(email));
    }

    @GetMapping("/courses/{emp_id}")
    public List<Courses> getCourseByEmpId(@PathVariable long emp_id) {
        return employeesService.getCourseByEmpId(emp_id);
    }

    @PostMapping("/assignstudent")
    public ResponseEntity<String> assignStudents(@RequestBody assignStudentsRequest request) {
        String result = employeesService.assignStudents(request);
        if("Student not found" == result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        else if("Already Assigned" == result) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    // fetch students who applied for course_id
    @GetMapping("/getstudents/{course_code}")
    public List<Students> getStudentsRegisterTA(@PathVariable String course_code) {
        return employeesService.getStudentsByRegisterTA(course_code);
    }

    @PostMapping("/create")
    public Employees createEmployee(@RequestBody Employees employees) {
        return employeesService.createEmployee(employees);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Employees employees) {
//        return employeesService.login(employees);
//    }
}
