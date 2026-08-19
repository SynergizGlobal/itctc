package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synergiz.itctc.dto.request.C4StructureGaugeRequest;
import com.synergiz.itctc.dto.response.C4StructureGaugeResponse;
import com.synergiz.itctc.service.C4StructureGaugeService;

@RestController
@RequestMapping("/api/c4-structure-Gauge")
public class C4StructureGaugeController {

	private final C4StructureGaugeService c4StructureGaugeService;

	public C4StructureGaugeController(C4StructureGaugeService c4StructureGaugeService) {
		this.c4StructureGaugeService = c4StructureGaugeService;
	}

	// =========================================================
	// CREATE
	// =========================================================

	@PostMapping
	public ResponseEntity<C4StructureGaugeResponse> saveC4StructureGauge(@RequestBody C4StructureGaugeRequest request) {

		return ResponseEntity.ok(c4StructureGaugeService.saveC4StructureGauge(request));
	}

	// =========================================================
	// GET BY ID
	// =========================================================

	@GetMapping("/{c4StructureGaugeId}")
	public ResponseEntity<C4StructureGaugeResponse> getC4StructureGauge(@PathVariable Long c4StructureGaugeId) {

		return ResponseEntity.ok(c4StructureGaugeService.getC4StructureGauge(c4StructureGaugeId));
	}

	// =========================================================
	// GET ALL
	// =========================================================

	@GetMapping
	public ResponseEntity<List<C4StructureGaugeResponse>> getAllC4StructureGauge() {

		return ResponseEntity.ok(c4StructureGaugeService.getAllC4StructureGauge());
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@PutMapping("/{c4StructureGaugeId}")
	public ResponseEntity<C4StructureGaugeResponse> updateC4StructureGauge(@PathVariable Long c4StructureGaugeId,
			@RequestBody C4StructureGaugeRequest request) {

		return ResponseEntity.ok(c4StructureGaugeService.updateC4StructureGauge(c4StructureGaugeId, request));
	}

	// =========================================================
	// DELETE - SOFT DELETE
	// =========================================================

	@DeleteMapping("/{c4StructureGaugeId}")
	public ResponseEntity<String> deleteC4StructureGauge(@PathVariable Long c4StructureGaugeId,
			@RequestParam String updatedBy) {

		return ResponseEntity.ok(c4StructureGaugeService.deleteC4StructureGauge(c4StructureGaugeId, updatedBy));
	}

}
