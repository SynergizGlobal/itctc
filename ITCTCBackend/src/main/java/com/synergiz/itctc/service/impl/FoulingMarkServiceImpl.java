package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.FoulingMarkDetailRequest;
import com.synergiz.itctc.dto.request.FoulingMarkRequest;
import com.synergiz.itctc.dto.response.FoulingMarkDetailResponse;
import com.synergiz.itctc.dto.response.FoulingMarkResponse;
import com.synergiz.itctc.entity.FoulingMarkDetail;
import com.synergiz.itctc.entity.FoulingMarkHeader;
import com.synergiz.itctc.repository.FoulingMarkDetailRepository;
import com.synergiz.itctc.repository.FoulingMarkHeaderRepository;
import com.synergiz.itctc.service.FoulingMarkService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoulingMarkServiceImpl
        implements FoulingMarkService {

    private final FoulingMarkHeaderRepository headerRepository;

    private final FoulingMarkDetailRepository detailRepository;

    public FoulingMarkServiceImpl(
            FoulingMarkHeaderRepository headerRepository,
            FoulingMarkDetailRepository detailRepository) {

        this.headerRepository = headerRepository;
        this.detailRepository = detailRepository;
    }

    
    @Override
    @Transactional
    public Long saveFoulingMark(
            FoulingMarkRequest request) {

        FoulingMarkHeader header = new FoulingMarkHeader();

        // Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());
        header.setLineName(request.getLineName());

        header.setIsActive(true);

        header.setCreatedBy(request.getCreatedBy());
        header.setCreatedDate(LocalDateTime.now());

        // Details

        if (request.getDetails() != null) {

            for (FoulingMarkDetailRequest dto : request.getDetails()) {

                FoulingMarkDetail detail = new FoulingMarkDetail();

                detail.setFoulingMarkHeader(header);

                detail.setChainageLocation(dto.getChainageLocation());

                detail.setDesignValue(dto.getDesignValue());
                detail.setMeasuredValue(dto.getMeasuredValue());
                detail.setDifferenceValue(dto.getDifferenceValue());

                detail.setRemarks(dto.getRemarks());

                detail.setIsActive(true);

                detail.setCreatedBy(request.getCreatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                header.getDetails().add(detail);
            }
        }

        headerRepository.save(header);

        return header.getFoulingMarkHeaderId();
    }
    
    @Override
    public FoulingMarkResponse getFoulingMark(
            Long foulingMarkHeaderId) {

        FoulingMarkHeader header = headerRepository
                .findById(foulingMarkHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fouling Mark not found with Id : "
                                        + foulingMarkHeaderId));

        FoulingMarkResponse response = new FoulingMarkResponse();

        // Header

        response.setFoulingMarkHeaderId(
                header.getFoulingMarkHeaderId());

        response.setProjectId(header.getProjectId());
        response.setFormNo(header.getFormNo());
        response.setRecordNo(header.getRecordNo());
        response.setInspectionDate(header.getInspectionDate());
        response.setLineName(header.getLineName());

        response.setCreatedBy(header.getCreatedBy());
        response.setCreatedDate(header.getCreatedDate());

        // Details


        List<FoulingMarkDetailResponse> detailResponses =
                new ArrayList<>();

        if (header.getDetails() != null) {

            for (FoulingMarkDetail detail : header.getDetails()) {

                if (!Boolean.TRUE.equals(detail.getIsActive())) {
                    continue;
                }

                FoulingMarkDetailResponse dto =
                        new FoulingMarkDetailResponse();

                dto.setFoulingMarkDetailId(
                        detail.getFoulingMarkDetailId());

                dto.setChainageLocation(
                        detail.getChainageLocation());

                dto.setDesignValue(
                        detail.getDesignValue());

                dto.setMeasuredValue(
                        detail.getMeasuredValue());

                dto.setDifferenceValue(
                        detail.getDifferenceValue());

                dto.setRemarks(
                        detail.getRemarks());

                detailResponses.add(dto);
            }
        }

        response.setDetails(detailResponses);

        return response;
    }
    
    @Override
    public List<FoulingMarkResponse> getAllFoulingMarks() {

        List<FoulingMarkHeader> headers = headerRepository.findAll();

        List<FoulingMarkResponse> responseList = new ArrayList<>();

        for (FoulingMarkHeader header : headers) {

            if (!Boolean.TRUE.equals(header.getIsActive())) {
                continue;
            }

            FoulingMarkResponse response =
                    new FoulingMarkResponse();

            // Header

            response.setFoulingMarkHeaderId(
                    header.getFoulingMarkHeaderId());

            response.setProjectId(header.getProjectId());
            response.setFormNo(header.getFormNo());
            response.setRecordNo(header.getRecordNo());
            response.setInspectionDate(header.getInspectionDate());
            response.setLineName(header.getLineName());

            response.setCreatedBy(header.getCreatedBy());
            response.setCreatedDate(header.getCreatedDate());

            // Details
            
            List<FoulingMarkDetailResponse> detailResponses =
                    new ArrayList<>();

            if (header.getDetails() != null) {

                for (FoulingMarkDetail detail : header.getDetails()) {

                    if (!Boolean.TRUE.equals(detail.getIsActive())) {
                        continue;
                    }

                    FoulingMarkDetailResponse dto =
                            new FoulingMarkDetailResponse();

                    dto.setFoulingMarkDetailId(
                            detail.getFoulingMarkDetailId());

                    dto.setChainageLocation(
                            detail.getChainageLocation());

                    dto.setDesignValue(
                            detail.getDesignValue());

                    dto.setMeasuredValue(
                            detail.getMeasuredValue());

                    dto.setDifferenceValue(
                            detail.getDifferenceValue());

                    dto.setRemarks(
                            detail.getRemarks());

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
    public Long updateFoulingMark(
            Long foulingMarkHeaderId,
            FoulingMarkRequest request) {

        FoulingMarkHeader header = headerRepository
                .findById(foulingMarkHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fouling Mark not found with Id : "
                                        + foulingMarkHeaderId));

        // Update Header

        header.setProjectId(request.getProjectId());
        header.setFormNo(request.getFormNo());
        header.setRecordNo(request.getRecordNo());
        header.setInspectionDate(request.getInspectionDate());
        header.setLineName(request.getLineName());

        header.setUpdatedBy(request.getUpdatedBy());
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Removed Details


        Set<Long> requestDetailIds = request.getDetails().stream()
                .map(FoulingMarkDetailRequest::getFoulingMarkDetailId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (FoulingMarkDetail existingDetail : header.getDetails()) {

            if (!requestDetailIds.contains(
                    existingDetail.getFoulingMarkDetailId())) {

                existingDetail.setIsActive(false);
                existingDetail.setUpdatedBy(request.getUpdatedBy());
                existingDetail.setUpdatedDate(LocalDateTime.now());
            }
        }

        // Insert / Update Details


        for (FoulingMarkDetailRequest dto : request.getDetails()) {

            FoulingMarkDetail detail;

            // UPDATE EXISTING DETAIL

            if (dto.getFoulingMarkDetailId() != null) {

                detail = detailRepository
                        .findById(dto.getFoulingMarkDetailId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Fouling Mark Detail not found with Id : "
                                                + dto.getFoulingMarkDetailId()));

                detail.setUpdatedBy(request.getUpdatedBy());
                detail.setUpdatedDate(LocalDateTime.now());
            }

            // INSERT NEW DETAIL

            else {

                detail = new FoulingMarkDetail();

                detail.setFoulingMarkHeader(header);

                detail.setCreatedBy(request.getUpdatedBy());
                detail.setCreatedDate(LocalDateTime.now());

                detail.setIsActive(true);

                header.getDetails().add(detail);
            }

            detail.setChainageLocation(dto.getChainageLocation());

            detail.setDesignValue(dto.getDesignValue());
            detail.setMeasuredValue(dto.getMeasuredValue());
            detail.setDifferenceValue(dto.getDifferenceValue());

            detail.setRemarks(dto.getRemarks());

            detail.setIsActive(true);
        }

        headerRepository.save(header);

        return header.getFoulingMarkHeaderId();
    }
    
    @Override
    @Transactional
    public void deleteFoulingMark(
            Long foulingMarkHeaderId,
            String updatedBy) {

        FoulingMarkHeader header = headerRepository
                .findById(foulingMarkHeaderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fouling Mark not found with Id : "
                                        + foulingMarkHeaderId));

        // Soft Delete Header
        
        header.setIsActive(false);
        header.setUpdatedBy(updatedBy);
        header.setUpdatedDate(LocalDateTime.now());

        // Soft Delete Details

        if (header.getDetails() != null) {

            for (FoulingMarkDetail detail : header.getDetails()) {

                detail.setIsActive(false);
                detail.setUpdatedBy(updatedBy);
                detail.setUpdatedDate(LocalDateTime.now());
            }
        }

        headerRepository.save(header);
    }
}