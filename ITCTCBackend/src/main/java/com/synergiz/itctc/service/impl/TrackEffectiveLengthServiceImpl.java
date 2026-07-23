package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.TrackEffectiveLengthDetailRequest;
import com.synergiz.itctc.dto.request.TrackEffectiveLengthRequest;
import com.synergiz.itctc.dto.response.TrackEffectiveLengthDetailResponse;
import com.synergiz.itctc.dto.response.TrackEffectiveLengthResponse;
import com.synergiz.itctc.entity.TrackEffectiveLengthDetail;
import com.synergiz.itctc.entity.TrackEffectiveLengthHeader;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.TrackEffectiveLengthDetailRepository;
import com.synergiz.itctc.repository.TrackEffectiveLengthHeaderRepository;
import com.synergiz.itctc.service.TrackEffectiveLengthService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrackEffectiveLengthServiceImpl implements TrackEffectiveLengthService {

	private final TrackEffectiveLengthHeaderRepository headerRepository;

	private final TrackEffectiveLengthDetailRepository detailRepository;

	public TrackEffectiveLengthServiceImpl(TrackEffectiveLengthHeaderRepository headerRepository,
			TrackEffectiveLengthDetailRepository detailRepository) {

		this.headerRepository = headerRepository;
		this.detailRepository = detailRepository;
	}

	@Override
	@Transactional
	public Long saveTrackEffectiveLength(TrackEffectiveLengthRequest request) {

		TrackEffectiveLengthHeader header = new TrackEffectiveLengthHeader();

		// Header

		header.setProjectId(request.getProjectId());
		header.setFormNo(request.getFormNo());
		header.setLocation(request.getLocation());
		header.setInspectionDate(request.getInspectionDate());

		header.setIsActive(true);

		header.setCreatedBy(request.getCreatedBy());
		header.setCreatedDate(LocalDateTime.now());

		// Details

		if (request.getDetails() != null) {

			for (TrackEffectiveLengthDetailRequest dto : request.getDetails()) {

				TrackEffectiveLengthDetail detail = new TrackEffectiveLengthDetail();

				detail.setTrackEffectiveLengthHeader(header);

				detail.setLineName(dto.getLineName());

				detail.setChainageKm(dto.getChainageKm());
				detail.setChainageM(dto.getChainageM());

				detail.setDistanceDesignValue(dto.getDistanceDesignValue());
				detail.setDistanceMeasuredValue(dto.getDistanceMeasuredValue());

				detail.setEffectiveLengthDesign(dto.getEffectiveLengthDesign());
				detail.setEffectiveLengthMeasured(dto.getEffectiveLengthMeasured());

				detail.setIrregularity(dto.getIrregularity());

				detail.setRemarks(dto.getRemarks());

				detail.setIsActive(true);

				detail.setCreatedBy(request.getCreatedBy());
				detail.setCreatedDate(LocalDateTime.now());

				header.getDetails().add(detail);
			}
		}

		headerRepository.save(header);

		return header.getTrackEffectiveLengthHeaderId();
	}

	@Override
	public TrackEffectiveLengthResponse getTrackEffectiveLength(Long trackEffectiveLengthHeaderId) {

		TrackEffectiveLengthHeader header = headerRepository.findById(trackEffectiveLengthHeaderId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Track Effective Length not found with Id : " + trackEffectiveLengthHeaderId));

		TrackEffectiveLengthResponse response = new TrackEffectiveLengthResponse();

		// Header

		response.setTrackEffectiveLengthHeaderId(header.getTrackEffectiveLengthHeaderId());

		response.setProjectId(header.getProjectId());
		response.setFormNo(header.getFormNo());
		response.setLocation(header.getLocation());
		response.setInspectionDate(header.getInspectionDate());

		response.setCreatedBy(header.getCreatedBy());
		response.setCreatedDate(header.getCreatedDate());

		// Details

		List<TrackEffectiveLengthDetailResponse> detailResponses = new ArrayList<>();

		if (header.getDetails() != null) {

			for (TrackEffectiveLengthDetail detail : header.getDetails()) {

				if (!Boolean.TRUE.equals(detail.getIsActive())) {
					continue;
				}

				TrackEffectiveLengthDetailResponse dto = new TrackEffectiveLengthDetailResponse();

				dto.setTrackEffectiveLengthDetailId(detail.getTrackEffectiveLengthDetailId());

				dto.setLineName(detail.getLineName());

				dto.setChainageKm(detail.getChainageKm());
				dto.setChainageM(detail.getChainageM());

				dto.setDistanceDesignValue(detail.getDistanceDesignValue());

				dto.setDistanceMeasuredValue(detail.getDistanceMeasuredValue());

				dto.setEffectiveLengthDesign(detail.getEffectiveLengthDesign());

				dto.setEffectiveLengthMeasured(detail.getEffectiveLengthMeasured());

				dto.setIrregularity(detail.getIrregularity());

				dto.setRemarks(detail.getRemarks());

				detailResponses.add(dto);
			}
		}

		response.setDetails(detailResponses);

		return response;
	}

	@Override
	public List<TrackEffectiveLengthResponse> getAllTrackEffectiveLengths() {

		List<TrackEffectiveLengthHeader> headers = headerRepository.findAll();

		List<TrackEffectiveLengthResponse> responseList = new ArrayList<>();

		for (TrackEffectiveLengthHeader header : headers) {

			if (!Boolean.TRUE.equals(header.getIsActive())) {
				continue;
			}

			TrackEffectiveLengthResponse response = new TrackEffectiveLengthResponse();

			// Header

			response.setTrackEffectiveLengthHeaderId(header.getTrackEffectiveLengthHeaderId());

			response.setProjectId(header.getProjectId());
			response.setFormNo(header.getFormNo());
			response.setLocation(header.getLocation());
			response.setInspectionDate(header.getInspectionDate());

			response.setCreatedBy(header.getCreatedBy());
			response.setCreatedDate(header.getCreatedDate());

			// Details

			List<TrackEffectiveLengthDetailResponse> detailResponses = new ArrayList<>();

			if (header.getDetails() != null) {

				for (TrackEffectiveLengthDetail detail : header.getDetails()) {

					if (!Boolean.TRUE.equals(detail.getIsActive())) {
						continue;
					}

					TrackEffectiveLengthDetailResponse dto = new TrackEffectiveLengthDetailResponse();

					dto.setTrackEffectiveLengthDetailId(detail.getTrackEffectiveLengthDetailId());

					dto.setLineName(detail.getLineName());

					dto.setChainageKm(detail.getChainageKm());
					dto.setChainageM(detail.getChainageM());

					dto.setDistanceDesignValue(detail.getDistanceDesignValue());

					dto.setDistanceMeasuredValue(detail.getDistanceMeasuredValue());

					dto.setEffectiveLengthDesign(detail.getEffectiveLengthDesign());

					dto.setEffectiveLengthMeasured(detail.getEffectiveLengthMeasured());

					dto.setIrregularity(detail.getIrregularity());

					dto.setRemarks(detail.getRemarks());

					detailResponses.add(dto);
				}
			}

			response.setDetails(detailResponses);

			responseList.add(response);
		}

		return responseList;
	}

	@Override
	@Transactional
	public Long updateTrackEffectiveLength(Long trackEffectiveLengthHeaderId, TrackEffectiveLengthRequest request) {

		TrackEffectiveLengthHeader header = headerRepository.findById(trackEffectiveLengthHeaderId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Track Effective Length not found with Id : " + trackEffectiveLengthHeaderId));

		// Update Header

		header.setProjectId(request.getProjectId());
		header.setFormNo(request.getFormNo());
		header.setLocation(request.getLocation());
		header.setInspectionDate(request.getInspectionDate());

		header.setUpdatedBy(request.getUpdatedBy());
		header.setUpdatedDate(LocalDateTime.now());

		// Soft Delete Removed Details

		Set<Long> requestDetailIds = request.getDetails().stream()
				.map(TrackEffectiveLengthDetailRequest::getTrackEffectiveLengthDetailId).filter(Objects::nonNull)
				.collect(Collectors.toSet());

		for (TrackEffectiveLengthDetail existingDetail : header.getDetails()) {

			if (!requestDetailIds.contains(existingDetail.getTrackEffectiveLengthDetailId())) {

				existingDetail.setIsActive(false);
				existingDetail.setUpdatedBy(request.getUpdatedBy());
				existingDetail.setUpdatedDate(LocalDateTime.now());
			}
		}

		// Insert / Update Details

		for (TrackEffectiveLengthDetailRequest dto : request.getDetails()) {

			TrackEffectiveLengthDetail detail;

			// UPDATE EXISTING DETAIL

			if (dto.getTrackEffectiveLengthDetailId() != null) {

				detail = detailRepository.findById(dto.getTrackEffectiveLengthDetailId())
						.orElseThrow(() -> new ResourceNotFoundException("Track Effective Length Detail not found with Id : "
								+ dto.getTrackEffectiveLengthDetailId()));

				detail.setUpdatedBy(request.getUpdatedBy());
				detail.setUpdatedDate(LocalDateTime.now());
			}

			// INSERT NEW DETAIL

			else {

				detail = new TrackEffectiveLengthDetail();

				detail.setTrackEffectiveLengthHeader(header);

				detail.setCreatedBy(request.getUpdatedBy());
				detail.setCreatedDate(LocalDateTime.now());

				detail.setIsActive(true);

				header.getDetails().add(detail);
			}

			detail.setLineName(dto.getLineName());

			detail.setChainageKm(dto.getChainageKm());
			detail.setChainageM(dto.getChainageM());

			detail.setDistanceDesignValue(dto.getDistanceDesignValue());
			detail.setDistanceMeasuredValue(dto.getDistanceMeasuredValue());

			detail.setEffectiveLengthDesign(dto.getEffectiveLengthDesign());
			detail.setEffectiveLengthMeasured(dto.getEffectiveLengthMeasured());

			detail.setIrregularity(dto.getIrregularity());

			detail.setRemarks(dto.getRemarks());

			detail.setIsActive(true);
		}

		headerRepository.save(header);

		return header.getTrackEffectiveLengthHeaderId();
	}

	@Override
	@Transactional
	public void deleteTrackEffectiveLength(Long trackEffectiveLengthHeaderId, String updatedBy) {

		TrackEffectiveLengthHeader header = headerRepository.findById(trackEffectiveLengthHeaderId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Track Effective Length not found with Id : " + trackEffectiveLengthHeaderId));

		// Soft Delete Header

		header.setIsActive(false);
		header.setUpdatedBy(updatedBy);
		header.setUpdatedDate(LocalDateTime.now());

		// Soft Delete Details

		if (header.getDetails() != null) {

			for (TrackEffectiveLengthDetail detail : header.getDetails()) {

				detail.setIsActive(false);
				detail.setUpdatedBy(updatedBy);
				detail.setUpdatedDate(LocalDateTime.now());
			}
		}

		headerRepository.save(header);
	}
}