package com.pragra.abfapi.service;

import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.TrackingRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AbfService {

    public ABFDto getCouriers();
    public ABFDto getAllCouriers();
    public TrackingRequestDto createNewTracking(TrackingRequestDto trackingDto);
}
