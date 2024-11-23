package com.rajkanani.esd_mini_project.service;

import com.rajkanani.esd_mini_project.dto.RequestCourse;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.repo.CoursesRepo;
import com.rajkanani.esd_mini_project.repo.EmployeesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private  CoursesRepo coursesRepo;
    @Autowired
    private EmployeesRepo employeesRepo;

    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    public Courses getCourseByCourseCode(String courseCode) {
        return coursesRepo.findByCourseCodeEquals(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public String createCourse(RequestCourse courses) {
        Long empId = courses.empId();
        if(employeesRepo.findById(empId).isPresent())
        {
            Courses c= new Courses();
            c.setCourseCode(courses.courseCode());
            c.setCourseName(courses.courseName());
            c.setEmpId(courses.empId());
            coursesRepo.save(c);
            return "Course created";
        }
        return "Employees Id not found";

    }
}
