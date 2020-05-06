package beka.naveriani.weather.controller;

import beka.naveriani.weather.models.Weather;
import beka.naveriani.weather.service.WeatherService;
import beka.naveriani.weather.service.impl.WeatherServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weather")
public class WeatherController {

    WeatherService weatherService = WeatherServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getAllWeather(){
        return weatherService.getAllWeather();
    }


    @GET
    @Path("{cityName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeatherByCity(@PathParam("cityName") String cityName){
        return weatherService.getWeatherByCity(cityName);
    }

}
