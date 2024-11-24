package com.rajkanani.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestCourse(
        @JsonProperty("courseCode")
        String courseCode,

        @JsonProperty("courseName")
        String courseName,

        @JsonProperty("emp_id")
        long empId

) {
//    private int courseId;
}
