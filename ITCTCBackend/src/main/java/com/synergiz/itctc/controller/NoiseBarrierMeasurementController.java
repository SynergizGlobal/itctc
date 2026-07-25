package com.synergiz.itctc.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementRequest;
import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.NoiseBarrierMeasurementResponse;
import com.synergiz.itctc.service.NoiseBarrierMeasurementService;

@RestController
@RequestMapping("/api/noise-barrier-measurements")
//@CrossOrigin(origins = "*")
public class NoiseBarrierMeasurementController {

    private final NoiseBarrierMeasurementService noiseBarrierMeasurementService;

    public NoiseBarrierMeasurementController(
            NoiseBarrierMeasurementService noiseBarrierMeasurementService) {

        this.noiseBarrierMeasurementService = noiseBarrierMeasurementService;
    }


    @PostMapping
    public ResponseEntity<Long> saveNoiseBarrierMeasurement(
            @RequestBody NoiseBarrierMeasurementRequest request) {

        Long measurementId = noiseBarrierMeasurementService
                .saveNoiseBarrierMeasurement(request);

        return new ResponseEntity<>(measurementId, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NoiseBarrierMeasurementResponse> getNoiseBarrierMeasurement(
            @PathVariable Long id) {

        NoiseBarrierMeasurementResponse response =
                noiseBarrierMeasurementService
                        .getNoiseBarrierMeasurement(id);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<NoiseBarrierMeasurementResponse>> getAllNoiseBarrierMeasurements() {

        List<NoiseBarrierMeasurementResponse> response =
                noiseBarrierMeasurementService
                        .getAllNoiseBarrierMeasurements();

        return ResponseEntity.ok(response);
    }

 
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateNoiseBarrierMeasurement(
            @PathVariable Long id,
            @RequestBody NoiseBarrierMeasurementUpdateRequest request) {

        Long measurementId =
                noiseBarrierMeasurementService
                        .updateNoiseBarrierMeasurement(id, request);

        return ResponseEntity.ok(measurementId);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoiseBarrierMeasurement(
            @PathVariable Long id) {

        noiseBarrierMeasurementService
                .deleteNoiseBarrierMeasurement(id);

        return ResponseEntity.noContent().build();
    }

}