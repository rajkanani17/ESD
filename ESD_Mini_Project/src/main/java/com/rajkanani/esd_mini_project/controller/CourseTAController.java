package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.model.CourseTA;
import com.rajkanani.esd_mini_project.service.CourseTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/course_ta")
public class CourseTAController {
    @Autowired
    private CourseTAService courseTAService;

    @PostMapping
    public CourseTA createCourseTA(@RequestBody CourseTA courseTA) {

        return courseTAService.applyCourseTA(courseTA);
    }


}
