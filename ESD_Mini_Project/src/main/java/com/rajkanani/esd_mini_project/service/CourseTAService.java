package com.rajkanani.esd_mini_project.service;

import com.rajkanani.esd_mini_project.model.CourseTA;
import com.rajkanani.esd_mini_project.repo.CoursesTARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTAService {
    @Autowired
    private final CoursesTARepo coursesTARepo;

    public CourseTAService(CoursesTARepo coursesTARepo) {
        this.coursesTARepo = coursesTARepo;
    }

    public CourseTA applyCourseTA(CourseTA courseTA) {
        return coursesTARepo.save(courseTA);
    }
}
