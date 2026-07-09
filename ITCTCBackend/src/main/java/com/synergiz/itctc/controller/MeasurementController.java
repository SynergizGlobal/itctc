package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.MeasurementRequest;
import com.synergiz.itctc.dto.request.MeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.MeasurementResponse;
import com.synergiz.itctc.service.MeasurementService;

@RestController
@RequestMapping("/api/measurements")
@CrossOrigin(origins = "*")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    public ResponseEntity<Long> saveMeasurement(@RequestBody MeasurementRequest request) {

        Long measurementId = measurementService.saveMeasurement(request);

        return new ResponseEntity<>(measurementId, HttpStatus.CREATED);
    }
    
    @GetMapping("/{measurementId}")
    public ResponseEntity<MeasurementResponse> getMeasurement(
            @PathVariable Long measurementId) {

        MeasurementResponse response = measurementService.getMeasurement(measurementId);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<MeasurementResponse>> getAllMeasurements() {

        List<MeasurementResponse> measurements = measurementService.getAllMeasurements();

        return ResponseEntity.ok(measurements);
    }
    
    @PutMapping("/{measurementId}")
    public ResponseEntity<Long> updateMeasurement(
            @PathVariable Long measurementId,
            @RequestBody MeasurementUpdateRequest request) {

        Long updatedId = measurementService.updateMeasurement(measurementId, request);

        return ResponseEntity.ok(updatedId);
    }
    
    @DeleteMapping("/{measurementId}")
    public ResponseEntity<Long> deleteMeasurement(@PathVariable Long measurementId) {

        Long deletedId = measurementService.deleteMeasurement(measurementId);

        return ResponseEntity.ok(deletedId);
    }
}