package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CourierDetectListDto {

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("tracking_postal_code")
    private String trackingPostalCode;

    @JsonProperty("tracking_ship_date")
    private String trackingShipDate;

    @JsonProperty("tracking_account_number")
    private String trackingAccountNumber;

    @JsonProperty("tracking_key")
    private String trackingKey;

    @JsonProperty("tracking_destination_country")
    private String trackingDestinationCountry;

    @JsonProperty("slug")
    private List<String> slug;
}
