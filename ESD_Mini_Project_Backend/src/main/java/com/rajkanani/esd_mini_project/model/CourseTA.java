package com.rajkanani.esd_mini_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course_ta")
public class CourseTA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code",nullable = false)
    private String courseCode;

    @Column(name = "stud_id", nullable = false)
    private Long studId;

    @Column(name = "approved",nullable = false)
    private int approved;

}
