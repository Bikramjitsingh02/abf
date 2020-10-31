package com.pragra.abfapi.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CheckPointDto {

    private String slug;
    private String city;
    private Date created_at;
    private String location;
    private String country_name;
    private String message;
    private String country_iso3;
    private String tag;
    private String subtag;
    private String subtag_message;
    private Date  checkpoint_time;
    private List<String> coordinates;
    private String state;
    private String zip;
    private String raw_tag;
}
