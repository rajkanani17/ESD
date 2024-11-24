package com.rajkanani.esd_mini_project.repo;

import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
    Optional<Courses> findByCourseCodeEquals(String courseCode);

    List<Courses> findByEmpId(long empId);

//    List<Courses> findByEmpId(long emp_id);
}
