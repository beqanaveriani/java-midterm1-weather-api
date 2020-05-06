package beka.naveriani.weather.service.impl;

import beka.naveriani.weather.models.Weather;
import beka.naveriani.weather.service.WeatherService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeatherServiceImpl implements WeatherService {

    private static WeatherService service;
    private Map<String, Weather> weatherData = new HashMap<>();

    private WeatherServiceImpl(){
        weatherData.put("tbilisi", new Weather("Tbilisi", "70", "20", "15", "20", Weather.DirectionType.EAST));
        weatherData.put("batumi", new Weather("Batumi", "72", "25", "11", "20", Weather.DirectionType.WEST));
        weatherData.put("kutaisi", new Weather("Kutaisi", "71", "22", "12", "20", Weather.DirectionType.EAST));
    }

    @Override
    public List<Weather> getAllWeather() {
        return new ArrayList<>(weatherData.values());
    }

    @Override
    public Weather getWeatherByCity(String cityName) {
        Weather weather = weatherData.get(cityName.toLowerCase());
        if (weather == null) throw new RuntimeException("Invalid city name");
        return weather;
    }


    public static WeatherService getInstance(){
        if (service == null){
            service = new WeatherServiceImpl();
        }
        return service;
    }
}
