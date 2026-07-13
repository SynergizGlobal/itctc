package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.SleeperSpacingDetailRequest;
import com.synergiz.itctc.dto.request.SleeperSpacingRequest;
import com.synergiz.itctc.dto.response.SleeperSpacingDetailResponse;
import com.synergiz.itctc.dto.response.SleeperSpacingResponse;
import com.synergiz.itctc.entity.SleeperSpacingDetail;
import com.synergiz.itctc.entity.SleeperSpacingHeader;
import com.synergiz.itctc.entity.TrackDirection;
import com.synergiz.itctc.repository.SleeperSpacingDetailRepository;
import com.synergiz.itctc.repository.SleeperSpacingHeaderRepository;
import com.synergiz.itctc.repository.TrackDirectionRepository;
import com.synergiz.itctc.service.SleeperSpacingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SleeperSpacingServiceImpl implements SleeperSpacingService {

    private final SleeperSpacingHeaderRepository headerRepository;

    private final SleeperSpacingDetailRepository detailRepository;

    private final TrackDirectionRepository trackDirectionRepository;

    public SleeperSpacingServiceImpl(
            SleeperSpacingHeaderRepository headerRepository,
            SleeperSpacingDetailRepository detailRepository,
            TrackDirectionRepository trackDirectionRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
        this.trackDirectionRepository = trackDirectionRepository;
    }
    
    @Override
    @Transactional
    public Long saveSleeperSpacing(SleeperSpacingRequest request) {

        SleeperSpacingHeader header = new SleeperSpacingHeader();

        // Header
  

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setIsActive(true);

        header.setCreatedBy(request.getCreatedBy());
        header.setCreatedDate(LocalDateTime.now());


        // Details


        if (request.getDetails() != null) {

            for (SleeperSpacingDetailRequest dto : request.getDetails()) {

                TrackDirection trackDirection = trackDirectionRepository
                        .findById(dto.getTrackDirectionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid Track Direction Id : "
                                                + dto.getTrackDirectionId()));

                SleeperSpacingDetail detail = new SleeperSpacingDetail();

                detail.setTrackDirection(trackDirection);

                detail.setChainageKm(dto.getChainageKm());
                detail.setChainageM(dto.getChainageM());
                detail.setChainageCm(dto.getChainageCm());

                detail.setSleeperNumber(dto.getSleeperNumber());

                detail.setSquareness(dto.getSquareness());

                detail.setSpacingDesignValue(dto.getSpacingDesignValue());
                detail.setSpacingMeasuredValue(dto.getSpacingMeasuredValue());
                detail.setSpacingIrregularity(dto.getSpacingIrregularity());

                detail.setRemarks(dto.getRemarks());

                detail.setSleeperSpacingHeader(header);

                detail.setIsActive(true);

                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getSleeperSpacingHeaderId();
    }
    
    @Override
    public SleeperSpacingResponse getSleeperSpacing(
            Long sleeperSpacingHeaderId) {

        SleeperSpacingHeader header = headerRepository
                .findById(sleeperSpacingHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Sleeper Spacing not found with Id : "
                                        + sleeperSpacingHeaderId));

        SleeperSpacingResponse response = new SleeperSpacingResponse();

       
        // Header
 

        response.setSleeperSpacingHeaderId(
                header.getSleeperSpacingHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setRecordNo(header.getRecordNo());
        response.setInspectionDate(header.getInspectionDate());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());

        
        // Details
      

        List<SleeperSpacingDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (SleeperSpacingDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                SleeperSpacingDetailResponse dto =
                        new SleeperSpacingDetailResponse();

                dto.setSleeperSpacingDetailId(
                        detail.getSleeperSpacingDetailId());

                dto.setTrackDirectionId(
                        detail.getTrackDirection().getTrackDirectionId());

                dto.setTrackDirectionName(
                        detail.getTrackDirection().getDirectionName());

                dto.setChainageKm(detail.getChainageKm());
                dto.setChainageM(detail.getChainageM());
                dto.setChainageCm(detail.getChainageCm());

                dto.setSleeperNumber(detail.getSleeperNumber());

                dto.setSquareness(detail.getSquareness());

                dto.setSpacingDesignValue(
                        detail.getSpacingDesignValue());

                dto.setSpacingMeasuredValue(
                        detail.getSpacingMeasuredValue());

                dto.setSpacingIrregularity(
                        detail.getSpacingIrregularity());

                dto.setRemarks(detail.getRemarks());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    @Override
    public List<SleeperSpacingResponse> getAllSleeperSpacings() {

        List<SleeperSpacingHeader> headers = headerRepository.findAll();

        List<SleeperSpacingResponse> responseList = new ArrayList<>();

        for (SleeperSpacingHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            SleeperSpacingResponse response = new SleeperSpacingResponse();

            // ===========================
            // Header
            // ===========================

            response.setSleeperSpacingHeaderId(
                    header.getSleeperSpacingHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setRecordNo(header.getRecordNo());
            response.setInspectionDate(header.getInspectionDate());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

            // ===========================
            // Details
            // ===========================

            List<SleeperSpacingDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (SleeperSpacingDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    SleeperSpacingDetailResponse dto =
                            new SleeperSpacingDetailResponse();

                    dto.setSleeperSpacingDetailId(
                            detail.getSleeperSpacingDetailId());

                    dto.setTrackDirectionId(
                            detail.getTrackDirection().getTrackDirectionId());

                    dto.setTrackDirectionName(
                            detail.getTrackDirection().getDirectionName());

                    dto.setChainageKm(detail.getChainageKm());
                    dto.setChainageM(detail.getChainageM());
                    dto.setChainageCm(detail.getChainageCm());

                    dto.setSleeperNumber(detail.getSleeperNumber());

                    dto.setSquareness(detail.getSquareness());

                    dto.setSpacingDesignValue(
                            detail.getSpacingDesignValue());

                    dto.setSpacingMeasuredValue(
                            detail.getSpacingMeasuredValue());

                    dto.setSpacingIrregularity(
                            detail.getSpacingIrregularity());

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
    public Long updateSleeperSpacing(
            Long sleeperSpacingHeaderId,
            SleeperSpacingRequest request) {

        SleeperSpacingHeader header = headerRepository
                .findById(sleeperSpacingHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Sleeper Spacing not found with Id : "
                                        + sleeperSpacingHeaderId));

        // ===========================
        // Update Header
        // ===========================

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

        // ==================================================
        // Soft Delete Removed Details
        // ==================================================

        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(SleeperSpacingDetailRequest::getSleeperSpacingDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (SleeperSpacingDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getSleeperSpacingDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }

        // ==================================================
        // Insert / Update Details
        // ==================================================

        for (SleeperSpacingDetailRequest dto : request.getDetails()) {

            TrackDirection direction = trackDirectionRepository
                    .findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Invalid Track Direction Id"));

            SleeperSpacingDetail detail;

            // ===========================
            // UPDATE EXISTING DETAIL
            // ===========================

            if (dto.getSleeperSpacingDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getSleeperSpacingDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Sleeper Spacing Detail not found with Id : "
                                                + dto.getSleeperSpacingDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }

            // ===========================
            // INSERT NEW DETAIL
            // ===========================

            else {

                detail = new SleeperSpacingDetail();

                detail.setSleeperSpacingHeader(header);

                detail.setCreatedBy(request.getUpdatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                detail.setIsActive(true);

                header.getDetails().add(detail);
            }

            detail.setTrackDirection(direction);

            detail.setChainageKm(dto.getChainageKm());
            detail.setChainageM(dto.getChainageM());
            detail.setChainageCm(dto.getChainageCm());

            detail.setSleeperNumber(dto.getSleeperNumber());

            detail.setSquareness(dto.getSquareness());

            detail.setSpacingDesignValue(dto.getSpacingDesignValue());
            detail.setSpacingMeasuredValue(dto.getSpacingMeasuredValue());
            detail.setSpacingIrregularity(dto.getSpacingIrregularity());

            detail.setRemarks(dto.getRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getSleeperSpacingHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteSleeperSpacing(
            Long sleeperSpacingHeaderId,
            String updatedBy) {

        SleeperSpacingHeader header = headerRepository
                .findById(sleeperSpacingHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Sleeper Spacing not found with Id : "
                                        + sleeperSpacingHeaderId));

        // ===========================
        // Soft Delete Header
        // ===========================

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        // ===========================
        // Soft Delete Details
        // ===========================

        if (header.getDetails() != null) {

            for (SleeperSpacingDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }

}