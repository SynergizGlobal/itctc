package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.C2FormationWidthTunnelRequest;
import com.synergiz.itctc.dto.response.C2FormationWidthTunnelResponse;
import com.synergiz.itctc.service.C2FormationWidthTunnelService;

@RestController
@RequestMapping("/api/c2-formation-width-tunnel")
public class C2FormationWidthTunnelController {

	private final C2FormationWidthTunnelService c2FormationWidthTunnelService;

	public C2FormationWidthTunnelController(C2FormationWidthTunnelService c2FormationWidthTunnelService) {

		this.c2FormationWidthTunnelService = c2FormationWidthTunnelService;
	}

	// =========================================================
	// CREATE
	// =========================================================

	@PostMapping
	public ResponseEntity<C2FormationWidthTunnelResponse> saveC2FormationWidthTunnel(
			@RequestBody C2FormationWidthTunnelRequest request) {

		return ResponseEntity.ok(c2FormationWidthTunnelService.saveC2FormationWidthTunnel(request));
	}

	// =========================================================
	// GET BY ID
	// =========================================================

	@GetMapping("/{c2FormationWidthTunnelId}")
	public ResponseEntity<C2FormationWidthTunnelResponse> getC2FormationWidthTunnel(
			@PathVariable Long c2FormationWidthTunnelId) {

		return ResponseEntity.ok(c2FormationWidthTunnelService.getC2FormationWidthTunnel(c2FormationWidthTunnelId));
	}

	// =========================================================
	// GET ALL
	// =========================================================

	@GetMapping
	public ResponseEntity<List<C2FormationWidthTunnelResponse>> getAllC2FormationWidthTunnels() {

		return ResponseEntity.ok(c2FormationWidthTunnelService.getAllC2FormationWidthTunnels());
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@PutMapping("/{c2FormationWidthTunnelId}")
	public ResponseEntity<C2FormationWidthTunnelResponse> updateC2FormationWidthTunnel(
			@PathVariable Long c2FormationWidthTunnelId, @RequestBody C2FormationWidthTunnelRequest request) {

		return ResponseEntity
				.ok(c2FormationWidthTunnelService.updateC2FormationWidthTunnel(c2FormationWidthTunnelId, request));
	}

	// =========================================================
	// DELETE - SOFT DELETE
	// =========================================================

	@DeleteMapping("/{c2FormationWidthTunnelId}")
	public ResponseEntity<String> deleteC2FormationWidthTunnel(@PathVariable Long c2FormationWidthTunnelId,
			@RequestParam String updatedBy) {

		c2FormationWidthTunnelService.deleteC2FormationWidthTunnel(c2FormationWidthTunnelId, updatedBy);

		return ResponseEntity.ok("C2 Formation Width Tunnel measurement deleted successfully.");
	}
}