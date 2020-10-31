package com.pragra.abfapi.dto;


import lombok.Data;

@Data
public class CourierDto {

    private String slug;
    private String name;
    private String phone;
    private String other_name;
    private String web_url;
    private String[] required_fields;
    private String[] optional_fields;
    private String default_language;
    private String[] support_languages;
    private String[] service_from_country_iso3;
}
