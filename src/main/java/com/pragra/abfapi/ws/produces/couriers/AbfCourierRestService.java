package com.pragra.abfapi.ws.produces.couriers;


import com.aftership.sdk.AfterShip;
import com.aftership.sdk.model.courier.CourierDetectList;
import com.aftership.sdk.model.courier.CourierList;
import com.aftership.sdk.model.tracking.Tracking;
import com.pragra.abfapi.abfutils.CommonUtils;
import com.pragra.abfapi.abfutils.Courier.DetectCouriers;
import com.pragra.abfapi.abfutils.Courier.ListAllCouriers;
import com.pragra.abfapi.abfutils.Courier.ListCouriers;
import com.pragra.abfapi.abfutils.tracking.CreateTracking;
import com.pragra.abfapi.abfutils.tracking.DeleteTracking;
import com.pragra.abfapi.constants.EndpointPath;
import com.pragra.abfapi.constants.SecurityConstants;
import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.CourierDetectListDto;
import com.pragra.abfapi.dto.TrackingRequestDto;
import com.pragra.abfapi.model.requestmodel.DetectCourierRequestModel;
import com.pragra.abfapi.model.requestmodel.TrackingRequestModel;
import com.pragra.abfapi.service.AbfService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbfCourierRestService {

    @Autowired
    private AbfService abfService;


    @GetMapping(path= EndpointPath.COURIERS,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public CourierList  getCouriers(){
        AfterShip afterShip=new AfterShip(CommonUtils.getEnvApiKey(),CommonUtils.getAfterShipOption());
        ListCouriers listCouriers=new ListCouriers();
        CourierList courierList = null ;
        try {
            courierList= listCouriers.listCouriers(afterShip);
            System.out.println(courierList);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        ModelMapper mapper=new ModelMapper();
        ABFDto abfDto=mapper.map(courierList,ABFDto.class);
        return  courierList;
    }

    @GetMapping(path=EndpointPath.LIST_ALL_COURIERS,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public CourierList  getAllCouriers(){

        AfterShip afterShip=new AfterShip(CommonUtils.getEnvApiKey(),CommonUtils.getAfterShipOption());
        ListAllCouriers listCouriers= new ListAllCouriers();
        CourierList courierList = null ;
        try{
            courierList = listCouriers.listAllCouriers(afterShip);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        ModelMapper mapper=new ModelMapper();
        ABFDto abfDto=mapper.map(courierList,ABFDto.class);
        System.out.println(abfDto);
        return courierList;
    }


    @PostMapping(path=EndpointPath.DETECT_COURIERS,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public CourierDetectListDto detectCouriers(@RequestBody DetectCourierRequestModel tracking){

        AfterShip afterShip = new AfterShip(CommonUtils.getEnvApiKey(),CommonUtils.getAfterShipOption());
        DetectCouriers detectCouriers= new DetectCouriers();

        CourierDetectList courierDetectList = new CourierDetectList();

        try{
            System.out.println(tracking);
            courierDetectList = detectCouriers.detectCourier(afterShip,tracking.getTracking().getTrackingNumber());
            ModelMapper mapper = new ModelMapper();
            CourierDetectListDto courierDetectListDto = mapper.map(courierDetectList,CourierDetectListDto.class);

            return courierDetectListDto;

        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

        return null;
    }

    @PostMapping(path=EndpointPath.CREATE_TRACKING,
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public TrackingRequestDto createNewTracking(@RequestBody TrackingRequestModel tracking){
        AfterShip afterShip=new AfterShip(SecurityConstants.AFTER_SHIP_API_KEY,CommonUtils.getAfterShipOption());
        CreateTracking createTracking = new CreateTracking();

        ModelMapper mapper=new ModelMapper();
        TrackingRequestDto trackingDto=mapper.map(tracking,TrackingRequestDto.class);
        try {
            // createTracking.createTracking(afterShip, trackingDto);
            ListCouriers couriers=new ListCouriers();
            couriers.listCouriers(afterShip);
            System.out.println(couriers);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return abfService.createNewTracking(trackingDto);
    }

    
    @PostMapping(path=EndpointPath.DELETE_TRACKING,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public Tracking deleteTracking(@RequestBody TrackingRequestDto trackingDto){

        AfterShip afterShip=new AfterShip(SecurityConstants.AFTER_SHIP_API_KEY,CommonUtils.getAfterShipOption());
        String trackingNumber = trackingDto.getTracking().getTrackingNumber();
        DeleteTracking deleteTracking = new DeleteTracking();
        Tracking tracking = deleteTracking.deleteTracking(afterShip,trackingNumber);
        return tracking;

    }

}