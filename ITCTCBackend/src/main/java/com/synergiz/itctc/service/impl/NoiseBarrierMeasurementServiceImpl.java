package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementDetailRequest;
import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementRequest;
import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.NoiseBarrierMeasurementDetailResponse;
import com.synergiz.itctc.dto.response.NoiseBarrierMeasurementResponse;
import com.synergiz.itctc.entity.NoiseBarrierMeasurementDetail;
import com.synergiz.itctc.entity.NoiseBarrierMeasurementHeader;
import com.synergiz.itctc.entity.StructureType;
import com.synergiz.itctc.entity.TrackType;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.NoiseBarrierMeasurementHeaderRepository;
import com.synergiz.itctc.repository.StructureTypeRepository;
import com.synergiz.itctc.repository.TrackTypeRepository;
import com.synergiz.itctc.service.NoiseBarrierMeasurementService;

@Service
@Transactional
public class NoiseBarrierMeasurementServiceImpl implements NoiseBarrierMeasurementService {

	private final NoiseBarrierMeasurementHeaderRepository noiseBarrierMeasurementHeaderRepository;
	private final StructureTypeRepository structureTypeRepository;
	private final TrackTypeRepository trackTypeRepository;

	public NoiseBarrierMeasurementServiceImpl(
			NoiseBarrierMeasurementHeaderRepository noiseBarrierMeasurementHeaderRepository,
			StructureTypeRepository structureTypeRepository, TrackTypeRepository trackTypeRepository) {

		this.noiseBarrierMeasurementHeaderRepository = noiseBarrierMeasurementHeaderRepository;
		this.structureTypeRepository = structureTypeRepository;
		this.trackTypeRepository = trackTypeRepository;
	}

