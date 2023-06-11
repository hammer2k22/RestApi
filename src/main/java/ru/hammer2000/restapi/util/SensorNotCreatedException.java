package ru.hammer2000.restapi.util;

public class SensorNotCreatedException extends RuntimeException{

    public SensorNotCreatedException(String message){
        super(message);
    }
}
