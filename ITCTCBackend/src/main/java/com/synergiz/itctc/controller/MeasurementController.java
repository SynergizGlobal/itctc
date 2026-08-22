package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.MeasurementRequest;
import com.synergiz.itctc.dto.request.MeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.MeasurementResponse;
import com.synergiz.itctc.service.MeasurementService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/measurements")
//@CrossOrigin(origins = "*")
public class MeasurementController {

	private final MeasurementService measurementService;

	public MeasurementController(MeasurementService measurementService) {
		this.measurementService = measurementService;
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Long> saveMeasurement(@RequestPart("request") MeasurementRequest request,
			@RequestPart(value = "selfie", required = false) MultipartFile selfie,
			@RequestPart(value = "attachments", required = false) List<MultipartFile> attachments) {

		Long measurementId = measurementService.saveMeasurement(request, selfie, attachments);

		return new ResponseEntity<>(measurementId, HttpStatus.CREATED);
	}

	@GetMapping("/{measurementId}")
	public ResponseEntity<MeasurementResponse> getMeasurement(@PathVariable Long measurementId) {

		MeasurementResponse response = measurementService.getMeasurement(measurementId);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/all")
	public ResponseEntity<List<MeasurementResponse>> getAllMeasurements() {

		List<MeasurementResponse> measurements = measurementService.getAllMeasurements();

		return ResponseEntity.ok(measurements);
	}

	@PutMapping(value = "/{measurementId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Long> updateMeasurement(@PathVariable Long measurementId,

			@RequestPart("request") MeasurementUpdateRequest request,

			@RequestPart(value = "selfie", required = false) MultipartFile selfie,

			@RequestPart(value = "attachments", required = false) List<MultipartFile> attachments) {

		Long updatedId = measurementService.updateMeasurement(measurementId, request, selfie, attachments);

		return ResponseEntity.ok(updatedId);
	}

	@DeleteMapping("/{measurementId}")
	public ResponseEntity<Long> deleteMeasurement(@PathVariable Long measurementId) {

		Long deletedId = measurementService.deleteMeasurement(measurementId);

		return ResponseEntity.ok(deletedId);
	}
}