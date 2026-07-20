package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.FoulingMarkRequest;
import com.synergiz.itctc.dto.response.FoulingMarkResponse;
import com.synergiz.itctc.service.FoulingMarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fouling-mark")
@CrossOrigin("*")
public class FoulingMarkController {

    private final FoulingMarkService foulingMarkService;

    public FoulingMarkController(
            FoulingMarkService foulingMarkService) {

        this.foulingMarkService = foulingMarkService;
    }


    @PostMapping
    public ResponseEntity<Long> saveFoulingMark(
            @RequestBody FoulingMarkRequest request) {

        Long id = foulingMarkService.saveFoulingMark(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @GetMapping("/{foulingMarkHeaderId}")
    public ResponseEntity<FoulingMarkResponse> getFoulingMark(
            @PathVariable Long foulingMarkHeaderId) {

        FoulingMarkResponse response =
                foulingMarkService.getFoulingMark(foulingMarkHeaderId);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<FoulingMarkResponse>> getAllFoulingMarks() {

        List<FoulingMarkResponse> response =
                foulingMarkService.getAllFoulingMarks();

        return ResponseEntity.ok(response);
    }

 
    @PutMapping("/{foulingMarkHeaderId}")
    public ResponseEntity<Long> updateFoulingMark(
            @PathVariable Long foulingMarkHeaderId,
            @RequestBody FoulingMarkRequest request) {

        Long id = foulingMarkService.updateFoulingMark(
                foulingMarkHeaderId,
                request);

        return ResponseEntity.ok(id);
    }


    @DeleteMapping("/{foulingMarkHeaderId}")
    public ResponseEntity<String> deleteFoulingMark(
            @PathVariable Long foulingMarkHeaderId,
            @RequestParam String updatedBy) {

        foulingMarkService.deleteFoulingMark(
                foulingMarkHeaderId,
                updatedBy);

        return ResponseEntity.ok(
                "Fouling Mark Measurement deleted successfully.");
    }
}