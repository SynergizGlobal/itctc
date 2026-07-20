package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.CamMeasurementDetailRequest;
import com.synergiz.itctc.dto.request.CamMeasurementRequest;
import com.synergiz.itctc.dto.response.CamMeasurementDetailResponse;
import com.synergiz.itctc.dto.response.CamMeasurementResponse;
import com.synergiz.itctc.entity.CamMeasurementDetail;
import com.synergiz.itctc.entity.CamMeasurementHeader;
import com.synergiz.itctc.entity.TrackDirection;
import com.synergiz.itctc.repository.CamMeasurementDetailRepository;
import com.synergiz.itctc.repository.CamMeasurementHeaderRepository;
import com.synergiz.itctc.repository.TrackDirectionRepository;
import com.synergiz.itctc.service.CamMeasurementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CamMeasurementServiceImpl implements CamMeasurementService {

    private final CamMeasurementHeaderRepository headerRepository;

    private final CamMeasurementDetailRepository detailRepository;

    private final TrackDirectionRepository trackDirectionRepository;

    public CamMeasurementServiceImpl(
            CamMeasurementHeaderRepository headerRepository,
            CamMeasurementDetailRepository detailRepository,
            TrackDirectionRepository trackDirectionRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
        this.trackDirectionRepository = trackDirectionRepository;
    }
    
    @Override
    @Transactional
    public Long saveCamMeasurement(CamMeasurementRequest request) {

        CamMeasurementHeader header = new CamMeasurementHeader();

       

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setIsActive(true);

        header.setCreatedBy(request.getCreatedBy());
        header.setCreatedDate(LocalDateTime.now());

       

        if (request.getDetails() != null) {

            for (CamMeasurementDetailRequest dto : request.getDetails()) {

                TrackDirection trackDirection = trackDirectionRepository
                        .findById(dto.getTrackDirectionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Invalid Track Direction Id : "
                                                + dto.getTrackDirectionId()));

                CamMeasurementDetail detail = new CamMeasurementDetail();

                detail.setTrackDirection(trackDirection);

                detail.setRcAnchorSerialNo(dto.getRcAnchorSerialNo());

                detail.setChainageKm(dto.getChainageKm());
                detail.setChainageM(dto.getChainageM());

                detail.setTrackSlabNumber(dto.getTrackSlabNumber());
                detail.setTrackSlabType(dto.getTrackSlabType());

                detail.setResinOriginThickness(dto.getResinOriginThickness());
                detail.setResinEndThickness(dto.getResinEndThickness());

                detail.setCamThickness1(dto.getCamThickness1());
                detail.setCamThickness2(dto.getCamThickness2());
                detail.setCamThickness3(dto.getCamThickness3());
                detail.setCamThickness4(dto.getCamThickness4());
                detail.setCamThickness5(dto.getCamThickness5());
                detail.setCamThickness6(dto.getCamThickness6());
                detail.setCamThickness7(dto.getCamThickness7());
                detail.setCamThickness8(dto.getCamThickness8());

                detail.setCamAverageThickness(dto.getCamAverageThickness());

                detail.setGapOrigin(dto.getGapOrigin());
                detail.setGapEnd(dto.getGapEnd());

                detail.setReferencePinOrigin(dto.getReferencePinOrigin());
                detail.setReferencePinEnd(dto.getReferencePinEnd());

                detail.setRemarks(dto.getRemarks());

                detail.setCamMeasurementHeader(header);

                detail.setIsActive(true);

                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getCamMeasurementHeaderId();
    }
    
    @Override
    public CamMeasurementResponse getCamMeasurement(Long camMeasurementHeaderId) {

        CamMeasurementHeader header = headerRepository
                .findById(camMeasurementHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "CAM Measurement not found with Id : "
                                        + camMeasurementHeaderId));

        CamMeasurementResponse response = new CamMeasurementResponse();


        response.setCamMeasurementHeaderId(
                header.getCamMeasurementHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setRecordNo(header.getRecordNo());
        response.setInspectionDate(header.getInspectionDate());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());



        List<CamMeasurementDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (CamMeasurementDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                CamMeasurementDetailResponse dto =
                        new CamMeasurementDetailResponse();

                dto.setCamMeasurementDetailId(
                        detail.getCamMeasurementDetailId());

                dto.setTrackDirectionId(
                        detail.getTrackDirection().getTrackDirectionId());

                dto.setTrackDirectionName(
                        detail.getTrackDirection().getDirectionName());

                dto.setRcAnchorSerialNo(
                        detail.getRcAnchorSerialNo());

                dto.setChainageKm(detail.getChainageKm());
                dto.setChainageM(detail.getChainageM());

                dto.setTrackSlabNumber(
                        detail.getTrackSlabNumber());

                dto.setTrackSlabType(
                        detail.getTrackSlabType());

                dto.setResinOriginThickness(
                        detail.getResinOriginThickness());

                dto.setResinEndThickness(
                        detail.getResinEndThickness());

                dto.setCamThickness1(detail.getCamThickness1());
                dto.setCamThickness2(detail.getCamThickness2());
                dto.setCamThickness3(detail.getCamThickness3());
                dto.setCamThickness4(detail.getCamThickness4());
                dto.setCamThickness5(detail.getCamThickness5());
                dto.setCamThickness6(detail.getCamThickness6());
                dto.setCamThickness7(detail.getCamThickness7());
                dto.setCamThickness8(detail.getCamThickness8());

                dto.setCamAverageThickness(
                        detail.getCamAverageThickness());

                dto.setGapOrigin(detail.getGapOrigin());
                dto.setGapEnd(detail.getGapEnd());

                dto.setReferencePinOrigin(
                        detail.getReferencePinOrigin());

                dto.setReferencePinEnd(
                        detail.getReferencePinEnd());

                dto.setRemarks(detail.getRemarks());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    @Override
    public List<CamMeasurementResponse> getAllCamMeasurements() {

        List<CamMeasurementHeader> headers = headerRepository.findAll();

        List<CamMeasurementResponse> responses = new ArrayList<>();

        for (CamMeasurementHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            CamMeasurementResponse response = new CamMeasurementResponse();

          

            response.setCamMeasurementHeaderId(
                    header.getCamMeasurementHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setRecordNo(header.getRecordNo());
            response.setInspectionDate(header.getInspectionDate());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

   

            List<CamMeasurementDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (CamMeasurementDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    CamMeasurementDetailResponse dto =
                            new CamMeasurementDetailResponse();

                    dto.setCamMeasurementDetailId(
                            detail.getCamMeasurementDetailId());

                    dto.setTrackDirectionId(
                            detail.getTrackDirection().getTrackDirectionId());

                    dto.setTrackDirectionName(
                            detail.getTrackDirection().getDirectionName());

                    dto.setRcAnchorSerialNo(
                            detail.getRcAnchorSerialNo());

                    dto.setChainageKm(detail.getChainageKm());
                    dto.setChainageM(detail.getChainageM());

                    dto.setTrackSlabNumber(
                            detail.getTrackSlabNumber());

                    dto.setTrackSlabType(
                            detail.getTrackSlabType());

                    dto.setResinOriginThickness(
                            detail.getResinOriginThickness());

                    dto.setResinEndThickness(
                            detail.getResinEndThickness());

                    dto.setCamThickness1(detail.getCamThickness1());
                    dto.setCamThickness2(detail.getCamThickness2());
                    dto.setCamThickness3(detail.getCamThickness3());
                    dto.setCamThickness4(detail.getCamThickness4());
                    dto.setCamThickness5(detail.getCamThickness5());
                    dto.setCamThickness6(detail.getCamThickness6());
                    dto.setCamThickness7(detail.getCamThickness7());
                    dto.setCamThickness8(detail.getCamThickness8());

                    dto.setCamAverageThickness(
                            detail.getCamAverageThickness());

                    dto.setGapOrigin(detail.getGapOrigin());
                    dto.setGapEnd(detail.getGapEnd());

                    dto.setReferencePinOrigin(
                            detail.getReferencePinOrigin());

                    dto.setReferencePinEnd(
                            detail.getReferencePinEnd());

                    dto.setRemarks(detail.getRemarks());

                    detailResponses.add(dto);
                }
            }

            response.setDetails(detailResponses);

            responses.add(response);
        }

        return responses;
    }
    
    @Override
    @Transactional
    public Long updateCamMeasurement(
            Long camMeasurementHeaderId,
            CamMeasurementRequest request) {

        CamMeasurementHeader header = headerRepository
                .findById(camMeasurementHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "CAM Measurement not found with Id : "
                                        + camMeasurementHeaderId));

 
        // Update Header


        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

  
        // Soft Delete Removed Details


        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(CamMeasurementDetailRequest::getCamMeasurementDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (CamMeasurementDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getCamMeasurementDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }


        // Insert / Update Details


        for (CamMeasurementDetailRequest dto : request.getDetails()) {

            TrackDirection trackDirection = trackDirectionRepository
                    .findById(dto.getTrackDirectionId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Invalid Track Direction Id"));

            CamMeasurementDetail detail;


            // UPDATE EXISTING DETAIL
   

            if (dto.getCamMeasurementDetailId() != null) {

                detail = header.getDetails().stream()
                        .filter(d -> d.getCamMeasurementDetailId()
                                .equals(dto.getCamMeasurementDetailId()))
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "CAM Measurement Detail not found with Id : "
                                                + dto.getCamMeasurementDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }


            // INSERT NEW DETAIL


            else {

                detail = new CamMeasurementDetail();

                detail.setCamMeasurementHeader(header);

                detail.setCreatedBy(request.getUpdatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                detail.setIsActive(true);

                header.getDetails().add(detail);
            }

            detail.setTrackDirection(trackDirection);

            detail.setRcAnchorSerialNo(dto.getRcAnchorSerialNo());

            detail.setChainageKm(dto.getChainageKm());
            detail.setChainageM(dto.getChainageM());

            detail.setTrackSlabNumber(dto.getTrackSlabNumber());
            detail.setTrackSlabType(dto.getTrackSlabType());

            detail.setResinOriginThickness(dto.getResinOriginThickness());
            detail.setResinEndThickness(dto.getResinEndThickness());

            detail.setCamThickness1(dto.getCamThickness1());
            detail.setCamThickness2(dto.getCamThickness2());
            detail.setCamThickness3(dto.getCamThickness3());
            detail.setCamThickness4(dto.getCamThickness4());
            detail.setCamThickness5(dto.getCamThickness5());
            detail.setCamThickness6(dto.getCamThickness6());
            detail.setCamThickness7(dto.getCamThickness7());
            detail.setCamThickness8(dto.getCamThickness8());

            detail.setCamAverageThickness(dto.getCamAverageThickness());

            detail.setGapOrigin(dto.getGapOrigin());
            detail.setGapEnd(dto.getGapEnd());

            detail.setReferencePinOrigin(dto.getReferencePinOrigin());
            detail.setReferencePinEnd(dto.getReferencePinEnd());

            detail.setRemarks(dto.getRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getCamMeasurementHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteCamMeasurement(
            Long camMeasurementHeaderId,
            String updatedBy) {

        CamMeasurementHeader header = headerRepository
                .findById(camMeasurementHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "CAM Measurement not found with Id : "
                                        + camMeasurementHeaderId));


        // Soft Delete Header
    

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());


        // Soft Delete Details


        if (header.getDetails() != null) {

            for (CamMeasurementDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }

}