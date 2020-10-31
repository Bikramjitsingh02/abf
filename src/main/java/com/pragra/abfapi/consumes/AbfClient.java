package com.pragra.abfapi.consumes;

import com.pragra.abfapi.dto.ABFDto;
import com.pragra.abfapi.dto.TrackingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "couriers" ,url = "https://api.aftership.com/v4")
public interface AbfClient{

    @RequestMapping(method = RequestMethod.GET, value = "/couriers")
    public ABFDto getCouriers(@RequestHeader(value = "aftership-api-key") String apikey);

    @RequestMapping(method = RequestMethod.GET, value = "/couriers/all")
    public ABFDto getAllCouriers(@RequestHeader(value = "aftership-api-key") String apikey);

    @RequestMapping(method = RequestMethod.POST,value="/trackings")
    public TrackingDto createNewTracking(@RequestHeader(value = "aftership-api-key") String apikey, @RequestBody TrackingDto tracking);

}
