package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.FasteningBoltDetailRequest;
import com.synergiz.itctc.dto.request.FasteningBoltRequest;
import com.synergiz.itctc.dto.response.FasteningBoltDetailResponse;
import com.synergiz.itctc.dto.response.FasteningBoltResponse;
import com.synergiz.itctc.entity.FasteningBoltDetail;
import com.synergiz.itctc.entity.FasteningBoltHeader;
import com.synergiz.itctc.entity.TrackDirection;
import com.synergiz.itctc.repository.FasteningBoltDetailRepository;
import com.synergiz.itctc.repository.FasteningBoltHeaderRepository;
import com.synergiz.itctc.repository.TrackDirectionRepository;
import com.synergiz.itctc.service.FasteningBoltService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FasteningBoltServiceImpl
        implements FasteningBoltService {

    private final FasteningBoltHeaderRepository headerRepository;

    private final FasteningBoltDetailRepository detailRepository;

    private final TrackDirectionRepository trackDirectionRepository;

    public FasteningBoltServiceImpl(
            FasteningBoltHeaderRepository headerRepository,
            FasteningBoltDetailRepository detailRepository,
            TrackDirectionRepository trackDirectionRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
        this.trackDirectionRepository = trackDirectionRepository;
    }
    
    @Override
    @Transactional
    public Long saveFasteningBolt(
            FasteningBoltRequest request) {

        FasteningBoltHeader header = new FasteningBoltHeader();

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

            for (FasteningBoltDetailRequest dto : request.getDetails()) {

                TrackDirection direction = trackDirectionRepository
                        .findById(dto.getTrackDirectionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid Track Direction Id : "
                                                + dto.getTrackDirectionId()));

                FasteningBoltDetail detail = new FasteningBoltDetail();

                detail.setTrackDirection(direction);

                detail.setChainageKm(dto.getChainageKm());
                detail.setChainageM(dto.getChainageM());
                detail.setChainageCm(dto.getChainageCm());

                detail.setSleeperNumber(dto.getSleeperNumber());

                detail.setMeasuredLeft(dto.getMeasuredLeft());
                detail.setMeasuredRight(dto.getMeasuredRight());

                detail.setRemarks(dto.getRemarks());

                detail.setFasteningBoltHeader(header);

                detail.setIsActive(true);

                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getFasteningBoltHeaderId();
    }

    @Override
    public FasteningBoltResponse getFasteningBolt(
            Long fasteningBoltHeaderId) {

        FasteningBoltHeader header = headerRepository
                .findById(fasteningBoltHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fastening Bolt not found with Id : "
                                        + fasteningBoltHeaderId));

        FasteningBoltResponse response =
                new FasteningBoltResponse();

        // Header

        response.setFasteningBoltHeaderId(
                header.getFasteningBoltHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setRecordNo(header.getRecordNo());
        response.setInspectionDate(header.getInspectionDate());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());

        // Details

        List<FasteningBoltDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (FasteningBoltDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                FasteningBoltDetailResponse dto =
                        new FasteningBoltDetailResponse();

                dto.setFasteningBoltDetailId(
                        detail.getFasteningBoltDetailId());

                dto.setTrackDirectionId(
                        detail.getTrackDirection().getTrackDirectionId());

                dto.setTrackDirectionName(
                        detail.getTrackDirection().getDirectionName());

                dto.setChainageKm(detail.getChainageKm());
                dto.setChainageM(detail.getChainageM());
                dto.setChainageCm(detail.getChainageCm());

                dto.setSleeperNumber(detail.getSleeperNumber());

                dto.setMeasuredLeft(detail.getMeasuredLeft());
                dto.setMeasuredRight(detail.getMeasuredRight());

                dto.setRemarks(detail.getRemarks());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    
    @Override
    public List<FasteningBoltResponse> getAllFasteningBolts() {

        List<FasteningBoltHeader> headers = headerRepository.findAll();

        List<FasteningBoltResponse> responseList = new ArrayList<>();

        for (FasteningBoltHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            FasteningBoltResponse response =
                    new FasteningBoltResponse();

            // Header

            response.setFasteningBoltHeaderId(
                    header.getFasteningBoltHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setRecordNo(header.getRecordNo());
            response.setInspectionDate(header.getInspectionDate());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

            // Details

            List<FasteningBoltDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (FasteningBoltDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    FasteningBoltDetailResponse dto =
                            new FasteningBoltDetailResponse();

                    dto.setFasteningBoltDetailId(
                            detail.getFasteningBoltDetailId());

                    dto.setTrackDirectionId(
                            detail.getTrackDirection().getTrackDirectionId());

                    dto.setTrackDirectionName(
                            detail.getTrackDirection().getDirectionName());

                    dto.setChainageKm(detail.getChainageKm());
                    dto.setChainageM(detail.getChainageM());
                    dto.setChainageCm(detail.getChainageCm());

                    dto.setSleeperNumber(detail.getSleeperNumber());

                    dto.setMeasuredLeft(detail.getMeasuredLeft());
                    dto.setMeasuredRight(detail.getMeasuredRight());

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
    public Long updateFasteningBolt(
            Long fasteningBoltHeaderId,
            FasteningBoltRequest request) {

        FasteningBoltHeader header = headerRepository
                .findById(fasteningBoltHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fastening Bolt not found with Id : "
                                        + fasteningBoltHeaderId));

        // Update Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Removed Details

        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(FasteningBoltDetailRequest::getFasteningBoltDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (FasteningBoltDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getFasteningBoltDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }

        // Insert / Update Details

        for (FasteningBoltDetailRequest dto : request.getDetails()) {

            TrackDirection direction = trackDirectionRepository
                    .findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Invalid Track Direction Id"));

            FasteningBoltDetail detail;

            // UPDATE EXISTING DETAIL


            if (dto.getFasteningBoltDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getFasteningBoltDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Fastening Bolt Detail not found with Id : "
                                                + dto.getFasteningBoltDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }


            // INSERT NEW DETAIL
  

            else {

                detail = new FasteningBoltDetail();

                detail.setFasteningBoltHeader(header);

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

            detail.setMeasuredLeft(dto.getMeasuredLeft());
            detail.setMeasuredRight(dto.getMeasuredRight());

            detail.setRemarks(dto.getRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getFasteningBoltHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteFasteningBolt(
            Long fasteningBoltHeaderId,
            String updatedBy) {

        FasteningBoltHeader header = headerRepository
                .findById(fasteningBoltHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fastening Bolt not found with Id : "
                                        + fasteningBoltHeaderId));

        // Soft Delete Header

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Details

        if (header.getDetails() != null) {

            for (FasteningBoltDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }
}