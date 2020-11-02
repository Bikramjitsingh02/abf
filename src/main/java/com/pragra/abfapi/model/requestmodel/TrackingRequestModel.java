package com.pragra.abfapi.model.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrackingRequestModel {

    @JsonProperty("tracking")
    private Tracking tracking;

}
