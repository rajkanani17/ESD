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

    @Column(name = "course_id",nullable = false)
    private long courseId;

    @Column(name = "stud_id", nullable = false)
    private long studId;

    @Column(name = "approved",nullable = false)
    private boolean approved;

}
