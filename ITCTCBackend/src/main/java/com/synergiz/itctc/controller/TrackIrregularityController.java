package com.synergiz.itctc.controller;



import com.synergiz.itctc.dto.request.TrackIrregularityRequest;
import com.synergiz.itctc.dto.response.TrackIrregularityResponse;
import com.synergiz.itctc.service.TrackIrregularityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track-irregularities")
@CrossOrigin(origins = "*")
public class TrackIrregularityController {

    private final TrackIrregularityService trackIrregularityService;

    public TrackIrregularityController(
            TrackIrregularityService trackIrregularityService) {
        this.trackIrregularityService = trackIrregularityService;
    }

   
    @PostMapping
    public ResponseEntity<Long> saveTrackIrregularity(
            @RequestBody TrackIrregularityRequest request) {

        Long id = trackIrregularityService.saveTrackIrregularity(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

 
    @GetMapping("/{trackIrregularityId}")
    public ResponseEntity<TrackIrregularityResponse> getTrackIrregularity(
            @PathVariable Long trackIrregularityId) {

        TrackIrregularityResponse response =
                trackIrregularityService.getTrackIrregularity(trackIrregularityId);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<TrackIrregularityResponse>> getAllTrackIrregularities() {

        List<TrackIrregularityResponse> response =
                trackIrregularityService.getAllTrackIrregularities();

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{trackIrregularityId}")
    public ResponseEntity<Long> updateTrackIrregularity(
            @PathVariable Long trackIrregularityId,
            @RequestBody TrackIrregularityRequest request) {

        Long id = trackIrregularityService.updateTrackIrregularity(
                trackIrregularityId,
                request);

        return ResponseEntity.ok(id);
    }


    @DeleteMapping("/{trackIrregularityId}")
    public ResponseEntity<Void> deleteTrackIrregularity(
            @PathVariable Long trackIrregularityId,
            @RequestParam String updatedBy) {

        trackIrregularityService.deleteTrackIrregularity(
                trackIrregularityId,
                updatedBy);

        return ResponseEntity.noContent().build();
    }

}