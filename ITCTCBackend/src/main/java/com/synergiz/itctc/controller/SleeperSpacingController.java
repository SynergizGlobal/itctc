package com.synergiz.itctc.controller;


import com.synergiz.itctc.dto.request.SleeperSpacingRequest;
import com.synergiz.itctc.dto.response.SleeperSpacingResponse;
import com.synergiz.itctc.service.SleeperSpacingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleeper-spacing")
@CrossOrigin("*")
public class SleeperSpacingController {

    private final SleeperSpacingService sleeperSpacingService;

    public SleeperSpacingController(
            SleeperSpacingService sleeperSpacingService) {

        this.sleeperSpacingService = sleeperSpacingService;
    }

  
    @PostMapping
    public ResponseEntity<Long> saveSleeperSpacing(
            @RequestBody SleeperSpacingRequest request) {

        Long id = sleeperSpacingService.saveSleeperSpacing(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

   
    @GetMapping("/{sleeperSpacingHeaderId}")
    public ResponseEntity<SleeperSpacingResponse> getSleeperSpacing(
            @PathVariable Long sleeperSpacingHeaderId) {

        SleeperSpacingResponse response =
                sleeperSpacingService.getSleeperSpacing(
                        sleeperSpacingHeaderId);

        return ResponseEntity.ok(response);
    }

    
    @GetMapping
    public ResponseEntity<List<SleeperSpacingResponse>>
    getAllSleeperSpacings() {

        List<SleeperSpacingResponse> response =
                sleeperSpacingService.getAllSleeperSpacings();

        return ResponseEntity.ok(response);
    }

 
    @PutMapping("/{sleeperSpacingHeaderId}")
    public ResponseEntity<Long> updateSleeperSpacing(
            @PathVariable Long sleeperSpacingHeaderId,
            @RequestBody SleeperSpacingRequest request) {

        Long id = sleeperSpacingService.updateSleeperSpacing(
                sleeperSpacingHeaderId,
                request);

        return ResponseEntity.ok(id);
    }

  
    @DeleteMapping("/{sleeperSpacingHeaderId}")
    public ResponseEntity<String> deleteSleeperSpacing(
            @PathVariable Long sleeperSpacingHeaderId,
            @RequestParam String updatedBy) {

        sleeperSpacingService.deleteSleeperSpacing(
                sleeperSpacingHeaderId,
                updatedBy);

        return ResponseEntity.ok("Sleeper Spacing deleted successfully.");
    }

}