package com.pragra.abfapi.ws.produces.couriers;


import com.aftership.sdk.AfterShip;
import com.aftership.sdk.model.courier.CourierDetectList;
import com.aftership.sdk.model.courier.CourierList;
import com.pragra.abfapi.abfutils.CommonUtils;
import com.pragra.abfapi.abfutils.Courier.DetectCouriers;
import com.pragra.abfapi.abfutils.Courier.ListAllCouriers;
import com.pragra.abfapi.abfutils.Courier.ListCouriers;
import com.pragra.abfapi.constants.EndpointPath;
import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.CourierDetectListDto;
import com.pragra.abfapi.model.requestmodel.DetectCourierRequestModel;
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

    private AfterShip afterShip ;

    AbfCourierRestService(){
        this.afterShip = new AfterShip(CommonUtils.getEnvApiKey(),CommonUtils.getAfterShipOption());
    }


    @GetMapping(path= EndpointPath.COURIERS,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public CourierList  getCouriers(){
        ListCouriers listCouriers=new ListCouriers();
        CourierList courierList = null ;
        try {
            courierList= listCouriers.listCouriers(this.afterShip);
            System.out.println(courierList);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return  courierList;
    }

    @GetMapping(path=EndpointPath.LIST_ALL_COURIERS,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public CourierList  getAllCouriers(){

        ListAllCouriers listCouriers= new ListAllCouriers();
        CourierList courierList = null ;
        try{
            courierList = listCouriers.listAllCouriers(this.afterShip);

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



}
