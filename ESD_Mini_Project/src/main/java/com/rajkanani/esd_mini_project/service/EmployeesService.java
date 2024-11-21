package com.rajkanani.esd_mini_project.service;

import com.rajkanani.esd_mini_project.dto.assignStudentsRequest;
import com.rajkanani.esd_mini_project.model.CourseTA;
import com.rajkanani.esd_mini_project.model.Courses;
import com.rajkanani.esd_mini_project.model.Employees;
import com.rajkanani.esd_mini_project.model.Students;
import com.rajkanani.esd_mini_project.repo.CoursesRepo;
import com.rajkanani.esd_mini_project.repo.CoursesTARepo;
import com.rajkanani.esd_mini_project.repo.EmployeesRepo;
import com.rajkanani.esd_mini_project.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepo employeesRepo;
    private final CoursesRepo coursesRepo;
    private final StudentsRepo studentsRepo;
    private final CoursesTARepo coursesTARepo;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }
    public Employees getEmployeeByEmail(String email) {
        return employeesRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employees createEmployee(Employees employees) {
        return employeesRepo.save(employees);
    }

    public List<Courses> getCourseByEmpId(long emp_id) {
        return coursesRepo.findByEmpId(emp_id);
    }

    public List<CourseTA> getStudentsByRegisterTA(long courseId) {
        return coursesTARepo.findByCourseId(courseId);
    }

    public String assignStudents(assignStudentsRequest request, long courseTaId) {
        CourseTA courseTA = coursesTARepo.findById(courseTaId).get();
        courseTA.setApproved(request.approved());
        coursesTARepo.save(courseTA);
        return "Assigned";
    }
}
