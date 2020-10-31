package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetaDto {

    @JsonProperty("message")
    private String message;

    @JsonProperty("code")
    private String code;

    @JsonProperty("type")
    private String type;

}
