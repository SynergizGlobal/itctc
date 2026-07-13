package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.CamMeasurementRequest;
import com.synergiz.itctc.dto.response.CamMeasurementResponse;
import com.synergiz.itctc.service.CamMeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cam-measurements")
@CrossOrigin("*")
public class CamMeasurementController {

    private final CamMeasurementService camMeasurementService;

    public CamMeasurementController(
            CamMeasurementService camMeasurementService) {
        this.camMeasurementService = camMeasurementService;
    }

    /**
     * Save CAM Measurement
     */
    @PostMapping
    public ResponseEntity<Long> saveCamMeasurement(
            @RequestBody CamMeasurementRequest request) {

        Long id = camMeasurementService.saveCamMeasurement(request);

        return ResponseEntity.ok(id);
    }

    /**
     * Get CAM Measurement By Id
     */
    @GetMapping("/{camMeasurementHeaderId}")
    public ResponseEntity<CamMeasurementResponse> getCamMeasurement(
            @PathVariable Long camMeasurementHeaderId) {

        return ResponseEntity.ok(
                camMeasurementService.getCamMeasurement(camMeasurementHeaderId));
    }

    /**
     * Get All CAM Measurements
     */
    @GetMapping
    public ResponseEntity<List<CamMeasurementResponse>> getAllCamMeasurements() {

        return ResponseEntity.ok(
                camMeasurementService.getAllCamMeasurements());
    }

    /**
     * Update CAM Measurement
     */
    @PutMapping("/{camMeasurementHeaderId}")
    public ResponseEntity<Long> updateCamMeasurement(
            @PathVariable Long camMeasurementHeaderId,
            @RequestBody CamMeasurementRequest request) {

        Long id = camMeasurementService.updateCamMeasurement(
                camMeasurementHeaderId,
                request);

        return ResponseEntity.ok(id);
    }

    /**
     * Soft Delete CAM Measurement
     */
    @DeleteMapping("/{camMeasurementHeaderId}")
    public ResponseEntity<String> deleteCamMeasurement(
            @PathVariable Long camMeasurementHeaderId,
            @RequestParam String updatedBy) {

        camMeasurementService.deleteCamMeasurement(
                camMeasurementHeaderId,
                updatedBy);

        return ResponseEntity.ok("CAM Measurement deleted successfully.");
    }
}