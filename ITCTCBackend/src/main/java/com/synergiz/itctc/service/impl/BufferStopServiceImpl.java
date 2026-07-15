package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.BufferStopDetailRequest;
import com.synergiz.itctc.dto.request.BufferStopRequest;
import com.synergiz.itctc.dto.response.BufferStopDetailResponse;
import com.synergiz.itctc.dto.response.BufferStopResponse;
import com.synergiz.itctc.entity.BufferStopDetail;
import com.synergiz.itctc.entity.BufferStopHeader;
import com.synergiz.itctc.repository.BufferStopDetailRepository;
import com.synergiz.itctc.repository.BufferStopHeaderRepository;
import com.synergiz.itctc.service.BufferStopService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BufferStopServiceImpl implements BufferStopService {

    private final BufferStopHeaderRepository headerRepository;

    private final BufferStopDetailRepository detailRepository;

    public BufferStopServiceImpl(
            BufferStopHeaderRepository headerRepository,
            BufferStopDetailRepository detailRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
    }
    
    @Override
    @Transactional
    public Long saveBufferStop(BufferStopRequest request) {

        BufferStopHeader header = new BufferStopHeader();

        // Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setLineName(request.getLineName());
        header.setInspectionDate(request.getInspectionDate());

        header.setIsActive(true);
        header.setCreatedBy(request.getCreatedBy());
        header.setCreatedDate(LocalDateTime.now());

        // Details

        if (request.getDetails() != null) {

            for (BufferStopDetailRequest dto : request.getDetails()) {

                BufferStopDetail detail = new BufferStopDetail();

                detail.setBufferStopHeader(header);

                detail.setLocation(dto.getLocation());

                detail.setMeasurementPoint1(dto.getMeasurementPoint1());
                detail.setMeasurementPoint2(dto.getMeasurementPoint2());
                detail.setMeasurementPoint3(dto.getMeasurementPoint3());
                detail.setMeasurementPoint4(dto.getMeasurementPoint4());
                detail.setMeasurementPoint5(dto.getMeasurementPoint5());

                detail.setIsActive(true);
                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getBufferStopHeaderId();
    }
    
    @Override
    public BufferStopResponse getBufferStop(
            Long bufferStopHeaderId) {

        BufferStopHeader header = headerRepository
                .findById(bufferStopHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Buffer Stop not found with Id : "
                                        + bufferStopHeaderId));

        BufferStopResponse response = new BufferStopResponse();

        // Header

        response.setBufferStopHeaderId(
                header.getBufferStopHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setLineName(header.getLineName());
        response.setInspectionDate(header.getInspectionDate());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());

        // Details

        List<BufferStopDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (BufferStopDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                BufferStopDetailResponse dto =
                        new BufferStopDetailResponse();

                dto.setBufferStopDetailId(
                        detail.getBufferStopDetailId());

                dto.setLocation(detail.getLocation());

                dto.setMeasurementPoint1(
                        detail.getMeasurementPoint1());

                dto.setMeasurementPoint2(
                        detail.getMeasurementPoint2());

                dto.setMeasurementPoint3(
                        detail.getMeasurementPoint3());

                dto.setMeasurementPoint4(
                        detail.getMeasurementPoint4());

                dto.setMeasurementPoint5(
                        detail.getMeasurementPoint5());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }

    
    @Override
    public List<BufferStopResponse> getAllBufferStops() {

        List<BufferStopHeader> headers = headerRepository.findAll();

        List<BufferStopResponse> responseList = new ArrayList<>();

        for (BufferStopHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            BufferStopResponse response = new BufferStopResponse();

            // Header

            response.setBufferStopHeaderId(
                    header.getBufferStopHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setLineName(header.getLineName());
            response.setInspectionDate(header.getInspectionDate());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

            // Details

            List<BufferStopDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (BufferStopDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    BufferStopDetailResponse dto =
                            new BufferStopDetailResponse();

                    dto.setBufferStopDetailId(
                            detail.getBufferStopDetailId());

                    dto.setLocation(detail.getLocation());

                    dto.setMeasurementPoint1(
                            detail.getMeasurementPoint1());

                    dto.setMeasurementPoint2(
                            detail.getMeasurementPoint2());

                    dto.setMeasurementPoint3(
                            detail.getMeasurementPoint3());

                    dto.setMeasurementPoint4(
                            detail.getMeasurementPoint4());

                    dto.setMeasurementPoint5(
                            detail.getMeasurementPoint5());

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
    public Long updateBufferStop(
            Long bufferStopHeaderId,
            BufferStopRequest request) {

        BufferStopHeader header = headerRepository
                .findById(bufferStopHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Buffer Stop not found with Id : "
                                        + bufferStopHeaderId));

        // Update Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setLineName(request.getLineName());
        header.setInspectionDate(request.getInspectionDate());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Removed Details

        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(BufferStopDetailRequest::getBufferStopDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (BufferStopDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getBufferStopDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }

        // Insert / Update Details

        for (BufferStopDetailRequest dto : request.getDetails()) {

            BufferStopDetail detail;

            // UPDATE EXISTING DETAIL

            if (dto.getBufferStopDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getBufferStopDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Buffer Stop Detail not found with Id : "
                                                + dto.getBufferStopDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }

            // INSERT NEW DETAIL

            else {

                detail = new BufferStopDetail();

                detail.setBufferStopHeader(header);

                detail.setCreatedBy(request.getUpdatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                detail.setIsActive(true);

                header.getDetails().add(detail);
            }

            detail.setLocation(dto.getLocation());

            detail.setMeasurementPoint1(dto.getMeasurementPoint1());
            detail.setMeasurementPoint2(dto.getMeasurementPoint2());
            detail.setMeasurementPoint3(dto.getMeasurementPoint3());
            detail.setMeasurementPoint4(dto.getMeasurementPoint4());
            detail.setMeasurementPoint5(dto.getMeasurementPoint5());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getBufferStopHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteBufferStop(
            Long bufferStopHeaderId,
            String updatedBy) {

        BufferStopHeader header = headerRepository
                .findById(bufferStopHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Buffer Stop not found with Id : "
                                        + bufferStopHeaderId));

        // Soft Delete Header

        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Details

        if (header.getDetails() != null) {

            for (BufferStopDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }
}