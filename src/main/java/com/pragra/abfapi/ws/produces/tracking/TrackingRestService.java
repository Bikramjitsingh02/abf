package com.pragra.abfapi.ws.produces.tracking;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.model.tracking.Tracking;
import com.pragra.abfapi.abfutils.CommonUtils;
import com.pragra.abfapi.abfutils.Courier.ListCouriers;
import com.pragra.abfapi.abfutils.tracking.CreateTracking;
import com.pragra.abfapi.abfutils.tracking.DeleteTracking;
import com.pragra.abfapi.constants.EndpointPath;
import com.pragra.abfapi.constants.SecurityConstants;
import com.pragra.abfapi.model.requestmodel.TrackingRequestModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrackingRestService {

    private AfterShip afterShip;

    TrackingRestService(){
         this.afterShip=new AfterShip(SecurityConstants.AFTER_SHIP_API_KEY,CommonUtils.getAfterShipOption());
    }

    @PostMapping(path= EndpointPath.CREATE_TRACKING,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Tracking createNewTracking(@RequestBody TrackingRequestModel tracking){
        AfterShip afterShip=new AfterShip(SecurityConstants.AFTER_SHIP_API_KEY, CommonUtils.getAfterShipOption());
        CreateTracking createTracking = new CreateTracking();
        try {
            Tracking newTracking = createTracking.createTracking(afterShip, tracking);
            ListCouriers couriers=new ListCouriers();
            couriers.listCouriers(afterShip);
            System.out.println(couriers);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return  null;
    }


    @PostMapping(path=EndpointPath.DELETE_TRACKING,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Tracking deleteTracking(@RequestBody TrackingRequestModel trackingModel){


        //AfterShip afterShip=new AfterShip(SecurityConstants.AFTER_SHIP_API_KEY,CommonUtils.getAfterShipOption());

        String trackingNumber = trackingModel.getTracking().getTrackingNumber();
        DeleteTracking deleteTracking = new DeleteTracking();
        Tracking tracking = deleteTracking.deleteTracking(this.afterShip,trackingNumber);
        return tracking;

    }
}
