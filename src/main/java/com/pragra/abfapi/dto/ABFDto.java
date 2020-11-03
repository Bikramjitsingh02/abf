package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ABFDto {

    @JsonProperty("total")
    public int total;

    @JsonProperty("couriers")
    public List<CourierDto> couriers;


}
