package beka.naveriani.weather.service;

import beka.naveriani.weather.models.Weather;

import java.util.List;

public interface WeatherService {

    List<Weather> getAllWeather();

    Weather getWeatherByCity(String cityName);
}
