package com.simulator.aircrafts;

import com.simulator.aircrafts.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 0;

    protected Aircraft (String name, Coordinates coordinates){
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId(){
        return (++this.idCounter);
    }
}