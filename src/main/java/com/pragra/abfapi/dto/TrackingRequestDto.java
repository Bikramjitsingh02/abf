package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrackingRequestDto {

    @JsonProperty("tracking")
    private TrackingDto tracking;

}
