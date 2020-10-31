package com.pragra.abfapi.ws.consume;


import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.TrackingDto;
import com.pragra.abfapi.model.requestmodel.TrackingRequestModel;
import com.pragra.abfapi.model.responsemodel.TrackingRest;
import com.pragra.abfapi.service.AbfService;
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

    @GetMapping(path="/couriers",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public ABFDto  getCouriers(){
        ABFDto couriers=abfService.getCouriers();
        return couriers;
    }

    @GetMapping(path="/couriers/all",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public ABFDto  getAllCouriers(){
        ABFDto couriers=abfService.getAllCouriers();
        return couriers;
    }

    @PostMapping(path="/trackings",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public TrackingDto createNewTracking(@RequestBody TrackingRequestModel tracking){

        TrackingRest trackingRest=new TrackingRest();
        TrackingDto trackingDto=new TrackingDto();


        //ModelMapper mapper=new ModelMapper();
        //TrackingDto trackingDto=mapper.map(tracking,TrackingDto.class);
        //System.out.println(tracking);
        //System.out.println(trackingDto);
        System.out.println(tracking);

        return abfService.createNewTracking(trackingDto);
    }



}
