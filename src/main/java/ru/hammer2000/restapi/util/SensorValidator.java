package ru.hammer2000.restapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.hammer2000.restapi.models.Sensor;
import ru.hammer2000.restapi.services.SensorsService;

import java.util.Optional;

@Component
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Sensor.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {

        Sensor newSensor = (Sensor) o;

        Optional<Sensor> sensor = sensorsService.existingSensor(newSensor);

        if (sensor.isPresent()) {
            errors.rejectValue("name", "",
                    "Сенсор с таким названием уже существует");
        }
    }
}