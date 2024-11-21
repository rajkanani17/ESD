package com.rajkanani.esd_mini_project.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faculty_courses")
public class FacultyCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fc_id;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employees faculty;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Courses course;


}
