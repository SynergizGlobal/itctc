package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.C0ElevationClearanceRequest;
import com.synergiz.itctc.dto.response.C0ElevationClearanceResponse;
import com.synergiz.itctc.service.C0ElevationClearanceService;

@RestController
@RequestMapping("/api/c0-elevation-clearance")
public class C0ElevationClearanceController {

	private final C0ElevationClearanceService c0ElevationClearanceService;

	public C0ElevationClearanceController(C0ElevationClearanceService c0ElevationClearanceService) {

		this.c0ElevationClearanceService = c0ElevationClearanceService;
	}

	// =====================================================
	// CREATE
	// =====================================================

	@PostMapping
	public ResponseEntity<C0ElevationClearanceResponse> saveC0ElevationClearance(
			@RequestBody C0ElevationClearanceRequest request) {

		C0ElevationClearanceResponse response = c0ElevationClearanceService.saveC0ElevationClearance(request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// =====================================================
	// GET BY ID
	// =====================================================

	@GetMapping("/{c0ElevationClearanceId}")
	public ResponseEntity<C0ElevationClearanceResponse> getC0ElevationClearance(
	        @PathVariable Long c0ElevationClearanceId) {

	    return ResponseEntity.ok(
	            c0ElevationClearanceService
	                    .getC0ElevationClearance(c0ElevationClearanceId));
	}

	// =====================================================
	// GET ALL
	// =====================================================

	@GetMapping
	public ResponseEntity<List<C0ElevationClearanceResponse>> getAllC0ElevationClearances() {

		List<C0ElevationClearanceResponse> responses = c0ElevationClearanceService.getAllC0ElevationClearances();

		return ResponseEntity.ok(responses);
	}

	// =====================================================
	// UPDATE
	// =====================================================

	@PutMapping("/{c0ElevationClearanceId}")
	public ResponseEntity<C0ElevationClearanceResponse> updateC0ElevationClearance(
			@PathVariable Long c0ElevationClearanceId, @RequestBody C0ElevationClearanceRequest request) {

		C0ElevationClearanceResponse response = c0ElevationClearanceService
				.updateC0ElevationClearance(c0ElevationClearanceId, request);

		return ResponseEntity.ok(response);
	}

	// =====================================================
	// DELETE
	// =====================================================

	@DeleteMapping("/{c0ElevationClearanceId}")
	public ResponseEntity<String> deleteC0ElevationClearance(@PathVariable Long c0ElevationClearanceId,
			@RequestParam String updatedBy) {

		c0ElevationClearanceService.deleteC0ElevationClearance(c0ElevationClearanceId, updatedBy);

		return ResponseEntity.ok("C0 Elevation Clearance deleted successfully.");
	}
}