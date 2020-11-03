package com.pragra.abfapi.abfutils.tracking;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.exception.AftershipException;
import com.aftership.sdk.exception.ApiException;
import com.aftership.sdk.exception.RequestException;
import com.aftership.sdk.exception.SdkException;
import com.aftership.sdk.model.tracking.NewTracking;
import com.aftership.sdk.model.tracking.Tracking;
import com.pragra.abfapi.dto.TrackingRequestDto;
import org.modelmapper.ModelMapper;

public class CreateTracking {


    public  void createTracking(AfterShip afterShip,TrackingRequestDto trackingDto) throws RequestException, ApiException, SdkException {

        NewTracking  newTracking = new  NewTracking();
        ModelMapper mapper = new ModelMapper();
        newTracking = mapper.map(trackingDto,NewTracking.class);

        try {
            Tracking tracking = afterShip.getTrackingEndpoint().createTracking(newTracking);

            System.out.println("New Tracking has been created. ");
            System.out.println(tracking);
        }catch (AftershipException e ){
                System.out.println(e.getMessage());
        }

    }



}
