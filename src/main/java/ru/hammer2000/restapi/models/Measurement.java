package ru.hammer2000.restapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "measurement")
public class Measurement implements Serializable {
    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull(message = "Значение не может быть пустым")
    @Min(value = -100, message = "Температура не может быть ниже -100")
    @Max(value = 100, message = "Температура не может быть выше 100")
    private Double value;

    @NotNull(message = "Значение не может быть пустым")
    private Boolean raining;

    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measurementTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(Double value, Boolean raining, Date measurementTime, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.measurementTime = measurementTime;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(Date measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
