package com.careerdevs.HelloInternet.Controllers;

//localhost - > 127.0.0.1
import com.careerdevs.HelloInternet.models.ApodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/apod")
public class NasaController {

    private final String myNasaKey ="mOLOeNIrhuIBqnwf4jqUGyfIwWoYjPnd29OTG1BS";
    private final String nasaApodEndpoint= "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;
    @Autowired
    private Environment env;
    //filed
    RestTemplate restTemplate;

    //URL/ endpoint:Get http://localhost:3535/api/apod/test
    @GetMapping("/test")
    private String testRoute(){
        return "testing, request";
    }

    //URL/ endpoint:Get http://localhost:3535/api/apod/today
    @GetMapping("/today")
    private ApodModel apodToday(RestTemplate restTemplate){
        //get the key
        String apodKey = env.getProperty("Apod_KEY","mOLOeNIrhuIBqnwf4jqUGyfIwWoYjPnd29OTG1BS");
        //built the URL
        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + apodKey;
        //make the request

       // ApodModel test = new ApodModel();
       ApodModel response = restTemplate.getForObject(URL,ApodModel.class);
        //return the data

        System.out.println("\n\nDate: "+ response.getDate());
        return response;
    }


    @GetMapping("/image")
    private String apodImage(
            RestTemplate restTemplate,
            @RequestParam("year") String year,
            @RequestParam("month") String month,
            @RequestParam("day") String day
    ){
        String date = year + "-" + month + "-" + day;
        //localhost:5000/v1/apod?api_key=DEMO_KEY&date=2014-10-01&concept_tags=True
        String apodKey = env.getProperty("Apod_KEY","mOLOeNIrhuIBqnwf4jqUGyfIwWoYjPnd29OTG1BS");
        //built the URL
        String URL = "https://api.nasa.gov/planetary/apod?";
        URL +="api_key=" + apodKey;
        URL +="&date=" + date;
        System.out.println(date);
        System.out.println(URL);

        ApodModel response = restTemplate.getForObject(URL,ApodModel.class);

        return response.getUrl();

    }

    @GetMapping("/welcome/{date}")
    public  void test(@PathVariable("date") String date){
        System.out.println("date " + date);
    }


}
