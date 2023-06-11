package ru.hammer2000.restapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.hammer2000.restapi.models.Measurement;
import ru.hammer2000.restapi.models.Sensor;
import ru.hammer2000.restapi.services.SensorsService;

import java.util.Optional;

@Component
public class MeasurementValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Measurement.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Measurement measurement = (Measurement) o;

        Optional<Sensor> sensor = sensorsService.existingSensor(measurement.getSensor());

        if (sensor.isEmpty()) {
            errors.rejectValue("sensor", "",
                    "Сенсора с таким названием не существует");
        }
    }
}