package ru.hammer2000.restapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {

    @Min(value = -100, message = "Температура не может быть ниже -100")
    @Max(value = 100, message = "Температура не может быть выше 100")
    @NotNull(message = "Значение не может быть пустым")
    Double value;

    @NotNull(message = "Значение не может быть пустым")
    Boolean raining;

    @NotNull(message = "Значение не может быть пустым")
    SensorDTO sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
