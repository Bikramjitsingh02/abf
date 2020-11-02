package com.pragra.abfapi.model.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;


@Data
public class Tracking implements Serializable {

        @JsonProperty("id")
        private String id;

        @JsonProperty("slug")
        private String slug;

        @JsonProperty("tracking_number")
        private String trackingNumber;

        @JsonProperty("active")
        private boolean active;

        @JsonProperty("tag")
        private String tag;

        @JsonProperty("tracking_postal_code")
        private String trackingPostalCode;

        @JsonProperty("tracking_ship_date")
        private String trackingShipDate;

        @JsonProperty("tracking_key")
        private String trackingKey;

        @JsonProperty("tracking_origin_country")
        private String trackingOriginCountry;

        @JsonProperty("tracking_destination_country")
        private String trackingDestinationCountry;

        @JsonProperty("tracking_state")
        private String trackingState;

        @JsonProperty("tracking_account_number")
        private String trackingAccountNumber;

        @JsonProperty("subtag")
        private String subtag;

        @JsonProperty("smses")
        private String[] smses;

        @JsonProperty("android")
        private String[] android;

        @JsonProperty("ios")
        private String[] ios;

        @JsonProperty("emails")
        private String[] emails;

        @JsonProperty("title")
        private String title;

        @JsonProperty("customer_name")
        private String customerName;

        @JsonProperty("origin_country_iso3")
        private String originCountryIso3;

        @JsonProperty("destination_country_ios3")
        private String destinationCountryIos3;

        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("order_id_path")
        private String orderIdPath;

        @JsonSetter("custom_fields")
        private Map<String,String> customFields;

        @JsonProperty("note")
        private String note;

        @JsonProperty("language")
        private String language;

        @JsonProperty("order_promised_delivery_date")
        private Date orderPromisedDeliveryDate;

        @JsonProperty("delivery_type")
        private String deliveryType;

        @JsonProperty("pickup_location")
        private String pickupLocation;

        @JsonProperty("pickup_note")
        private String pickupNote;


}
