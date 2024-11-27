package com.rajkanani.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record assignStudentsRequest(
          Long studId,
          String courseCode,
          int approved

//        @JsonProperty("approved")
//        int approved
){
}

