package com.HenryNews.base.controller;

import com.HenryNews.base.model.response.ApiWeatherResponse;
import com.HenryNews.base.service.ApiCallService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api")
public class ApiCallController {

    @Autowired
    ApiCallService apiCallService;

    @GetMapping
    @Operation(summary = "Endpoints APi del Clima")
    public Object callApi(){
        try{
            ApiWeatherResponse apiWeatherResponse = apiCallService.callApi();

            if(apiWeatherResponse.getLocation() == null){
                return apiCallService.callAPI2();
            }
            else{
                return apiWeatherResponse;
            }
        }
        catch (IOException | InterruptedException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
