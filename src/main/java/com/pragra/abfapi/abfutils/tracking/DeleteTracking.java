package com.pragra.abfapi.abfutils.tracking;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.exception.AftershipException;
import com.aftership.sdk.model.tracking.Tracking;
import com.pragra.abfapi.constants.EndpointPath;

public class DeleteTracking {

    public Tracking deleteTracking(AfterShip afterShip ,String trackingNumber){
            System.out.println(EndpointPath.DELETE_TRACKING);
            String id = trackingNumber;
            try{
                    Tracking tracking = afterShip.getTrackingEndpoint().deleteTracking(id);
                    return tracking;
            }catch (AftershipException exception){
                        System.out.println(exception.getMessage());
            }

            return null;
    }

}
