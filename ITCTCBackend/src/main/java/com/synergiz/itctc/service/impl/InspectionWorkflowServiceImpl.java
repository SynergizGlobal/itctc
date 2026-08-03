package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.constants.WorkflowConstants;
import com.synergiz.itctc.dto.request.InspectionWorkflowRequest;
import com.synergiz.itctc.dto.response.InspectionHistoryResponse;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;
import com.synergiz.itctc.entity.InspectionForm;
import com.synergiz.itctc.entity.InspectionHistory;
import com.synergiz.itctc.entity.InspectionStatus;
import com.synergiz.itctc.entity.InspectionWorkflow;
import com.synergiz.itctc.exception.InvalidWorkflowStatusException;
import com.synergiz.itctc.repository.InspectionFormRepository;
import com.synergiz.itctc.repository.InspectionHistoryRepository;
import com.synergiz.itctc.repository.InspectionStatusRepository;
import com.synergiz.itctc.repository.InspectionWorkflowRepository;
import com.synergiz.itctc.service.InspectionWorkflowService;

@Service
@Transactional
public class InspectionWorkflowServiceImpl implements InspectionWorkflowService {

	private final InspectionWorkflowRepository inspectionWorkflowRepository;

	private final InspectionHistoryRepository inspectionHistoryRepository;

	private final InspectionStatusRepository inspectionStatusRepository;

	private final InspectionFormRepository inspectionFormRepository;

	public InspectionWorkflowServiceImpl(InspectionWorkflowRepository inspectionWorkflowRepository,
			InspectionHistoryRepository inspectionHistoryRepository,
			InspectionStatusRepository inspectionStatusRepository, InspectionFormRepository inspectionFormRepository) {

		this.inspectionWorkflowRepository = inspectionWorkflowRepository;
		this.inspectionHistoryRepository = inspectionHistoryRepository;
		this.inspectionStatusRepository = inspectionStatusRepository;
		this.inspectionFormRepository = inspectionFormRepository;
	}

