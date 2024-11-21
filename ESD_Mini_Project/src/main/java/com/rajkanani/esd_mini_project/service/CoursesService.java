package com.rajkanani.esd_mini_project.service;

import com.rajkanani.esd_mini_project.dto.RequestCourse;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.repo.CoursesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CoursesRepo coursesRepo;

    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    public Courses getCourseByCourseCode(String courseCode) {
        return coursesRepo.findByCourseCodeEquals(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Courses createCourse(RequestCourse courses) {
        Courses c= new Courses();
//        c.builder().
//                courseCode(courses.courseCode())
//                .courseName(courses.courseName())
//                .faculty(courses.empId())
//                .build();
        c.setCourseCode(courses.courseCode());
        c.setCourseName(courses.courseName());
        c.setEmpId(courses.empId());
        return coursesRepo.save(c);
    }
}
