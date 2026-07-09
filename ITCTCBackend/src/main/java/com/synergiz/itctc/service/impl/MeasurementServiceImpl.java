package com.synergiz.itctc.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.dto.request.MeasurementDetailRequest;
import com.synergiz.itctc.dto.request.MeasurementRequest;
import com.synergiz.itctc.dto.request.MeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.MeasurementDetailResponse;
import com.synergiz.itctc.dto.response.MeasurementResponse;
import com.synergiz.itctc.entity.MeasurementDetail;
import com.synergiz.itctc.entity.MeasurementHeader;
import com.synergiz.itctc.entity.StructureType;
import com.synergiz.itctc.entity.TrackType;
import com.synergiz.itctc.repository.MeasurementHeaderRepository;
import com.synergiz.itctc.repository.StructureTypeRepository;
import com.synergiz.itctc.repository.TrackTypeRepository;
import com.synergiz.itctc.service.MeasurementService;

@Service
@Transactional
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementHeaderRepository measurementHeaderRepository;
    private final StructureTypeRepository structureTypeRepository;
    private final TrackTypeRepository trackTypeRepository;

    public MeasurementServiceImpl(
            MeasurementHeaderRepository measurementHeaderRepository,
            StructureTypeRepository structureTypeRepository,
            TrackTypeRepository trackTypeRepository) {

        this.measurementHeaderRepository = measurementHeaderRepository;
        this.structureTypeRepository = structureTypeRepository;
        this.trackTypeRepository = trackTypeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public MeasurementResponse getMeasurement(Long measurementId) {

        MeasurementHeader header = measurementHeaderRepository.findById(measurementId)
                .orElseThrow(() -> new RuntimeException("Measurement not found with Id : " + measurementId));

        MeasurementResponse response = new MeasurementResponse();

        response.setMeasurementId(header.getMeasurementId());
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

        List<MeasurementDetailResponse> detailResponses = new ArrayList<>();

        for (MeasurementDetail detail : header.getDetails()) {

            MeasurementDetailResponse detailResponse = new MeasurementDetailResponse();

            detailResponse.setMeasurementDetailId(detail.getMeasurementDetailId());

            detailResponse.setaMeasured(detail.getAMeasured());
            detailResponse.setX1Calculated(detail.getX1Calculated());
            detailResponse.setaStandard(detail.getaStandard());
            detailResponse.setaMeasuredTotal(detail.getAMeasuredTotal());

            detailResponse.setbMeasured(detail.getBMeasured());
            detailResponse.setbPrimeMeasured(detail.getBPrimeMeasured());
            detailResponse.setbStandard(detail.getBStandard());
            detailResponse.setbTotalMeasured(detail.getBTotalMeasured());

            detailResponse.setcMeasured(detail.getCMeasured());
            detailResponse.setX2Calculated(detail.getX2Calculated());
            detailResponse.setcStandard(detail.getCStandard());
            detailResponse.setcTotalMeasured(detail.getCTotalMeasured());

            detailResponse.setdStandard(detail.getDStandard());
            detailResponse.setdMeasured(detail.getDMeasured());

            detailResponses.add(detailResponse);
        }

        response.setDetails(detailResponses);

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MeasurementResponse> getAllMeasurements() {

        List<MeasurementHeader> headers = measurementHeaderRepository.findByIsActiveTrue();

        List<MeasurementResponse> responses = new ArrayList<>();

        for (MeasurementHeader header : headers) {

            MeasurementResponse response = new MeasurementResponse();

            response.setMeasurementId(header.getMeasurementId());
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

            List<MeasurementDetailResponse> detailResponses = new ArrayList<>();

            for (MeasurementDetail detail : header.getDetails()) {

                MeasurementDetailResponse detailResponse = new MeasurementDetailResponse();

                detailResponse.setMeasurementDetailId(detail.getMeasurementDetailId());

                detailResponse.setaMeasured(detail.getAMeasured());
                detailResponse.setX1Calculated(detail.getX1Calculated());
                detailResponse.setaStandard(detail.getaStandard());
                detailResponse.setaMeasuredTotal(detail.getAMeasuredTotal());

                detailResponse.setbMeasured(detail.getBMeasured());
                detailResponse.setbPrimeMeasured(detail.getBPrimeMeasured());
                detailResponse.setbStandard(detail.getBStandard());
                detailResponse.setbTotalMeasured(detail.getBTotalMeasured());

                detailResponse.setcMeasured(detail.getCMeasured());
                detailResponse.setX2Calculated(detail.getX2Calculated());
                detailResponse.setcStandard(detail.getCStandard());
                detailResponse.setcTotalMeasured(detail.getCTotalMeasured());

                detailResponse.setdStandard(detail.getDStandard());
                detailResponse.setdMeasured(detail.getDMeasured());

                detailResponses.add(detailResponse);
            }

            response.setDetails(detailResponses);

            responses.add(response);
        }

        return responses;
    }

    @Override
    @Transactional
    public Long updateMeasurement(Long measurementId, MeasurementUpdateRequest request) {

        MeasurementHeader header = measurementHeaderRepository.findById(measurementId)
                .orElseThrow(() ->
                        new RuntimeException("Measurement not found with Id : " + measurementId));

        StructureType structureType = structureTypeRepository
                .findById(request.getStructureTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Structure Type Id"));

        TrackType trackType = trackTypeRepository
                .findById(request.getTrackTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Track Type Id"));

        // Update Header
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

        // Clear existing details (orphanRemoval=true will delete them)
        header.getDetails().clear();

        // Add new details
        if (request.getDetails() != null && !request.getDetails().isEmpty()) {

            for (MeasurementDetailRequest dto : request.getDetails()) {

                MeasurementDetail detail = new MeasurementDetail();

                detail.setAMeasured(dto.getaMeasured());
                detail.setX1Calculated(dto.getX1Calculated());
                detail.setaStandard(dto.getaStandard());
                detail.setAMeasuredTotal(dto.getaMeasuredTotal());

                detail.setBMeasured(dto.getbMeasured());
                detail.setBPrimeMeasured(dto.getbPrimeMeasured());
                detail.setBStandard(dto.getbStandard());
                detail.setBTotalMeasured(dto.getbTotalMeasured());

                detail.setCMeasured(dto.getcMeasured());
                detail.setX2Calculated(dto.getX2Calculated());
                detail.setCStandard(dto.getcStandard());
                detail.setCTotalMeasured(dto.getcTotalMeasured());

                detail.setDMeasured(dto.getdMeasured());
                detail.setDStandard(dto.getdStandard());

                detail.setMeasurementHeader(header);
                detail.setCreatedDate(LocalDateTime.now());
                detail.setIsActive(true);

                // Add directly to the managed collection
                header.getDetails().add(detail);
            }
        }

        MeasurementHeader updatedHeader = measurementHeaderRepository.save(header);

        return updatedHeader.getMeasurementId();
    }

    @Override
    @Transactional
    public Long deleteMeasurement(Long measurementId) {

        MeasurementHeader header = measurementHeaderRepository.findById(measurementId)
                .orElseThrow(() ->
                        new RuntimeException("Measurement not found with Id : " + measurementId));

        header.setIsActive(false);
        header.setUpdatedDate(LocalDateTime.now());

        if (header.getDetails() != null) {
            for (MeasurementDetail detail : header.getDetails()) {
                detail.setIsActive(false);
            }
        }

        measurementHeaderRepository.save(header);

        return header.getMeasurementId();
    }
    
    @Override
    public Long saveMeasurement(MeasurementRequest request) {

        StructureType structureType = structureTypeRepository
                .findById(request.getStructureTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Structure Type Id"));

        TrackType trackType = trackTypeRepository
                .findById(request.getTrackTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Track Type Id"));

        MeasurementHeader header = new MeasurementHeader();

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

        List<MeasurementDetail> details = new ArrayList<>();

        if (request.getDetails() != null && !request.getDetails().isEmpty()) {

            for (MeasurementDetailRequest dto : request.getDetails()) {

                MeasurementDetail detail = new MeasurementDetail();

                detail.setAMeasured(dto.getaMeasured());
                detail.setX1Calculated(dto.getX1Calculated());
                detail.setaStandard(dto.getaStandard());
                detail.setAMeasuredTotal(dto.getaMeasuredTotal());

                detail.setBMeasured(dto.getaMeasured());
                detail.setBPrimeMeasured(dto.getbPrimeMeasured());
                detail.setBStandard(dto.getbStandard());
                detail.setBTotalMeasured(dto.getbTotalMeasured());

                detail.setCMeasured(dto.getcMeasured());
                detail.setX2Calculated(dto.getX2Calculated());
                detail.setCStandard(dto.getcStandard());
                detail.setCTotalMeasured(dto.getcTotalMeasured());

                detail.setDStandard(dto.getdStandard());
                detail.setDMeasured(dto.getdMeasured());

                detail.setMeasurementHeader(header);
                detail.setCreatedDate(LocalDateTime.now());
                detail.setIsActive(true);

                details.add(detail);
            }
        }

        header.setDetails(details);

        MeasurementHeader savedHeader = measurementHeaderRepository.save(header);

        return savedHeader.getMeasurementId();
    }
}