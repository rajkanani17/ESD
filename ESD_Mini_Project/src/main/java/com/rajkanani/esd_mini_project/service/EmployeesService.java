package com.rajkanani.esd_mini_project.service;

import ch.qos.logback.classic.encoder.JsonEncoder;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepo employeesRepo;
    private final CoursesRepo coursesRepo;
    private final StudentsRepo studentsRepo;
    private final EncryptionService encryptionService;
    private final CoursesTARepo coursesTARepo;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }
    public Employees getEmployeeByEmail(String email) {
        return employeesRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employees createEmployee(Employees employees) {
        employees.setPassword(encryptionService.encode(employees.getPassword()));
        return employeesRepo.save(employees);
    }

    public List<Courses> getCourseByEmpId(long emp_id) {
        return coursesRepo.findByEmpId(emp_id);
    }

    public List<Students> getStudentsByRegisterTA(Long courseId) {
        if(coursesRepo.findById(courseId).isPresent()) {
            List<CourseTA> cta =  coursesTARepo.findByCourseId(courseId);
            List<Students> students = new ArrayList<>();
            for(CourseTA courseTA : cta) {
                students.add(studentsRepo.findById(courseTA.getStudId()).orElse(null));
            }

            return students;
        }
        return new ArrayList<>();
    }

    public String assignStudents(assignStudentsRequest request, long courseTaId) {
        CourseTA courseTA = coursesTARepo.findById(courseTaId).orElse(null);

        if(request.approved() == 1){
            courseTA.setApproved(1); // approved
        }
        else if(request.approved() == 2) {
            coursesTARepo.delete(courseTA);
            return "Rejected";
        }
        coursesTARepo.save(courseTA);
        return "Assigned";
    }

//    public ResponseEntity<String> login(Employees employees) {
//
//    }
}
