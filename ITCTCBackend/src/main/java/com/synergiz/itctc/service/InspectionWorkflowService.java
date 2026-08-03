package com.synergiz.itctc.service;

import java.util.List;

import com.synergiz.itctc.dto.request.InspectionWorkflowRequest;
import com.synergiz.itctc.dto.response.InspectionHistoryResponse;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;

public interface InspectionWorkflowService {

    InspectionWorkflowResponse submitInspection(InspectionWorkflowRequest request);

    InspectionWorkflowResponse pmcApprove(InspectionWorkflowRequest request);

    InspectionWorkflowResponse pmcReturn(InspectionWorkflowRequest request);

    InspectionWorkflowResponse itcApprove(InspectionWorkflowRequest request);

    InspectionWorkflowResponse itcReturnToPMC(InspectionWorkflowRequest request);

    InspectionWorkflowResponse itcReturnToInspector(InspectionWorkflowRequest request);

    InspectionWorkflowResponse getWorkflow(Integer inspectionFormId, Long referenceId);

    List<InspectionHistoryResponse> getHistory(Long workflowId);

}