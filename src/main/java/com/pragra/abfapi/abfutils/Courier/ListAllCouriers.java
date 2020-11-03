package com.pragra.abfapi.abfutils.Courier;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.exception.AftershipException;
import com.aftership.sdk.model.courier.CourierList;
import com.pragra.abfapi.constants.EndpointPath;

public class ListAllCouriers {


    public CourierList listAllCouriers(AfterShip afterShip){

        System.out.println(EndpointPath.LIST_ALL_COURIERS);
        try{

            CourierList courierList = afterShip.getCourierEndpoint().listAllCouriers();
            System.out.println(courierList.getTotal());
            System.out.println(courierList.getCouriers());

            return courierList;
        }
        catch (AftershipException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