	@Override
	public InspectionWorkflowResponse submitInspection(InspectionWorkflowRequest request) {

		InspectionForm inspectionForm = inspectionFormRepository.findById(request.getInspectionFormId())
				.orElseThrow(() -> new RuntimeException("Inspection Form not found."));

		InspectionStatus submittedStatus = getStatus(WorkflowConstants.STATUS_SUBMITTED_TO_PMC);

		InspectionWorkflow workflow = inspectionWorkflowRepository.findByInspectionFormInspectionFormIdAndReferenceId(
				request.getInspectionFormId(), request.getReferenceId()).orElse(null);

		InspectionStatus previousStatus = null;

		if (workflow == null) {

			workflow = new InspectionWorkflow();

			workflow.setInspectionForm(inspectionForm);
			workflow.setReferenceId(request.getReferenceId());
			workflow.setCurrentStatus(submittedStatus);
			workflow.setComments(request.getComments());

			workflow.setIsActive(true);

			workflow.setCreatedBy(request.getActionBy());
			workflow.setCreatedDate(LocalDateTime.now());

		} else {

			previousStatus = workflow.getCurrentStatus();

			String currentStatus = previousStatus.getStatusCode();

			if (!(WorkflowConstants.STATUS_RETURNED_BY_PMC.equals(currentStatus)
					|| WorkflowConstants.STATUS_RETURNED_BY_ITC_TO_INSPECTOR.equals(currentStatus))) {

				throw new RuntimeException(
						"Inspection cannot be submitted in current status : " + previousStatus.getStatusName());
			}

			workflow.setCurrentStatus(submittedStatus);

			workflow.setComments(request.getComments());

			workflow.setUpdatedBy(request.getActionBy());
			workflow.setUpdatedDate(LocalDateTime.now());

		}

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, submittedStatus, WorkflowConstants.ACTION_SUBMIT, request.getActionBy(),
				WorkflowConstants.ROLE_INSPECTOR, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	public InspectionWorkflowResponse pmcApprove(InspectionWorkflowRequest request) {

		InspectionWorkflow workflow = getWorkflowOrThrow(request.getInspectionFormId(), request.getReferenceId());

		InspectionStatus previousStatus = workflow.getCurrentStatus();

		validateCurrentStatus(workflow, WorkflowConstants.STATUS_SUBMITTED_TO_PMC,
				WorkflowConstants.STATUS_RETURNED_BY_ITC_TO_PMC);

		InspectionStatus approvedStatus = getStatus(WorkflowConstants.STATUS_PMC_APPROVED);

		workflow.setCurrentStatus(approvedStatus);

		workflow.setComments(request.getComments());

		workflow.setUpdatedBy(request.getActionBy());

		workflow.setUpdatedDate(LocalDateTime.now());

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, approvedStatus, WorkflowConstants.ACTION_APPROVE, request.getActionBy(),
				WorkflowConstants.ROLE_PMC, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	public InspectionWorkflowResponse pmcReturn(InspectionWorkflowRequest request) {

		InspectionWorkflow workflow = getWorkflowOrThrow(request.getInspectionFormId(), request.getReferenceId());

		InspectionStatus previousStatus = workflow.getCurrentStatus();

		validateCurrentStatus(workflow, WorkflowConstants.STATUS_SUBMITTED_TO_PMC,
				WorkflowConstants.STATUS_RETURNED_BY_ITC_TO_PMC);

		InspectionStatus returnedStatus = getStatus(WorkflowConstants.STATUS_RETURNED_BY_PMC);

		workflow.setCurrentStatus(returnedStatus);

		workflow.setComments(request.getComments());

		workflow.setUpdatedBy(request.getActionBy());

		workflow.setUpdatedDate(LocalDateTime.now());

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, returnedStatus, WorkflowConstants.ACTION_RETURN, request.getActionBy(),
				WorkflowConstants.ROLE_PMC, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	public InspectionWorkflowResponse itcApprove(InspectionWorkflowRequest request) {

		InspectionWorkflow workflow = getWorkflowOrThrow(request.getInspectionFormId(), request.getReferenceId());

		InspectionStatus previousStatus = workflow.getCurrentStatus();

		validateCurrentStatus(workflow, WorkflowConstants.STATUS_PMC_APPROVED);

		InspectionStatus finalApprovedStatus = getStatus(WorkflowConstants.STATUS_FINAL_APPROVED);

		workflow.setCurrentStatus(finalApprovedStatus);

		workflow.setComments(request.getComments());

		workflow.setUpdatedBy(request.getActionBy());

		workflow.setUpdatedDate(LocalDateTime.now());

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, finalApprovedStatus, WorkflowConstants.ACTION_APPROVE,
				request.getActionBy(), WorkflowConstants.ROLE_ITC, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	public InspectionWorkflowResponse itcReturnToPMC(InspectionWorkflowRequest request) {

		InspectionWorkflow workflow = getWorkflowOrThrow(request.getInspectionFormId(), request.getReferenceId());

		InspectionStatus previousStatus = workflow.getCurrentStatus();

		validateCurrentStatus(workflow, WorkflowConstants.STATUS_PMC_APPROVED);

		InspectionStatus returnedStatus = getStatus(WorkflowConstants.STATUS_RETURNED_BY_ITC_TO_PMC);

		workflow.setCurrentStatus(returnedStatus);

		workflow.setComments(request.getComments());

		workflow.setUpdatedBy(request.getActionBy());

		workflow.setUpdatedDate(LocalDateTime.now());

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, returnedStatus, WorkflowConstants.ACTION_RETURN, request.getActionBy(),
				WorkflowConstants.ROLE_ITC, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	public InspectionWorkflowResponse itcReturnToInspector(InspectionWorkflowRequest request) {

		InspectionWorkflow workflow = getWorkflowOrThrow(request.getInspectionFormId(), request.getReferenceId());

		InspectionStatus previousStatus = workflow.getCurrentStatus();

		validateCurrentStatus(workflow, WorkflowConstants.STATUS_PMC_APPROVED);

		InspectionStatus returnedStatus = getStatus(WorkflowConstants.STATUS_RETURNED_BY_ITC_TO_INSPECTOR);

		workflow.setCurrentStatus(returnedStatus);

		workflow.setComments(request.getComments());

		workflow.setUpdatedBy(request.getActionBy());

		workflow.setUpdatedDate(LocalDateTime.now());

		workflow = inspectionWorkflowRepository.save(workflow);

		saveHistory(workflow, previousStatus, returnedStatus, WorkflowConstants.ACTION_RETURN, request.getActionBy(),
				WorkflowConstants.ROLE_ITC, request.getComments());

		return mapToResponse(workflow);
	}

	@Override
	@Transactional(readOnly = true)
	public InspectionWorkflowResponse getWorkflow(Integer inspectionFormId, Long referenceId) {

		InspectionWorkflow workflow = inspectionWorkflowRepository
				.findByInspectionFormInspectionFormIdAndReferenceId(inspectionFormId, referenceId).orElse(null);

		if (workflow == null) {
			return null;
		}

		return mapToResponse(workflow);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InspectionHistoryResponse> getHistory(Long workflowId) {

		List<InspectionHistory> historyList = inspectionHistoryRepository
				.findByInspectionWorkflowInspectionWorkflowIdOrderByActionDateAsc(workflowId);

		List<InspectionHistoryResponse> responseList = new ArrayList<>();

		for (InspectionHistory history : historyList) {

			InspectionHistoryResponse response = new InspectionHistoryResponse();

			response.setInspectionHistoryId(history.getInspectionHistoryId());

			if (history.getPreviousStatus() != null) {

				response.setFromStatusId(history.getPreviousStatus().getStatusId());

				response.setFromStatusCode(history.getPreviousStatus().getStatusCode());

				response.setFromStatusName(history.getPreviousStatus().getStatusName());

			}

			response.setToStatusId(history.getNewStatus().getStatusId());

			response.setToStatusCode(history.getNewStatus().getStatusCode());

			response.setToStatusName(history.getNewStatus().getStatusName());

			response.setActionTaken(history.getActionTaken());
			response.setActionRole(history.getActionRole());

			response.setActionBy(history.getActionBy());

			response.setActionComments(history.getComments());

			response.setActionDate(history.getActionDate());

			responseList.add(response);
		}

		return responseList;
	}

	private InspectionWorkflowResponse mapToResponse(InspectionWorkflow workflow) {

		InspectionWorkflowResponse response = new InspectionWorkflowResponse();

		response.setInspectionWorkflowId(workflow.getInspectionWorkflowId());

		response.setInspectionFormId(workflow.getInspectionForm().getInspectionFormId());
		response.setFormName(workflow.getInspectionForm().getFormName());
		response.setFormCode(workflow.getInspectionForm().getFormCode());

		response.setReferenceId(workflow.getReferenceId());

		response.setCurrentStatusId(workflow.getCurrentStatus().getStatusId());
		response.setCurrentStatusCode(workflow.getCurrentStatus().getStatusCode());
		response.setCurrentStatusName(workflow.getCurrentStatus().getStatusName());

		response.setComments(workflow.getComments());

		response.setIsActive(workflow.getIsActive());

		response.setCreatedBy(workflow.getCreatedBy());
		response.setCreatedDate(workflow.getCreatedDate());

		response.setUpdatedBy(workflow.getUpdatedBy());
		response.setUpdatedDate(workflow.getUpdatedDate());

		return response;
	}

	private InspectionWorkflow getWorkflowOrThrow(Integer inspectionFormId, Long referenceId) {

		return inspectionWorkflowRepository
				.findByInspectionFormInspectionFormIdAndReferenceId(inspectionFormId, referenceId)
				.orElseThrow(() -> new RuntimeException("Inspection Workflow not found."));
	}

	private InspectionStatus getStatus(String statusCode) {

		return inspectionStatusRepository.findByStatusCode(statusCode)
				.orElseThrow(() -> new RuntimeException("Status not found : " + statusCode));
	}

	private void saveHistory(InspectionWorkflow workflow, InspectionStatus previousStatus, InspectionStatus newStatus,
			String actionTaken, String actionBy, String actionRole, String comments) {

		InspectionHistory history = new InspectionHistory();

		history.setInspectionWorkflow(workflow);
		history.setPreviousStatus(previousStatus);
		history.setNewStatus(newStatus);

		history.setActionTaken(actionTaken);
		history.setActionBy(actionBy);
		history.setActionRole(actionRole);

		history.setComments(comments);

		history.setActionDate(LocalDateTime.now());

		inspectionHistoryRepository.save(history);

	}

	private void validateCurrentStatus(InspectionWorkflow workflow, String... allowedStatuses) {

		String currentStatus = workflow.getCurrentStatus().getStatusCode();

		for (String allowedStatus : allowedStatuses) {

			if (allowedStatus.equals(currentStatus)) {
				return;
			}
		}

		throw new InvalidWorkflowStatusException(
				"Action is not allowed when inspection is in '" + currentStatus + "' status.");
	}

}