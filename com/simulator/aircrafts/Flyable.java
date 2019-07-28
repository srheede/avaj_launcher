package com.simulator.aircrafts;

import com.simulator.WeatherTower;;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}