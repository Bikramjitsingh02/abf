package com.pragra.abfapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@JsonRootName("tracking")
public class TrackingDto {

    @JsonProperty("id")
    private String id;

    private Date  created_at;
    private Date  updated_at;
    private Date  last_updated_at;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    private boolean active;
    private String tag;

    private String trackingPostalCode;

    private String trackingShipDate;

    private String trackingKey;
    private String trackingOriginCountry;
    private String trackingDestinationCountry;
    private String trackingState;
    private String trackingAccountNumber;
    private String subtag;


    @JsonProperty("smses")
    private String[] smses;

    private String[] android;
    private String[] ios;

    @JsonProperty("emails")
    private String[] emails;

    @JsonProperty("title")
    private String title;

    private String customerName;
    private String originCountryIso3;
    private String destinationCountryIos3;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("order_id_path")
    private String orderIdPath;

    @JsonSetter("custom_fields")
    private Map<String,String> customFields;
    private String note;
    private String language;

    @JsonProperty("order_promised_delivery_date")
    private Date orderPromisedDeliveryDate;

    @JsonProperty("delivery_type")
    private String deliveryType;

    @JsonProperty("pickup_location")
    private String pickupLocation;

    @JsonProperty("pickup_note")
    private String pickupNote;

    @JsonProperty("check_points")
    private List<CheckPointDto> checkPoints;

}