	@Override
	public Long saveNoiseBarrierMeasurement(NoiseBarrierMeasurementRequest request) {

		StructureType structureType = structureTypeRepository.findById(request.getStructureTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Structure Type Id"));

		TrackType trackType = trackTypeRepository.findById(request.getTrackTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Track Type Id"));

		NoiseBarrierMeasurementHeader header = new NoiseBarrierMeasurementHeader();

		header.setProjectId(request.getProjectId());
		header.setChainageKm(request.getChainageKm());
		header.setChainageM(request.getChainageM());
		header.setStructureType(structureType);
		header.setTrackType(trackType);
		header.setIsCurve(request.getIsCurve());
		header.setCurveRadius(request.getCurveRadius());
		header.setAppliedCantValueMm(request.getAppliedCantValueMm());
		header.setRemarks(request.getRemarks());
		header.setCreatedBy(request.getCreatedBy());
		header.setCreatedDate(LocalDateTime.now());
		header.setIsActive(true);

		List<NoiseBarrierMeasurementDetail> details = new ArrayList<>();

		if (request.getDetails() != null && !request.getDetails().isEmpty()) {

			for (NoiseBarrierMeasurementDetailRequest dto : request.getDetails()) {

				NoiseBarrierMeasurementDetail detail = new NoiseBarrierMeasurementDetail();

				detail.setH1MeasuredValue(dto.getH1MeasuredValue());
				detail.setH2MeasuredValue(dto.getH2MeasuredValue());
				detail.setH3MeasuredValue(dto.getH3MeasuredValue());
				detail.setH4MeasuredValue(dto.getH4MeasuredValue());
				detail.setH5MeasuredValue(dto.getH5MeasuredValue());
				detail.setH6MeasuredValue(dto.getH6MeasuredValue());

				detail.setAStandardValue(dto.getaStandardValue());
				detail.setAMeasuredValue(dto.getaMeasuredValue());

				detail.setBStandardValue(dto.getbStandardValue());
				detail.setBMeasuredValue(dto.getbMeasuredValue());

				detail.setNoiseBarrierMeasurementHeader(header);
				detail.setCreatedDate(LocalDateTime.now());
				detail.setIsActive(true);

				details.add(detail);
			}
		}

		header.setDetails(details);

		NoiseBarrierMeasurementHeader savedHeader = noiseBarrierMeasurementHeaderRepository.save(header);

		return savedHeader.getNoiseBarrierMeasurementId();
	}

	@Override
	@Transactional(readOnly = true)
	public NoiseBarrierMeasurementResponse getNoiseBarrierMeasurement(Long noiseBarrierMeasurementId) {

		NoiseBarrierMeasurementHeader header = noiseBarrierMeasurementHeaderRepository
				.findById(noiseBarrierMeasurementId).orElseThrow(() -> new ResourceNotFoundException(
						"Noise Barrier Measurement not found with Id : " + noiseBarrierMeasurementId));

		return convertToResponse(header);
	}

	private NoiseBarrierMeasurementResponse convertToResponse(NoiseBarrierMeasurementHeader header) {

		NoiseBarrierMeasurementResponse response = new NoiseBarrierMeasurementResponse();

		response.setNoiseBarrierMeasurementId(header.getNoiseBarrierMeasurementId());

		response.setProjectId(header.getProjectId());
		response.setChainageKm(header.getChainageKm());
		response.setChainageM(header.getChainageM());

		response.setStructureTypeId(header.getStructureType().getStructureTypeId());

		response.setStructureTypeName(header.getStructureType().getStructureName());

		response.setTrackTypeId(header.getTrackType().getTrackTypeId());

		response.setTrackTypeName(header.getTrackType().getTrackTypeName());

		response.setIsCurve(header.getIsCurve());
		response.setCurveRadius(header.getCurveRadius());
		response.setAppliedCantValueMm(header.getAppliedCantValueMm());

		response.setRemarks(header.getRemarks());
		response.setCreatedDate(header.getCreatedDate());

		List<NoiseBarrierMeasurementDetailResponse> detailResponses = new ArrayList<>();

		if (header.getDetails() != null) {

			for (NoiseBarrierMeasurementDetail detail : header.getDetails()) {

				NoiseBarrierMeasurementDetailResponse dto = new NoiseBarrierMeasurementDetailResponse();

				dto.setNoiseBarrierMeasurementDetailId(detail.getNoiseBarrierMeasurementDetailId());

				dto.setH1MeasuredValue(detail.getH1MeasuredValue());
				dto.setH2MeasuredValue(detail.getH2MeasuredValue());
				dto.setH3MeasuredValue(detail.getH3MeasuredValue());
				dto.setH4MeasuredValue(detail.getH4MeasuredValue());
				dto.setH5MeasuredValue(detail.getH5MeasuredValue());
				dto.setH6MeasuredValue(detail.getH6MeasuredValue());

				dto.setaStandardValue(detail.getAStandardValue());
				dto.setaMeasuredValue(detail.getAMeasuredValue());

				dto.setbStandardValue(detail.getBStandardValue());
				dto.setbMeasuredValue(detail.getBMeasuredValue());

				detailResponses.add(dto);
			}
		}

		response.setDetails(detailResponses);

		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public List<NoiseBarrierMeasurementResponse> getAllNoiseBarrierMeasurements() {

		List<NoiseBarrierMeasurementHeader> headers = noiseBarrierMeasurementHeaderRepository.findAll();

		List<NoiseBarrierMeasurementResponse> responses = new ArrayList<>();

		for (NoiseBarrierMeasurementHeader header : headers) {

			if (Boolean.TRUE.equals(header.getIsActive())) {
				responses.add(convertToResponse(header));
			}
		}

		return responses;
	}

	@Override
	@Transactional
	public Long updateNoiseBarrierMeasurement(Long noiseBarrierMeasurementId,
			NoiseBarrierMeasurementUpdateRequest request) {

		NoiseBarrierMeasurementHeader header = noiseBarrierMeasurementHeaderRepository
				.findById(noiseBarrierMeasurementId).orElseThrow(() -> new ResourceNotFoundException(
						"Noise Barrier Measurement not found with Id : " + noiseBarrierMeasurementId));

		StructureType structureType = structureTypeRepository.findById(request.getStructureTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Structure Type Id"));

		TrackType trackType = trackTypeRepository.findById(request.getTrackTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Track Type Id"));

		header.setProjectId(request.getProjectId());
		header.setChainageKm(request.getChainageKm());
		header.setChainageM(request.getChainageM());
		header.setStructureType(structureType);
		header.setTrackType(trackType);
		header.setIsCurve(request.getIsCurve());
		header.setCurveRadius(request.getCurveRadius());
		header.setAppliedCantValueMm(request.getAppliedCantValueMm());
		header.setRemarks(request.getRemarks());
		header.setUpdatedBy(request.getUpdatedBy());
		header.setUpdatedDate(LocalDateTime.now());

		header.getDetails().clear();

		if (request.getDetails() != null) {

			for (NoiseBarrierMeasurementDetailRequest dto : request.getDetails()) {

				NoiseBarrierMeasurementDetail detail = new NoiseBarrierMeasurementDetail();

				detail.setH1MeasuredValue(dto.getH1MeasuredValue());
				detail.setH2MeasuredValue(dto.getH2MeasuredValue());
				detail.setH3MeasuredValue(dto.getH3MeasuredValue());
				detail.setH4MeasuredValue(dto.getH4MeasuredValue());
				detail.setH5MeasuredValue(dto.getH5MeasuredValue());
				detail.setH6MeasuredValue(dto.getH6MeasuredValue());

				detail.setAStandardValue(dto.getaStandardValue());
				detail.setAMeasuredValue(dto.getaMeasuredValue());

				detail.setBStandardValue(dto.getbStandardValue());
				detail.setBMeasuredValue(dto.getbMeasuredValue());

				detail.setNoiseBarrierMeasurementHeader(header);
				detail.setCreatedDate(LocalDateTime.now());
				detail.setIsActive(true);

				header.getDetails().add(detail);
			}
		}

		noiseBarrierMeasurementHeaderRepository.save(header);

		return header.getNoiseBarrierMeasurementId();
	}

	@Override
	@Transactional
	public void deleteNoiseBarrierMeasurement(Long noiseBarrierMeasurementId) {

		NoiseBarrierMeasurementHeader header = noiseBarrierMeasurementHeaderRepository
				.findById(noiseBarrierMeasurementId).orElseThrow(() -> new ResourceNotFoundException(
						"Noise Barrier Measurement not found with Id : " + noiseBarrierMeasurementId));

		header.setIsActive(false);
		header.setUpdatedDate(LocalDateTime.now());

		if (header.getDetails() != null) {

			for (NoiseBarrierMeasurementDetail detail : header.getDetails()) {

				detail.setIsActive(false);
			}
		}

		noiseBarrierMeasurementHeaderRepository.save(header);
	}
}