package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.RequestCourse;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.repo.EmployeesRepo;
import com.rajkanani.esd_mini_project.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5174")
@RequestMapping("api/v1/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private EmployeesRepo employeesRepo;

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/{course_code}")
    public Courses getCourseByCourseCode(@PathVariable String courseCode) {
        return coursesService.getCourseByCourseCode(courseCode);
    }

    @PostMapping
    public String createCourse(@RequestBody RequestCourse course) {
        Long empId = course.empId();
        try{
            if(employeesRepo.findById(empId).isPresent()){
                coursesService.createCourse(course);
                return "Course created";
            }
            return "Employees Id not found";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error creating course "+e.getMessage();
        }
    }
}
