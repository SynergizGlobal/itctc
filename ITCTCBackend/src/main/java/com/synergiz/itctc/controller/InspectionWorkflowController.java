package com.synergiz.itctc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.synergiz.itctc.dto.request.InspectionWorkflowRequest;
import com.synergiz.itctc.dto.response.InspectionHistoryResponse;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;
import com.synergiz.itctc.service.InspectionWorkflowService;

@RestController
@RequestMapping("/api/inspection-workflow")
public class InspectionWorkflowController {

    private final InspectionWorkflowService inspectionWorkflowService;

    public InspectionWorkflowController(InspectionWorkflowService inspectionWorkflowService) {
        this.inspectionWorkflowService = inspectionWorkflowService;
    }

    @PostMapping("/submit")
    public ResponseEntity<InspectionWorkflowResponse> submitInspection(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.submitInspection(request));
    }

    @PostMapping("/pmc/approve")
    public ResponseEntity<InspectionWorkflowResponse> pmcApprove(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.pmcApprove(request));
    }

    @PostMapping("/pmc/return")
    public ResponseEntity<InspectionWorkflowResponse> pmcReturn(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.pmcReturn(request));
    }

    @PostMapping("/itc/approve")
    public ResponseEntity<InspectionWorkflowResponse> itcApprove(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.itcApprove(request));
    }

    @PostMapping("/itc/return-pmc")
    public ResponseEntity<InspectionWorkflowResponse> itcReturnToPMC(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.itcReturnToPMC(request));
    }

    @PostMapping("/itc/return-inspector")
    public ResponseEntity<InspectionWorkflowResponse> itcReturnToInspector(
            @RequestBody InspectionWorkflowRequest request) {

        return ResponseEntity.ok(
                inspectionWorkflowService.itcReturnToInspector(request));
    }

    @GetMapping("/workflow/{inspectionFormId}/{referenceId}")
    public ResponseEntity<InspectionWorkflowResponse> getWorkflow(
            @PathVariable Integer inspectionFormId,
            @PathVariable Long referenceId) {

        return ResponseEntity.ok(
                inspectionWorkflowService.getWorkflow(
                        inspectionFormId,
                        referenceId));
    }

    @GetMapping("/history/{workflowId}")
    public ResponseEntity<List<InspectionHistoryResponse>> getHistory(
            @PathVariable Long workflowId) {

        return ResponseEntity.ok(
                inspectionWorkflowService.getHistory(workflowId));
    }

}