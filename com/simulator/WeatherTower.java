package com.simulator;

import com.simulator.aircrafts.Coordinates;
import com.simulator.weather.WeatherProvider;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather(){
        this.conditionChanged();
    }
}