package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.SyntheticResinInjectionDetailRequest;
import com.synergiz.itctc.dto.request.SyntheticResinInjectionRequest;
import com.synergiz.itctc.dto.response.SyntheticResinInjectionDetailResponse;
import com.synergiz.itctc.dto.response.SyntheticResinInjectionResponse;
import com.synergiz.itctc.entity.SyntheticResinInjectionDetail;
import com.synergiz.itctc.entity.SyntheticResinInjectionHeader;
import com.synergiz.itctc.entity.TrackDirection;
import com.synergiz.itctc.repository.SyntheticResinInjectionDetailRepository;
import com.synergiz.itctc.repository.SyntheticResinInjectionHeaderRepository;
import com.synergiz.itctc.repository.TrackDirectionRepository;
import com.synergiz.itctc.service.SyntheticResinInjectionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SyntheticResinInjectionServiceImpl
        implements SyntheticResinInjectionService {

    private final SyntheticResinInjectionHeaderRepository headerRepository;

    private final SyntheticResinInjectionDetailRepository detailRepository;

    private final TrackDirectionRepository trackDirectionRepository;

    public SyntheticResinInjectionServiceImpl(
            SyntheticResinInjectionHeaderRepository headerRepository,
            SyntheticResinInjectionDetailRepository detailRepository,
            TrackDirectionRepository trackDirectionRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
        this.trackDirectionRepository = trackDirectionRepository;
    }
    
    @Override
    @Transactional
    public Long saveSyntheticResinInjection(
            SyntheticResinInjectionRequest request) {

        SyntheticResinInjectionHeader header =
                new SyntheticResinInjectionHeader();

        
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

            for (SyntheticResinInjectionDetailRequest dto : request.getDetails()) {

                TrackDirection trackDirection = trackDirectionRepository
                        .findById(dto.getTrackDirectionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid Track Direction Id : "
                                                + dto.getTrackDirectionId()));

                SyntheticResinInjectionDetail detail =
                        new SyntheticResinInjectionDetail();

                detail.setTrackDirection(trackDirection);

                detail.setChainageKm(dto.getChainageKm());
                detail.setChainageM(dto.getChainageM());
                detail.setChainageCm(dto.getChainageCm());

                detail.setSleeperNumber(dto.getSleeperNumber());

                detail.setInjectionLeft(dto.getInjectionLeft());
                detail.setInjectionCentre(dto.getInjectionCentre());
                detail.setInjectionRight(dto.getInjectionRight());
                detail.setInjectionAverage(dto.getInjectionAverage());

                detail.setGap(dto.getGap());

                detail.setRemarks(dto.getRemarks());

                detail.setSyntheticResinInjectionHeader(header);

                detail.setIsActive(true);

                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getSyntheticResinInjectionHeaderId();
    }
    
    @Override
    public SyntheticResinInjectionResponse getSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId) {

        SyntheticResinInjectionHeader header = headerRepository
                .findById(syntheticResinInjectionHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Synthetic Resin Injection not found with Id : "
                                        + syntheticResinInjectionHeaderId));

        SyntheticResinInjectionResponse response =
                new SyntheticResinInjectionResponse();

        // Header

        response.setSyntheticResinInjectionHeaderId(
                header.getSyntheticResinInjectionHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setRecordNo(header.getRecordNo());
        response.setInspectionDate(header.getInspectionDate());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());

        // Details

        List<SyntheticResinInjectionDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (SyntheticResinInjectionDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                SyntheticResinInjectionDetailResponse dto =
                        new SyntheticResinInjectionDetailResponse();

                dto.setSyntheticResinInjectionDetailId(
                        detail.getSyntheticResinInjectionDetailId());

                dto.setTrackDirectionId(
                        detail.getTrackDirection().getTrackDirectionId());

                dto.setTrackDirectionName(
                        detail.getTrackDirection().getDirectionName());

                dto.setChainageKm(detail.getChainageKm());
                dto.setChainageM(detail.getChainageM());
                dto.setChainageCm(detail.getChainageCm());

                dto.setSleeperNumber(detail.getSleeperNumber());

                dto.setInjectionLeft(detail.getInjectionLeft());
                dto.setInjectionCentre(detail.getInjectionCentre());
                dto.setInjectionRight(detail.getInjectionRight());
                dto.setInjectionAverage(detail.getInjectionAverage());

                dto.setGap(detail.getGap());

                dto.setRemarks(detail.getRemarks());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    @Override
    public List<SyntheticResinInjectionResponse> getAllSyntheticResinInjections() {

        List<SyntheticResinInjectionHeader> headers = headerRepository.findAll();

        List<SyntheticResinInjectionResponse> responseList = new ArrayList<>();

        for (SyntheticResinInjectionHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            SyntheticResinInjectionResponse response =
                    new SyntheticResinInjectionResponse();

            // Header

            response.setSyntheticResinInjectionHeaderId(
                    header.getSyntheticResinInjectionHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setRecordNo(header.getRecordNo());
            response.setInspectionDate(header.getInspectionDate());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

            // Details

            List<SyntheticResinInjectionDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (SyntheticResinInjectionDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    SyntheticResinInjectionDetailResponse dto =
                            new SyntheticResinInjectionDetailResponse();

                    dto.setSyntheticResinInjectionDetailId(
                            detail.getSyntheticResinInjectionDetailId());

                    dto.setTrackDirectionId(
                            detail.getTrackDirection().getTrackDirectionId());

                    dto.setTrackDirectionName(
                            detail.getTrackDirection().getDirectionName());

                    dto.setChainageKm(detail.getChainageKm());
                    dto.setChainageM(detail.getChainageM());
                    dto.setChainageCm(detail.getChainageCm());

                    dto.setSleeperNumber(detail.getSleeperNumber());

                    dto.setInjectionLeft(detail.getInjectionLeft());
                    dto.setInjectionCentre(detail.getInjectionCentre());
                    dto.setInjectionRight(detail.getInjectionRight());
                    dto.setInjectionAverage(detail.getInjectionAverage());

                    dto.setGap(detail.getGap());

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
    public Long updateSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId,
            SyntheticResinInjectionRequest request) {

        SyntheticResinInjectionHeader header = headerRepository
                .findById(syntheticResinInjectionHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Synthetic Resin Injection not found with Id : "
                                        + syntheticResinInjectionHeaderId));

        // Update Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());


        // Soft Delete Removed Details

        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(SyntheticResinInjectionDetailRequest::getSyntheticResinInjectionDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (SyntheticResinInjectionDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getSyntheticResinInjectionDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }


        // Insert / Update Details

        for (SyntheticResinInjectionDetailRequest dto : request.getDetails()) {

            TrackDirection direction = trackDirectionRepository
                    .findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Invalid Track Direction Id"));

            SyntheticResinInjectionDetail detail;

            // UPDATE EXISTING DETAIL

            if (dto.getSyntheticResinInjectionDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getSyntheticResinInjectionDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Synthetic Resin Injection Detail not found with Id : "
                                                + dto.getSyntheticResinInjectionDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }

            // INSERT NEW DETAIL
 

            else {

                detail = new SyntheticResinInjectionDetail();

                detail.setSyntheticResinInjectionHeader(header);

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

            detail.setInjectionLeft(dto.getInjectionLeft());
            detail.setInjectionCentre(dto.getInjectionCentre());
            detail.setInjectionRight(dto.getInjectionRight());
            detail.setInjectionAverage(dto.getInjectionAverage());

            detail.setGap(dto.getGap());

            detail.setRemarks(dto.getRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getSyntheticResinInjectionHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId,
            String updatedBy) {

        SyntheticResinInjectionHeader header = headerRepository
                .findById(syntheticResinInjectionHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Synthetic Resin Injection not found with Id : "
                                        + syntheticResinInjectionHeaderId));

        // Soft Delete Header

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Details

        if (header.getDetails() != null) {

            for (SyntheticResinInjectionDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }
}
