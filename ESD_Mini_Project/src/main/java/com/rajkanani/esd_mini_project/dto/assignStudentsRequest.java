package com.rajkanani.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record assignStudentsRequest(
        @JsonProperty("approved")
        boolean approved
) {
}
