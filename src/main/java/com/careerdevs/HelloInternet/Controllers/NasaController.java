package com.careerdevs.HelloInternet.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaController {

    private final String myNasaKey ="mOLOeNIrhuIBqnwf4jqUGyfIwWoYjPnd29OTG1BS";
    private final String nasaApodEndpoint= "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;
    @Autowired
    //filed
    RestTemplate restTemplate;


    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate){
        return restTemplate.getForObject(nasaApodEndpoint,Object.class);
    }
    @GetMapping("/welcome/{date}")
    public  void test(@PathVariable("date") String date){
        System.out.println("date" + date);
    }


}
