package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.TrackEffectiveLengthRequest;
import com.synergiz.itctc.dto.response.TrackEffectiveLengthResponse;
import com.synergiz.itctc.service.TrackEffectiveLengthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track-effective-length")
@CrossOrigin("*")
public class TrackEffectiveLengthController {

    private final TrackEffectiveLengthService trackEffectiveLengthService;

    public TrackEffectiveLengthController(
            TrackEffectiveLengthService trackEffectiveLengthService) {

        this.trackEffectiveLengthService = trackEffectiveLengthService;
    }


    @PostMapping
    public ResponseEntity<Long> saveTrackEffectiveLength(
            @RequestBody TrackEffectiveLengthRequest request) {

        Long id = trackEffectiveLengthService
                .saveTrackEffectiveLength(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @GetMapping("/{trackEffectiveLengthHeaderId}")
    public ResponseEntity<TrackEffectiveLengthResponse> getTrackEffectiveLength(
            @PathVariable Long trackEffectiveLengthHeaderId) {

        TrackEffectiveLengthResponse response =
                trackEffectiveLengthService.getTrackEffectiveLength(
                        trackEffectiveLengthHeaderId);

        return ResponseEntity.ok(response);
    }

 
    @GetMapping
    public ResponseEntity<List<TrackEffectiveLengthResponse>> getAllTrackEffectiveLengths() {

        List<TrackEffectiveLengthResponse> response =
                trackEffectiveLengthService.getAllTrackEffectiveLengths();

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{trackEffectiveLengthHeaderId}")
    public ResponseEntity<Long> updateTrackEffectiveLength(
            @PathVariable Long trackEffectiveLengthHeaderId,
            @RequestBody TrackEffectiveLengthRequest request) {

        Long id = trackEffectiveLengthService.updateTrackEffectiveLength(
                trackEffectiveLengthHeaderId,
                request);

        return ResponseEntity.ok(id);
    }


    @DeleteMapping("/{trackEffectiveLengthHeaderId}")
    public ResponseEntity<String> deleteTrackEffectiveLength(
            @PathVariable Long trackEffectiveLengthHeaderId,
            @RequestParam String updatedBy) {

        trackEffectiveLengthService.deleteTrackEffectiveLength(
                trackEffectiveLengthHeaderId,
                updatedBy);

        return ResponseEntity.ok(
                "Track Effective Length Measurement deleted successfully.");
    }
}