package com.synergiz.itctc.service.impl;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.dto.request.TrackIrregularityDetailRequest;
import com.synergiz.itctc.dto.request.TrackIrregularityRequest;
import com.synergiz.itctc.dto.response.TrackIrregularityDetailResponse;
import com.synergiz.itctc.dto.response.TrackIrregularityResponse;
import com.synergiz.itctc.entity.TrackDirection;
import com.synergiz.itctc.entity.TrackIrregularityDetail;
import com.synergiz.itctc.entity.TrackIrregularityHeader;
import com.synergiz.itctc.entity.TrackIrregularityType;
import com.synergiz.itctc.repository.TrackDirectionRepository;
import com.synergiz.itctc.repository.TrackIrregularityDetailRepository;
import com.synergiz.itctc.repository.TrackIrregularityHeaderRepository;
import com.synergiz.itctc.repository.TrackIrregularityTypeRepository;
import com.synergiz.itctc.service.TrackIrregularityService;

@Service
public class TrackIrregularityServiceImpl implements TrackIrregularityService {

    private final TrackIrregularityHeaderRepository headerRepository;
    private final TrackIrregularityDetailRepository detailRepository;
    private final TrackDirectionRepository directionRepository;
    private final TrackIrregularityTypeRepository typeRepository;

    public TrackIrregularityServiceImpl(
            TrackIrregularityHeaderRepository headerRepository,
            TrackIrregularityDetailRepository detailRepository,
            TrackDirectionRepository directionRepository,
            TrackIrregularityTypeRepository typeRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
        this.directionRepository = directionRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional
    public Long saveTrackIrregularity(TrackIrregularityRequest request) {

        TrackIrregularityHeader header = new TrackIrregularityHeader();

        header.setProjectId(request.getProjectId());
        header.setFormNumber(request.getFormNumber());
        header.setMeasurementDate(request.getMeasurementDate());
        header.setChainageKm(request.getChainageKm());
        header.setChainageM(request.getChainageM());

        header.setMeasuringPointDown(request.getMeasuringPointDown());
        header.setMeasuringPointUp(request.getMeasuringPointUp());

        header.setVerticalCurveDiagramDown(request.getVerticalCurveDiagramDown());
        header.setPlaneCurveDiagramDown(request.getPlaneCurveDiagramDown());

        header.setVerticalCurveDiagramUp(request.getVerticalCurveDiagramUp());
        header.setPlaneCurveDiagramUp(request.getPlaneCurveDiagramUp());

        header.setRemarks(request.getRemarks());
     
        header.setIsActive(true);
        header.setCreatedBy(request.getCreatedBy());
        header.setCreatedDate(LocalDateTime.now());

        for (TrackIrregularityDetailRequest dto : request.getDetails()) {

            TrackDirection direction = directionRepository.findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException("Invalid Track Direction Id"));

            TrackIrregularityType type = typeRepository.findById(dto.getTrackIrregularityTypeId())
                    .orElseThrow(() ->
                            new RuntimeException("Invalid Track Irregularity Type Id"));

            TrackIrregularityDetail detail = new TrackIrregularityDetail();

            detail.setTrackIrregularityHeader(header);

            detail.setTrackDirection(direction);

            detail.setTrackIrregularityType(type);

            detail.setDesignValue(dto.getDesignValue());
            detail.setMeasuredValue(dto.getMeasuredValue());
            detail.setIrregularityValue(dto.getIrregularityValue());

            detail.setDetailRemarks(dto.getDetailRemarks());

            detail.setIsActive(true);
            detail.setCreatedBy(request.getCreatedBy());
            detail.setCreatedDate(LocalDateTime.now());

            header.getDetails().add(detail);
        }

        TrackIrregularityHeader savedHeader = headerRepository.save(header);

        return savedHeader.getTrackIrregularityId();
    }
    
