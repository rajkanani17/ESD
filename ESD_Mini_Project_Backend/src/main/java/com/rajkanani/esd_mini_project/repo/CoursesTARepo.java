package com.rajkanani.esd_mini_project.repo;

import com.rajkanani.esd_mini_project.model.CourseTA;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoursesTARepo extends JpaRepository<CourseTA, Long> {

    @Query("SELECT p FROM CourseTA as p WHERE p.courseCode=:courseId AND p.approved=1")
    List<CourseTA> findByCourseCode(String courseId);
}
