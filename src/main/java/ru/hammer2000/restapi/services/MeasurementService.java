package ru.hammer2000.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hammer2000.restapi.models.Measurement;
import ru.hammer2000.restapi.repositories.MeasurementRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorsService sensorsService) {
        this.measurementRepository = measurementRepository;
        this.sensorsService = sensorsService;
    }

    public List<Measurement> findAll() {
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }

    @Transactional
    public void save(Measurement measurement) {

        measurement.setMeasurementTime(new Date());
        measurement.setSensor(sensorsService.findByName(measurement.getSensor().getName()).get());
        measurementRepository.save(measurement);
    }

    public Integer getRainyDaysCount() {
        return (int)findAll().stream().filter(Measurement::getRaining).count();
    }
}