    @Override
    @Transactional(readOnly = true)
    public TrackIrregularityResponse getTrackIrregularity(Long trackIrregularityId) {

        TrackIrregularityHeader header = headerRepository
                .findById(trackIrregularityId)
                .orElseThrow(() ->
                        new RuntimeException("Track Irregularity not found with Id : "
                                + trackIrregularityId));

        TrackIrregularityResponse response = new TrackIrregularityResponse();

        response.setTrackIrregularityId(header.getTrackIrregularityId());
        response.setProjectId(header.getProjectId());
        response.setFormNumber(header.getFormNumber());
        response.setMeasurementDate(header.getMeasurementDate());
        response.setChainageKm(header.getChainageKm());
        response.setChainageM(header.getChainageM());

        response.setMeasuringPointDown(header.getMeasuringPointDown());
        response.setMeasuringPointUp(header.getMeasuringPointUp());

        response.setVerticalCurveDiagramDown(header.getVerticalCurveDiagramDown());
        response.setPlaneCurveDiagramDown(header.getPlaneCurveDiagramDown());

        response.setVerticalCurveDiagramUp(header.getVerticalCurveDiagramUp());
        response.setPlaneCurveDiagramUp(header.getPlaneCurveDiagramUp());

        response.setRemarks(header.getRemarks());
        response.setCreatedDate(header.getCreatedDate());

        List<TrackIrregularityDetailResponse> detailResponses = new ArrayList<>();

        if (header.getDetails() != null) {

            for (TrackIrregularityDetail detail : header.getDetails()) {

                if (Boolean.FALSE.equals(detail.getIsActive())) {
                    continue;
                }

                TrackIrregularityDetailResponse detailResponse =
                        new TrackIrregularityDetailResponse();

                detailResponse.setTrackIrregularityDetailId(
                        detail.getTrackIrregularityDetailId());

                detailResponse.setTrackDirectionId(
                        detail.getTrackDirection().getTrackDirectionId());

                detailResponse.setDirectionName(
                        detail.getTrackDirection().getDirectionName());

                detailResponse.setTrackIrregularityTypeId(
                        detail.getTrackIrregularityType().getTrackIrregularityTypeId());

                detailResponse.setMeasurementName(
                        detail.getTrackIrregularityType().getMeasurementName());

                detailResponse.setDesignValue(detail.getDesignValue());
                detailResponse.setMeasuredValue(detail.getMeasuredValue());
                detailResponse.setIrregularityValue(detail.getIrregularityValue());

                detailResponse.setDetailRemarks(detail.getDetailRemarks());

                detailResponses.add(detailResponse);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<TrackIrregularityResponse> getAllTrackIrregularities() {

        List<TrackIrregularityHeader> headers = headerRepository.findAll();

        List<TrackIrregularityResponse> responses = new ArrayList<>();

        for (TrackIrregularityHeader header : headers) {

            if (Boolean.FALSE.equals(header.getIsActive())) {
                continue;
            }

            TrackIrregularityResponse response = new TrackIrregularityResponse();

            response.setTrackIrregularityId(header.getTrackIrregularityId());
            response.setProjectId(header.getProjectId());
            response.setFormNumber(header.getFormNumber());
            response.setMeasurementDate(header.getMeasurementDate());
            response.setChainageKm(header.getChainageKm());
            response.setChainageM(header.getChainageM());

            response.setMeasuringPointDown(header.getMeasuringPointDown());
            response.setMeasuringPointUp(header.getMeasuringPointUp());

            response.setVerticalCurveDiagramDown(header.getVerticalCurveDiagramDown());
            response.setPlaneCurveDiagramDown(header.getPlaneCurveDiagramDown());

            response.setVerticalCurveDiagramUp(header.getVerticalCurveDiagramUp());
            response.setPlaneCurveDiagramUp(header.getPlaneCurveDiagramUp());

            response.setRemarks(header.getRemarks());
            response.setCreatedDate(header.getCreatedDate());

            List<TrackIrregularityDetailResponse> detailResponses = new ArrayList<>();

            if (header.getDetails() != null) {

                for (TrackIrregularityDetail detail : header.getDetails()) {

                    if (Boolean.FALSE.equals(detail.getIsActive())) {
                        continue;
                    }

                    TrackIrregularityDetailResponse detailResponse =
                            new TrackIrregularityDetailResponse();

                    detailResponse.setTrackIrregularityDetailId(
                            detail.getTrackIrregularityDetailId());

                    detailResponse.setTrackDirectionId(
                            detail.getTrackDirection().getTrackDirectionId());

                    detailResponse.setDirectionName(
                            detail.getTrackDirection().getDirectionName());

                    detailResponse.setTrackIrregularityTypeId(
                            detail.getTrackIrregularityType().getTrackIrregularityTypeId());

                    detailResponse.setMeasurementName(
                            detail.getTrackIrregularityType().getMeasurementName());

                    detailResponse.setDesignValue(detail.getDesignValue());
                    detailResponse.setMeasuredValue(detail.getMeasuredValue());
                    detailResponse.setIrregularityValue(detail.getIrregularityValue());

                    detailResponse.setDetailRemarks(detail.getDetailRemarks());

                    detailResponses.add(detailResponse);
                }
            }

            response.setDetails(detailResponses);

            responses.add(response);
        }

        return responses;
    }
    
    @Override
    @Transactional
    public Long updateTrackIrregularity(
            Long trackIrregularityId,
            TrackIrregularityRequest request) {

        TrackIrregularityHeader header = headerRepository
                .findById(trackIrregularityId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Track Irregularity not found with Id : "
                                        + trackIrregularityId));

        // ===========================
        // Update Header
        // ===========================

        header.setProjectId(request.getProjectId());
        header.setFormNumber(request.getFormNumber());
        header.setMeasurementDate(request.getMeasurementDate());

        header.setChainageKm(request.getChainageKm());
        header.setChainageM(request.getChainageM());

        header.setMeasuringPointDown(request.getMeasuringPointDown());
        header.setMeasuringPointUp(request.getMeasuringPointUp());

        header.setVerticalCurveDiagramDown(request.getVerticalCurveDiagramDown());
        header.setPlaneCurveDiagramDown(request.getPlaneCurveDiagramDown());

        header.setVerticalCurveDiagramUp(request.getVerticalCurveDiagramUp());
        header.setPlaneCurveDiagramUp(request.getPlaneCurveDiagramUp());

        header.setRemarks(request.getRemarks());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

        // ==================================================
        // Soft Delete Removed Details
        // ==================================================

        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(TrackIrregularityDetailRequest::getTrackIrregularityDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (TrackIrregularityDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(existingDetail.getTrackIrregularityDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }

        // ==================================================
        // Insert / Update Details
        // ==================================================

        for (TrackIrregularityDetailRequest dto : request.getDetails()) {

            TrackDirection direction = directionRepository
                    .findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException("Invalid Track Direction Id"));

            TrackIrregularityType type = typeRepository
                    .findById(dto.getTrackIrregularityTypeId())
                    .orElseThrow(() ->
                            new RuntimeException("Invalid Track Irregularity Type Id"));

            TrackIrregularityDetail detail;

            // ===========================
            // UPDATE EXISTING DETAIL
            // ===========================

            if (dto.getTrackIrregularityDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getTrackIrregularityDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Track Irregularity Detail not found with Id : "
                                                + dto.getTrackIrregularityDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }

            // ===========================
            // INSERT NEW DETAIL
            // ===========================

            else {

                detail = new TrackIrregularityDetail();

                detail.setTrackIrregularityHeader(header);

                detail.setCreatedBy(request.getUpdatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                detail.setIsActive(true);

                header.getDetails().add(detail);
            }

            detail.setTrackDirection(direction);
            detail.setTrackIrregularityType(type);

            detail.setDesignValue(dto.getDesignValue());
            detail.setMeasuredValue(dto.getMeasuredValue());
            detail.setIrregularityValue(dto.getIrregularityValue());

            detail.setDetailRemarks(dto.getDetailRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getTrackIrregularityId();
    }
    
    @Override
    @Transactional
    public void deleteTrackIrregularity(Long trackIrregularityId,
                                        String updatedBy) {

        TrackIrregularityHeader header = headerRepository
                .findById(trackIrregularityId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Track Irregularity not found with Id : "
                                        + trackIrregularityId));

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        if (header.getDetails() != null) {

            for (TrackIrregularityDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }
}