package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "data")
public class ABFDto {

    @JsonProperty("meta")
    private MetaDto meta;

    @JsonProperty("data")
    private DataDto data;


}
