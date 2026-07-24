package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.BufferStopRequest;
import com.synergiz.itctc.dto.response.BufferStopResponse;
import com.synergiz.itctc.service.BufferStopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buffer-stop")
//@CrossOrigin("*")
public class BufferStopController {

    private final BufferStopService bufferStopService;

    public BufferStopController(
            BufferStopService bufferStopService) {

        this.bufferStopService = bufferStopService;
    }

    
    @PostMapping
    public ResponseEntity<Long> saveBufferStop(
            @RequestBody BufferStopRequest request) {

        Long id = bufferStopService.saveBufferStop(request);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @GetMapping("/{bufferStopHeaderId}")
    public ResponseEntity<BufferStopResponse> getBufferStop(
            @PathVariable Long bufferStopHeaderId) {

        BufferStopResponse response =
                bufferStopService.getBufferStop(bufferStopHeaderId);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BufferStopResponse>> getAllBufferStops() {

        List<BufferStopResponse> response =
                bufferStopService.getAllBufferStops();

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{bufferStopHeaderId}")
    public ResponseEntity<Long> updateBufferStop(
            @PathVariable Long bufferStopHeaderId,
            @RequestBody BufferStopRequest request) {

        Long id = bufferStopService.updateBufferStop(
                bufferStopHeaderId,
                request);

        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{bufferStopHeaderId}")
    public ResponseEntity<String> deleteBufferStop(
            @PathVariable Long bufferStopHeaderId,
            @RequestParam String updatedBy) {

        bufferStopService.deleteBufferStop(
                bufferStopHeaderId,
                updatedBy);

        return ResponseEntity.ok(
                "Buffer Stop Measurement deleted successfully.");
    }
}