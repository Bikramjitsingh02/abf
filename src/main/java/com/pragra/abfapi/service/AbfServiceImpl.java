package com.pragra.abfapi.service;


import com.pragra.abfapi.constants.SecurityConstants;
import com.pragra.abfapi.consumes.AbfClient;
import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.TrackingDto;
import com.pragra.abfapi.dto.TrackingRequestDto;
import com.pragra.abfapi.model.requestmodel.TrackingRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbfServiceImpl implements AbfService {

    @Autowired
    private AbfClient abfClient;

    @Override
    public ABFDto getCouriers() {
        return abfClient.getCouriers(SecurityConstants.AFTER_SHIP_API_KEY);
    }

    @Override
    public ABFDto getAllCouriers() {
        return  abfClient.getAllCouriers(SecurityConstants.AFTER_SHIP_API_KEY);
    }

    @Override
    public TrackingRequestDto createNewTracking(TrackingRequestDto trackingDto) {

        TrackingRequestDto newTrackingDto = abfClient.createNewTracking(SecurityConstants.AFTER_SHIP_API_KEY,trackingDto);
        return newTrackingDto;
    }


}
