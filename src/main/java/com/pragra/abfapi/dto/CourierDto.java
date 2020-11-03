package com.pragra.abfapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourierDto {


    private String slug;
    private String name;
    private String phone;

    @JsonProperty("other_name")
    private String otherName;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("required_fields")
    private String[] requiredFields;

    @JsonProperty("optional_fields")
    private String[] optionalFields;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("support_languages")
    private String[] supportLanguages;

    @JsonProperty("service_from_country_iso3")
    private String[] serviceFromCountryIso3;

}
