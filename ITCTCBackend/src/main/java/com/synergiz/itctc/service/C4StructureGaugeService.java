package com.synergiz.itctc.service;

import java.util.List;

import com.synergiz.itctc.dto.request.C4StructureGaugeRequest;
import com.synergiz.itctc.dto.response.C4StructureGaugeResponse;

public interface C4StructureGaugeService {

    // =========================================================
    // CREATE
    // =========================================================

    C4StructureGaugeResponse saveC4StructureGauge(
            C4StructureGaugeRequest request);

    // =========================================================
    // GET BY ID
    // =========================================================

    C4StructureGaugeResponse getC4StructureGauge(
            Long c4StructureGaugeId);

    // =========================================================
    // GET ALL
    // =========================================================

    List<C4StructureGaugeResponse> getAllC4StructureGauge();

    // =========================================================
    // UPDATE
    // =========================================================

    C4StructureGaugeResponse updateC4StructureGauge(
            Long c4StructureGaugeId,
            C4StructureGaugeRequest request);

    // =========================================================
    // DELETE - SOFT DELETE
    // =========================================================

    String deleteC4StructureGauge(
            Long c4StructureGaugeId,
            String updatedBy);
}
