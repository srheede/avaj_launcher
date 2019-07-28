package com.simulator.aircrafts;

import com.simulator.aircrafts.Aircraft;
import com.simulator.aircrafts.Coordinates;
import com.simulator.Simulator;
import com.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Baloon (String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        String comment = "";
        if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(
                coordinates.getLongitude(),
                coordinates.getLatitude(),
                coordinates.getHeight() - 5
            );
            comment = "Damn you rain! You messed up my baloon.";
        } else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(
                coordinates.getLongitude(),
                coordinates.getLatitude(),
                coordinates.getHeight() - 3
            );
            comment = "What a majestic, gloomy vibe.";
        } else if (weather.equals("SUN")){
            this.coordinates = new Coordinates(
                coordinates.getLongitude() + 2,
                coordinates.getLatitude(),
                coordinates.getHeight() + 4
            );
            comment = "Let's enjoy the good weather and take some pics.";
        } else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(
                coordinates.getLongitude(),
                coordinates.getLatitude(),
                coordinates.getHeight() - 15
            );
            comment = "It's snowing. We're  gonna crash.";
        }
        Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): " + comment);
        if (this.coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") landing.");
            Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}