package com.pragra.abfapi.abfutils.tracking;

import com.aftership.sdk.AfterShip;
import com.aftership.sdk.exception.AftershipException;
import com.aftership.sdk.model.courier.CourierList;
import com.pragra.abfapi.constants.EndpointPath;

public class ListCouriers {

    public  CourierList listCouriers(AfterShip afterShip){
        System.out.println(EndpointPath.LIST_COURIERS);
        try {
            CourierList courierList = afterShip.getCourierEndpoint().listCouriers();
            System.out.println(courierList.getTotal());
            System.out.println(courierList.getCouriers().get(0).getName());
            return courierList;
        } catch (AftershipException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }


}
