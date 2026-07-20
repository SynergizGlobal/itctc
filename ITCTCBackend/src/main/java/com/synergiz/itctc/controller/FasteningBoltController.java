package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.FasteningBoltRequest;
import com.synergiz.itctc.dto.response.FasteningBoltResponse;
import com.synergiz.itctc.service.FasteningBoltService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fastening-bolt")
@CrossOrigin("*")
public class FasteningBoltController {

    private final FasteningBoltService fasteningBoltService;

    public FasteningBoltController(
            FasteningBoltService fasteningBoltService) {

        this.fasteningBoltService = fasteningBoltService;
    }


    @PostMapping
    public ResponseEntity<Long> saveFasteningBolt(
            @RequestBody FasteningBoltRequest request) {

        Long id = fasteningBoltService.saveFasteningBolt(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @GetMapping("/{fasteningBoltHeaderId}")
    public ResponseEntity<FasteningBoltResponse> getFasteningBolt(
            @PathVariable Long fasteningBoltHeaderId) {

        FasteningBoltResponse response =
                fasteningBoltService.getFasteningBolt(fasteningBoltHeaderId);

        return ResponseEntity.ok(response);
    }

  
    @GetMapping
    public ResponseEntity<List<FasteningBoltResponse>> getAllFasteningBolts() {

        List<FasteningBoltResponse> response =
                fasteningBoltService.getAllFasteningBolts();

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{fasteningBoltHeaderId}")
    public ResponseEntity<Long> updateFasteningBolt(
            @PathVariable Long fasteningBoltHeaderId,
            @RequestBody FasteningBoltRequest request) {

        Long id = fasteningBoltService.updateFasteningBolt(
                fasteningBoltHeaderId,
                request);

        return ResponseEntity.ok(id);
    }

  
    @DeleteMapping("/{fasteningBoltHeaderId}")
    public ResponseEntity<String> deleteFasteningBolt(
            @PathVariable Long fasteningBoltHeaderId,
            @RequestParam String updatedBy) {

        fasteningBoltService.deleteFasteningBolt(
                fasteningBoltHeaderId,
                updatedBy);

        return ResponseEntity.ok(
                "Fastening Bolt Measurement deleted successfully.");
    }
}