package com.pragra.abfapi.abfutils.Courier;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.exception.AftershipException;
import com.aftership.sdk.model.courier.CourierDetectList;
import com.aftership.sdk.model.courier.CourierDetectRequest;
import com.aftership.sdk.model.courier.CourierDetectTracking;
import com.pragra.abfapi.constants.EndpointPath;

public class DetectCouriers {

    public CourierDetectList detectCourier(AfterShip afterShip,String trackingNumber){
        System.out.println(EndpointPath.DETECT_COURIERS);

        CourierDetectTracking tracking = new CourierDetectTracking();
        tracking.setTrackingNumber(trackingNumber);
        CourierDetectRequest courierDetectRequest = new CourierDetectRequest(tracking);

        try {
            CourierDetectList courierDetectList =
                    afterShip.getCourierEndpoint().detectCouriers(courierDetectRequest.getTracking());
            System.out.println(courierDetectList.getTotal());
            System.out.println(courierDetectList.getCouriers());

            return courierDetectList;

        } catch (AftershipException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


}
