package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.SyntheticResinInjectionRequest;
import com.synergiz.itctc.dto.response.SyntheticResinInjectionResponse;
import com.synergiz.itctc.service.SyntheticResinInjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/synthetic-resin-injection")
//@CrossOrigin("*")
public class SyntheticResinInjectionController {

    private final SyntheticResinInjectionService syntheticResinInjectionService;

    public SyntheticResinInjectionController(
            SyntheticResinInjectionService syntheticResinInjectionService) {

        this.syntheticResinInjectionService = syntheticResinInjectionService;
    }

    /**
     * Save Synthetic Resin Injection
     */
    @PostMapping
    public ResponseEntity<Long> saveSyntheticResinInjection(
            @RequestBody SyntheticResinInjectionRequest request) {

        Long id = syntheticResinInjectionService
                .saveSyntheticResinInjection(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Get Synthetic Resin Injection By Id
     */
    @GetMapping("/{syntheticResinInjectionHeaderId}")
    public ResponseEntity<SyntheticResinInjectionResponse>
    getSyntheticResinInjection(
            @PathVariable Long syntheticResinInjectionHeaderId) {

        SyntheticResinInjectionResponse response =
                syntheticResinInjectionService.getSyntheticResinInjection(
                        syntheticResinInjectionHeaderId);

        return ResponseEntity.ok(response);
    }

    /**
     * Get All Synthetic Resin Injection
     */
    @GetMapping
    public ResponseEntity<List<SyntheticResinInjectionResponse>>
    getAllSyntheticResinInjections() {

        List<SyntheticResinInjectionResponse> response =
                syntheticResinInjectionService
                        .getAllSyntheticResinInjections();

        return ResponseEntity.ok(response);
    }

    /**
     * Update Synthetic Resin Injection
     */
    @PutMapping("/{syntheticResinInjectionHeaderId}")
    public ResponseEntity<Long> updateSyntheticResinInjection(
            @PathVariable Long syntheticResinInjectionHeaderId,
            @RequestBody SyntheticResinInjectionRequest request) {

        Long id = syntheticResinInjectionService
                .updateSyntheticResinInjection(
                        syntheticResinInjectionHeaderId,
                        request);

        return ResponseEntity.ok(id);
    }

    /**
     * Delete Synthetic Resin Injection
     */
    @DeleteMapping("/{syntheticResinInjectionHeaderId}")
    public ResponseEntity<String> deleteSyntheticResinInjection(
            @PathVariable Long syntheticResinInjectionHeaderId,
            @RequestParam String updatedBy) {

        syntheticResinInjectionService
                .deleteSyntheticResinInjection(
                        syntheticResinInjectionHeaderId,
                        updatedBy);

        return ResponseEntity.ok(
                "Synthetic Resin Injection deleted successfully.");
    }
}